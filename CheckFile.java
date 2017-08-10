package sampletest;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

public class CheckFile {
@Test
public void checkFile() throws IOException{

	File file=new File("D:\\Sample1.txt");
	file.createNewFile();
	System.out.println(file.exists());
	System.out.println(file.isFile());
	

	
}
}
