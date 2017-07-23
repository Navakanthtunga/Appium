package com.demo1;

import java.io.IOException;

public class Internet {
public static void main(String[] args) throws IOException, InterruptedException {
	Process result = Runtime.getRuntime().exec("ipconfig /renew");
	Thread.sleep(20000);
	Process result2 = Runtime.getRuntime().exec("ipconfig /release");
	Thread.sleep(20000);
	Process result3 = Runtime.getRuntime().exec("ipconfig /renew");
	Thread.sleep(20000);
}
}
