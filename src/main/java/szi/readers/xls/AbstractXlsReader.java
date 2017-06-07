package szi.readers.xls;

import org.apache.poi.ss.usermodel.Row;
import szi.parsers.ExcelParser;
import szi.readers.DataReader;

/**
 * Created by NM.Rabotaev on 07.06.2017.
 */
public abstract class AbstractXlsReader implements DataReader {
    protected final static int HEADER_ROW_NUM = 0;

    protected String filePath;
    protected String sheetName;
    protected ExcelParser parser;

    public AbstractXlsReader(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
        parser = new ExcelParser(filePath);
    }

    protected boolean isHeaderRow(Row r) {
        return r.getRowNum() == HEADER_ROW_NUM;
    }
}
