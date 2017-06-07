package szi.parsers;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public class ExcelParserTest {

    private static final String path = "C:\\Users\\NM.Rabotaev\\IdeaProjects\\gaiman\\src\\main\\resources\\threats.xls";
    private static final String sheetName = "threats";
    private final static Logger logger = LoggerFactory.getLogger(ExcelParserTest.class);


    @Test
    public void testRead() {
            ExcelParser eh = new ExcelParser(path);
            try {
                Workbook workbook = eh.getWorkbook();

                Sheet sheet = workbook.getSheet(sheetName);
                for (Row r : sheet) {
                    Iterator<Cell> cellIterator = r.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell c = cellIterator.next();
                        logger.info("row number = " + r.getRowNum()
                                + "; column index = " + c.getColumnIndex()
                                + "; cell value = " + eh.getCellStringValue(c));
                    }
                }
            } catch (EncryptedDocumentException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
}