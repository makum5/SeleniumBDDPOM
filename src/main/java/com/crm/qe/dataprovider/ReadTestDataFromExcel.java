package com.crm.qe.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qe.base.BaseClass;
import com.crm.qe.utils.TestUtils;

public class ReadTestDataFromExcel extends BaseClass {

	static Workbook workbook;
	static Sheet worksheet;

	public static Object[][] getTestData(String Sheetname) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TestUtils.TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {

			workbook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		worksheet = workbook.getSheet(Sheetname);
		int totalrow = worksheet.getLastRowNum();
		int totalCol = worksheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[totalrow][totalCol];
		//ArrayList<Object[]> data = new ArrayList<Object[]>();
		for (int row = 0; row < totalrow; row++) {
			for (int col = 0; col < totalCol; col++) {
				data[row][col] = worksheet.getRow(row + 1).getCell(col).toString();
			}
		}

		return data;
	}

}
