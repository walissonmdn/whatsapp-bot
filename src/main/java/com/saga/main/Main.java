package com.saga.main;

import com.saga.excel.Excel;


public class Main {

	public static void main(String[] args) {

		Excel excelFile = new Excel("C:\\Users\\walis\\OneDrive\\Saga\\Arquivos\\GitHub\\whatsappbot\\test.xlsx");
		excelFile.openWorkbook();
		excelFile.getSheetAt(0);
		excelFile.setCellValue(1, 1, "This is a test.");
		excelFile.saveWorkbook();
		excelFile.closeWorkbook();
		
		System.out.println("Done");
	
	}

}

