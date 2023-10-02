package com.saga.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class Excel {
	public File file;
	public InputStream fileInput;
	public OutputStream fileOutput;
	public Workbook workbook;
	public Sheet sheet;
	
	public Excel(String path) {
		this.file = new File(path);
	}
	
	public void openWorkbook() {
		try {
			this.fileInput = new FileInputStream(this.file);
			this.workbook = new XSSFWorkbook(this.fileInput);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("There was a problem while trying to open the workbook.");
			e.printStackTrace();
		}
	}
	
	public void closeWorkbook() {
		try {
			this.fileInput.close();
			this.workbook.close();
			
		} catch (IOException e) {
			System.out.println("There was a problem while trying to close the workbook.");
			e.printStackTrace();
		}
	}
	
	public void saveWorkbook() {
		try {
			this.fileOutput = new FileOutputStream(this.file) ;
			this.workbook.write(fileOutput);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a problem while trying to save the workbook.");
			e.printStackTrace();
		}
	}
	
	public void getSheetAt(int sheetIndex) {
		this.sheet = this.workbook.getSheetAt(sheetIndex);
	}
	
	public void setCellValue(int rowIndex, int columnIndex, String text) {
		Row row = this.sheet.getRow(rowIndex);
		if (row == null) row = this.sheet.createRow(rowIndex);
		
		Cell cell = row.getCell(columnIndex);
		if (cell == null) cell = row.createCell(columnIndex);
		
		cell.setCellValue(text);

	}
	
	public String getCellValue(int rowIndex, int columnIndex) {		
		Row row = this.sheet.getRow(rowIndex);
		
		if (row != null) {
			Cell cell = row.getCell(columnIndex);
			
			if (cell != null) {
				DataFormatter formatter = new DataFormatter();
				String cellValue = formatter.formatCellValue(cell);
		        System.out.println(cellValue);		
		        return cellValue;
			}
			else System.out.println("No value on the cell.");
			
	    }
		else System.out.println("No value on the row.");		
		
		return null;
	}
	
}
