package szi.parsers;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelParser implements Closeable  {

	private final String fileName;
	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelParser.class);
	private Workbook workBook = null;
	private FileInputStream fileInputStream = null;

	public String getFileName() {
		return fileName;
	}

	public ExcelParser(String fileName) throws IllegalArgumentException {
		if (fileName == null || fileName.isEmpty()
				|| !(fileName.endsWith("xls") || fileName.endsWith("xlsx"))) {
			System.out.println(fileName.endsWith("xls"));
			throw new IllegalArgumentException(
					"xls or xlsx file expected. Got " + fileName);
		}

		this.fileName = fileName.trim();
	}

	public Workbook getWorkbook() throws EncryptedDocumentException,
			IOException, UnknownError {
		if (!this.isOpen()) {
			this.open();
		}
		return this.workBook;
	}


	public Sheet getSheetByName(String sheetName)
			throws EncryptedDocumentException, IOException,
			IllegalArgumentException {
		Sheet sheet = this.getWorkbook().getSheet(sheetName);
		if (sheet == null) {
			throw new IllegalArgumentException("No sheet for name \""
					+ sheetName + "\"");
		}
		return sheet;
	}

	public String getCellStringValue(Cell cell)
			throws IllegalArgumentException, UnknownError {

		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				return String.valueOf(cell.getNumericCellValue());
			case Cell.CELL_TYPE_STRING:
				return String.valueOf(cell.getStringCellValue());
			case Cell.CELL_TYPE_BLANK:
				return "";
			default:
				throw new UnknownError(
						"Unexpected error while getting value from cell: "
								+ cell.toString());
			}
		}
		throw new IllegalArgumentException("The cell should not be null");
	}

	public boolean open() throws EncryptedDocumentException, IOException {
		try (FileInputStream fis = new FileInputStream(fileName)) {
			this.fileInputStream = fis;
			 if (this.fileName.endsWith("xls")) {
				this.workBook = new HSSFWorkbook(fileInputStream);
			} else {
				throw new UnknownError("xls file expected. Got "
						+ fileName);
			}
		} catch (EncryptedDocumentException | IOException e) {
			this.fileInputStream = null;
			LOGGER.error("Error while getting workbook", e);
			throw e;
		}
		return true;
	}

	@Override
	public void close() throws IOException {
		this.workBook = null;
		if (this.fileInputStream != null) {
			this.fileInputStream.close();
			this.fileInputStream = null;
		}
	}

	public boolean isOpen() {
		if (this.workBook != null) {
			return true;
		}
		return false;
	}
}