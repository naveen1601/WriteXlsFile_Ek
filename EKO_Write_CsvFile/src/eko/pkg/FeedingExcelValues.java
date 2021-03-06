package eko.pkg;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public class FeedingExcelValues {
	
	public void insertAllTrValuesFromQueryRes(ResultSet rs, Cell cell, Sheet worksheet, int colVal1, int colVal2) throws SQLException
	{
		//row starts with 0 in java, 4 in java prgm = 5 in excel sheet. Same is applicable in column
		while(rs.next()){
			switch (rs.getInt(3)) {
			case 1:
				cell = worksheet.getRow(2).getCell(colVal1);
				System.out.println("cell column is "+cell.getColumnIndex()+"   row is "+cell.getRowIndex());
				System.out.println("cell value is "+cell.getNumericCellValue());
				cell.setCellValue(rs.getInt(1));
				cell = worksheet.getRow(2).getCell(colVal2);
				System.out.println("cell column is "+cell.getColumnIndex()+"   row is "+cell.getRowIndex());
				System.out.println("cell value is "+cell.getNumericCellValue());
				cell.setCellValue(rs.getInt(2));
				break;
			case 3:
				cell = worksheet.getRow(3).getCell(colVal1);
				cell.setCellValue(rs.getInt(1));
				cell = worksheet.getRow(3).getCell(colVal2);
				cell.setCellValue(rs.getInt(2));
				break;
			case 4:
				cell = worksheet.getRow(4).getCell(colVal1);
				cell.setCellValue(rs.getInt(1));
				cell = worksheet.getRow(4).getCell(colVal2);
				cell.setCellValue(rs.getInt(2));
				break;
			case 6:
				cell = worksheet.getRow(5).getCell(colVal1);
				cell.setCellValue(rs.getInt(1));
				cell = worksheet.getRow(5).getCell(colVal2);
				cell.setCellValue(rs.getInt(2));
				break;
			case 7:
				cell = worksheet.getRow(6).getCell(colVal1);
				cell.setCellValue(rs.getInt(1));
				cell = worksheet.getRow(6).getCell(colVal2);
				cell.setCellValue(rs.getInt(2));
				break;
			case 2:
				cell = worksheet.getRow(7).getCell(colVal1);
				cell.setCellValue(rs.getInt(1));
				cell = worksheet.getRow(7).getCell(colVal2);
				cell.setCellValue(rs.getInt(2));
				break;
			case 14:
				cell = worksheet.getRow(8).getCell(colVal1);
				cell.setCellValue(rs.getInt(1));
				cell = worksheet.getRow(8).getCell(colVal2);
				cell.setCellValue(rs.getInt(2));
				break;
			default:
				break;
			}
		}
	}
	
	public void insertNullTrValuesFromQueryRes(ResultSet rs, Cell cell, Sheet worksheet, int colVal1, int colVal2) throws SQLException
	{
		while(rs.next())
		{
			cell = worksheet.getRow(9).getCell(colVal1);
			cell.setCellValue(rs.getInt(1));
			cell = worksheet.getRow(9).getCell(colVal2);
			cell.setCellValue(rs.getInt(2));
		}
	}
}
