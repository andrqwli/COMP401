package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		String[] firsts = new String[count];
		String[] lasts = new String[count];
		double[] total = new double[count];
		int itemCount;
		
		for (int i = 0; i < count; i++) {
			firsts[i] = scan.next();
			lasts[i] = scan.next();
			itemCount = scan.nextInt();
			total[i] = 0;
			for (int j = 0; j < itemCount; j++) {
				int amount = scan.nextInt();
				scan.next();
				double price = scan.nextDouble();
				total[i] += amount * price;
			}			
		}
		
		for (int i = 0; i<count; i++) {
			System.out.println(firsts[i].charAt(0) + ". " + lasts[i] + ": " + String.format("%.2f",total[i]));
		}
	}
}
