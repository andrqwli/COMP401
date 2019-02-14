package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int length = scan.nextInt();
		String[] names = new String[length];
		double[] prices = new double[length];
		int isVegetarian = 0;
		double[] calories = new double[length];
		
		for (int i = 0; i < length; i++) {
			names[i] = scan.next();
			prices[i] = scan.nextDouble();
			if (scan.next().equals("true")) {
				isVegetarian++;
			}
			calories[i] = scan.nextDouble() / prices[i];
		}
		
		double highest = 0;
		
		for (int i = 0; i < length; i++) {
			if (calories[i] > highest) {
				highest = calories[i];
			}
		}
		
		int index = 0;
		
		while (calories[index] != highest) {
			index++;
		}
		
		int highestIndex = index;
		
		double lowest = highest;
		
		for (int i = 0; i < length; i++) {
			if (calories[i] < lowest) {
				lowest = calories[i];
			}
		}
		
		index = 0;
		
		while (calories[index] != lowest) {
			index++;
		}
		
		int lowestIndex = index;
		
		System.out.println("Number of vegetarian ingredients: " + isVegetarian);
		System.out.println("Highest cals/$: " + names[highestIndex]);
		System.out.println("Lowest cals/$: " + names[lowestIndex]);
		
	}
}
