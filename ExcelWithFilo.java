package com.fillopractice;

import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
/*
 * This class is used to read data from using SQl queries with Fillo jar
 * URL: https://codoid.com/fillo/
 * Dependency: 
 * <dependency>
    <groupId>com.codoid.products</groupId>
    <artifactId>fillo</artifactId>
    <version>1.15</version>
</dependency>
 */
public class ExcelWithFilo {
	String sDir=System.getProperty("user.dir");
	String filepath=sDir+"//src//test//resources//ExcelWithFilo.xlsx";
	@Test(enabled=false,description="Exploring fillo methods")
	public void readData() throws FilloException{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(filepath);
		String strQuery="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery);
		while(recordset.next()){
			System.out.println(recordset.getField("Name"));
		}
		System.out.println("*******");
		// to fetch data from first row
		recordset.moveFirst();
		System.out.println(recordset.getField("Name")); 
		// to fetch data from last row
		recordset.moveLast();
		System.out.println(recordset.getField("Name")); 
		// to fetch data from previous to current row
		recordset.movePrevious();
		System.out.println(recordset.getField("Name"));
		// to fetch data from next to current row
		recordset.moveNext();
		System.out.println(recordset.getField("Name"));
		// to get total count of columns
		int columnsCnt=recordset.getFieldNames().size();
		System.out.println("total count: "+columnsCnt);
		System.out.println("Trying in generic");
		for(int i=0;i<columnsCnt;i++){
			System.out.println(recordset.getFieldNames().get(i));
		}
		recordset.close();
		connection.close();
	}
	@Test(enabled=false,description="Exploring Where Condition")
	public void readData_02() throws FilloException{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(filepath);
		String strQuery="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery).where("Mobile=8550875759");

		while(recordset.next()){
			System.out.println(recordset.getField("Address"));
		}
		System.out.println("*******");
		recordset.close();
		connection.close();
	}
	@Test(enabled=false,description="Insert data into table")
	public void insertData() throws FilloException{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(filepath);
		String strQuery="INSERT INTO Sheet1(Name,Address,DOB,Mobile) VALUES('test1','Chitvel','15-June-1992',9677085667)";
		connection.executeUpdate(strQuery);
		connection.close();
	}
	@Test(enabled=false,description="Update data into table")
	public void updateData() throws FilloException{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(filepath);
		// To update single record
		//String strQuery="Update Sheet1 Set Address='Chitvel' where Name ='Navakanth'";
		// To update multiple records
		String strQuery="Update Sheet1 Set Address='T C Palli',DOB='13-Jun-1992', Mobile=9573566729 where Name ='Navakanth'";
		connection.executeUpdate(strQuery);
		connection.close();
	}
	@Test(enabled=true,description="Create a new sheet")
	public void createNewtable() throws FilloException{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(filepath);
		// To create a new table/sheet
		connection.createTable("testing1", new String[]{"Column1","Column2"});
		// To delete existing sheet
		connection.deleteTable("testing  ");
		connection.close();
	}
}
