package com.sampleproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class ReadDataFromTextFile {
	String filePath="C:\\Users\\Administrator\\Desktop\\sampletext.txt";
	
	@Test(enabled=true)
	public void test2() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filePath));
	    String line;
	    while((line = br.readLine())!= null)
	    {
	        System.out.println(line);
	    }
	    br.close();
	}
	@Test(enabled=true)
	public void test3() throws IOException{
		/*
		 * This will works from java-1.8
		 */
		String line321 = Files.readAllLines(Paths.get(filePath)).get(0);
		System.out.println(line321);
	}
}
