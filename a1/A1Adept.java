package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int itemCount = scan.nextInt();
		double[] priceArray = new double[itemCount];
		String[] itemNames = new String[itemCount];
		
		for (int i = 0; i < itemCount; i++) {
			itemNames[i] = scan.next();
			priceArray[i] = scan.nextDouble();
		}
		
		int count = scan.nextInt();
		String[] names = new String[count];
		double[] totals = new double[count];
		
		for (int i = 0; i < count; i++) {
			
			names[i] = scan.next() + " " + scan.next();
			int distinctItems = scan.nextInt();
			totals[i] = 0;
			
			for (int j = 0; j < distinctItems; j++) {
				
				int amount = scan.nextInt();
				String name = scan.next();
				int index = 0;
				
				while (!itemNames[index].equals(name)) {
					index++;
				}
				totals[i] += amount * priceArray[index];
			}
		}
		
		double biggest = 0;
		
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] > biggest) {
				biggest = totals[i];
			}
		}
		
		int index = 0;
		
		while (totals[index] != biggest) {
			index++;
		}
		
		int biggestIndex = index;
		index = 0;
		double smallest = biggest;
		double sum = 0;
		
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] < smallest) {
				smallest = totals[i];
			}
			sum += totals[i];
		}
		
		while (totals[index] != smallest) {
			index++;
		}
		
		int smallestIndex = index;
		double average = sum / totals.length;
		
		System.out.println("Biggest: " + names[biggestIndex] + " (" + String.format("%.2f", totals[biggestIndex]) + ")");
		System.out.println("Smallest: " + names[smallestIndex] + " (" + String.format("%.2f",totals[smallestIndex]) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}
}
