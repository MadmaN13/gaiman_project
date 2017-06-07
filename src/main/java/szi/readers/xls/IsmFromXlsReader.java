package szi.readers.xls;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szi.common.Constants;
import szi.model.Ism;
import szi.model.Threat;
import szi.utils.common.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static szi.readers.xls.XlsHeaders.IsmXlsHeader.*;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class IsmFromXlsReader extends AbstractXlsReader {
    private final static Logger logger = LoggerFactory.getLogger(AbstractXlsReader.class);

    private List<Threat> threats;

    public IsmFromXlsReader(String filePath, String sheetName, List<Threat> threats) {
        super(filePath, sheetName);
        this.threats = threats;
    }

    @Override
    public List<Ism> read() {
        List<Ism> isms = new ArrayList<>();
        if (parser != null) {
            try {
                Workbook workbook = parser.getWorkbook();
                Sheet sheet = workbook.getSheet(sheetName);
                for (Row r : sheet) {
                    if (isHeaderRow(r)) continue;
                    Ism ism = fromRow(r);
                    if (ism.getId() > 0) isms.add(ism);
                }
            } catch (EncryptedDocumentException | IOException ex) {
                logger.error("Error while reading file: " + ex.getMessage());
            }
        }
        return isms;
    }

    private Ism fromRow(Row r) {
        Ism ism = new Ism();
        Iterator<Cell> cellIterator = r.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            int index = cell.getColumnIndex();
            String value = parser.getCellStringValue(cell);
            if (index == ID.getColumnIndex()) ism.setId(Double.valueOf(value).intValue());
            if (index == NAME.getColumnIndex()) ism.setName(value);
            if (index == COST.getColumnIndex()) ism.setCost(Double.valueOf(value));
            if (index == THREAT_IDS.getColumnIndex()) {
                if (value.contains(Constants.XLS_THREAT_SEPARATOR.getValue())) {
                    Set<Integer> parsedIds = StringUtil.parseIntsWithSeparator(value, Constants.XLS_THREAT_SEPARATOR.getValue());
                    parsedIds.forEach(id -> ism.getThreats().add(threats.get(id-1)));
                }
                else {
                    ism.getThreats().add(threats.get(Double.valueOf(value).intValue()-1));
                }
            }
        }
        return ism;
    }
}
