package com.TestUtil;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.TestBase.TestBase;

public class TestUtil extends TestBase {
public static long PageLoadTimeOut = 20;
public static long Implicitly = 20;
public static String path="C:\\Users\\luchengchao\\JAVA_Selenium\\mavenStudy.qa\\src\\main\\java\\com\\TestData\\TestData.xlsx";
public static Workbook w;
public static Sheet s;

    public static Object[][] testData(String sn){
    	try {
			FileInputStream f = new FileInputStream(path);
			w = WorkbookFactory.create(f);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	s = w.getSheetAt(0);
    
    	
    	Object[][] data = new Object[s.getLastRowNum()][s.getRow(0).getLastCellNum()];
    	
    	for(int i=0; i<s.getLastRowNum(); i++) {
    		for(int j=0; j<s.getRow(0).getLastCellNum();j++) {
    			
    			data[i][j]= s.getRow(i+1).getCell(j).toString();
    		}
    	}
		return data;
    }
    
   
}
