package test;

import java.util.Scanner;

public class GetRepeatedSubstringCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("First input");
		String str=sc.nextLine();
		System.out.println("second input");
		String subStr=sc.nextLine();
		System.out.println("Third input");
		int count =sc.nextInt();		
		sc.close();
		repeatedCharGroup(str,subStr,count);
	}
	public static void repeatedCharGroup(String str,String substring,int charSize){
		int length = str.length();
		int count =0;
		for(int i=0;i<=length-charSize;i++){
			if(str.substring(i,i+charSize).equalsIgnoreCase(substring)){
				count =count+1;
				System.out.println("in loop - "+count);
			}
		}
		System.out.println("No of repeated substring "+count);
	}
}
