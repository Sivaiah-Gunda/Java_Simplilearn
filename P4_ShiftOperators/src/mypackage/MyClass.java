package mypackage;

import java.util.Scanner;

public class MyClass {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println("Enter value for " + a);
		System.out.println(a<<2);
		System.out.println(a>>2);
		s.close();
		
	}

}
