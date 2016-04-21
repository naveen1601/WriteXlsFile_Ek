package eko.pkg;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import eko.test.pkg.CopyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class WriteXlxs {
    //private static final String FILE_PATH = "C:/Users/naveen.srivastava/Desktop/TestDoc/testWriteStudents.xlsx";
    
    //We are making use of a single instance to prevent multiple write access to same file.
    private static final WriteXlxs INSTANCE = new WriteXlxs();

    public static WriteXlxs getInstance() {
        return INSTANCE;
    }
    
    
    public static void main(String args[]){
    	// Using XSSF for xlsx format, for xls use HSSF
    	String fileName;
    	XSSFWorkbook workbook;
        FileInputStream input_document;
        Sheet worksheet;
        Cell cell = null;
        CopyFile copyFile;
        Statement stmt;
        ResultSet rs;
        ConnectionProp conn = new ConnectionProp();
        FeedingExcelValues feedExcel = new FeedingExcelValues();
        //fileName ="C:/Users/naveen.srivastava/Desktop/TestDoc/19_2_EKO_Business_Transaction.xlsx";
        

        try {
        	copyFile = new CopyFile();
            fileName = copyFile.copy();
            System.out.println("copied file name is "+fileName);
            input_document= new FileInputStream(new File(fileName));
			workbook = new XSSFWorkbook(input_document);
			worksheet = workbook.getSheetAt(0);
			cell = null;
            conn.connectC();
            stmt= conn.con.createStatement();
            
            //IMPS PPI
            rs = stmt.executeQuery(Queries.imps_Ppi_AllTr);
            feedExcel.insertAllTrValuesFromQueryRes(rs, cell, worksheet, 1, 2);
			// IMPS PPI Null response
			rs = stmt.executeQuery(Queries.imps_Ppi_Null);
			feedExcel.insertNullTrValuesFromQueryRes(rs, cell, worksheet, 1, 2);
			//IMPS PPI Ends
			
			//IMPS ICICI 
			rs = stmt.executeQuery(Queries.imps_Icici_AllTr);
			feedExcel.insertAllTrValuesFromQueryRes(rs, cell, worksheet, 4, 5);
			// IMPS ICICI Null response
			rs = stmt.executeQuery(Queries.imps_Icici_Null);
			feedExcel.insertNullTrValuesFromQueryRes(rs, cell, worksheet, 4, 5);
			//IMPS ICICI Ends

			//NEFT ICICI
			rs = stmt.executeQuery(Queries.neft_Icici_AllTr);
			feedExcel.insertAllTrValuesFromQueryRes(rs, cell, worksheet, 7, 8);
			// NEFT ICICI Null response
			rs = stmt.executeQuery(Queries.neft_Icici_Null);
			feedExcel.insertNullTrValuesFromQueryRes(rs, cell, worksheet, 7, 8);
			//NEFT ICICI Ends
			
			//NEFT RBL
			rs = stmt.executeQuery(Queries.neft_Rbl_AllTr);
			feedExcel.insertAllTrValuesFromQueryRes(rs, cell, worksheet, 13, 14);
			// NEFT RBL Null response
			rs = stmt.executeQuery(Queries.neft_Rbl_Null);
			feedExcel.insertNullTrValuesFromQueryRes(rs, cell, worksheet, 13, 14);
			//NEFT RBL Ends
			
			XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
			input_document.close();
			
			FileOutputStream output_file =new FileOutputStream(new File(fileName));
			workbook.write(output_file);
			output_file.close();
			System.out.println("****** Report Successfully Created ******");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        catch (SQLException e) {
        	e.printStackTrace();
		}
        catch (ClassNotFoundException e) {
        	e.printStackTrace();
		}
        catch (Exception e)
		{
			e.printStackTrace();
		}

    }
}
