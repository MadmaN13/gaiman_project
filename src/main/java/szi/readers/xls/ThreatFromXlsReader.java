package szi.readers.xls;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import szi.model.Threat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static szi.readers.xls.XlsHeaders.ThreatXlsHeader.*;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class ThreatFromXlsReader extends AbstractXlsReader{
    private final static Logger logger = LoggerFactory.getLogger(ThreatFromXlsReader.class);

    public ThreatFromXlsReader(String filePath, String sheetName) {
        super(filePath,sheetName);
    }

    @Override
    public List<Threat> read() {
        List<Threat> threats = new ArrayList<>();
        if (parser != null) {
            try {
                Workbook workbook = parser.getWorkbook();
                Sheet sheet = workbook.getSheet(sheetName);
                for (Row r : sheet) {
                    if (isHeaderRow(r)) continue;
                    Threat threat = fromRow(r);
                    if (threat.getId() > 0) threats.add(threat);
                }
            } catch (EncryptedDocumentException | IOException ex) {
                logger.error("Error while reading file: " + ex.getMessage());
            }
        }
        return threats;
    }

    private Threat fromRow(Row r) {
        Threat threat = new Threat();
        Iterator<Cell> cellIterator = r.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            int index = cell.getColumnIndex();
            String value = parser.getCellStringValue(cell);
            if (index == ID.getColumnIndex()) threat.setId(Double.valueOf(value).intValue());
            if (index == NAME.getColumnIndex()) threat.setName(value);
            if (index == POSSIBILITY.getColumnIndex()) threat.setPossibility(Double.valueOf(value));
            if (index == HAZARD.getColumnIndex()) threat.setHazard(Double.valueOf(value).intValue());
            threat.setIsActual();
        }
        return threat;
    }
}
