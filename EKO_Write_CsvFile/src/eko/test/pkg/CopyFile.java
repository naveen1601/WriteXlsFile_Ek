package eko.test.pkg;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class CopyFile {
	
	public String FileName;
	
	public  String copy() throws IOException{
        
		SimpleDateFormat sdf = new SimpleDateFormat("dd_M_");
    	//System.out.println("date  "+sdf.format(new Date()));
		
		//absolute path for source file to be copied
        String source = "C:/Users/naveen.srivastava/Desktop/EKO/EKO_Business_Transaction.xlsx";
        //directory where file will be copied
        String target ="C:/Users/naveen.srivastava/Desktop/TestDoc/";
      
        //name of source file
        File sourceFile = new File(source);
        String name = sourceFile.getName();
      
        File targetFile = new File(target+sdf.format(new Date())+name);
        System.out.println("Copying file : " + sourceFile.getName() +" from Java Program");
      

    	 //copy file from one location to other
           FileUtils.copyFile(sourceFile, targetFile);
           FileName = String.valueOf(targetFile);
           System.out.println("copying of file from Java program is completed");
        
        return target+""+targetFile.getName();

    }


}
