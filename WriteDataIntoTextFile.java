package com.sampleproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;

public class WriteDataIntoTextFile {
@Test
public void test1(){
	File file1 = new File("Sample.txt");
	try {
		FileWriter fileWrite = new FileWriter(file1);
		BufferedWriter bw = new BufferedWriter(fileWrite);
		bw.write("Hi hello");
		bw.newLine();
		bw.close();
} catch (IOException e) {
}
}
}
