package mypackage;

import java.util.Scanner;

class PrimeNumber {
	
	static int smallestDivisor(int input) {
		if (input % 2 == 0)
			return 2;

		for (int i = 3; i * i <= input; i += 2) {
			if (input % i == 0)
				return i;
		}

		return 1;
	}

	public static void main(String[] args) {

		int input;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter any number:");
		input = obj.nextInt();
		System.out.println(smallestDivisor(input));

	}
}
