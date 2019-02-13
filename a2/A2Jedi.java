package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int length = scan.nextInt();
		double[] totalOz = new double[length];
		String[] names = new String[length];
		
		for (int i = 0; i < length; i++) {
			names[i] = scan.next();
			scan.nextDouble();
			scan.next();
			scan.nextDouble();
			totalOz[i] = 0;
		}
		
		int menuLength = scan.nextInt();
		double[][] totalOzPerItem = new double[menuLength][length];
		String[] menuNames = new String[menuLength];
		
		for (int i = 0; i < menuLength; i ++) {
			menuNames[i] = scan.next();
			int quantityOfIngredients = scan.nextInt();
			String[] itemIngredients = new String[quantityOfIngredients];
			double[] ingredientAmounts = new double[quantityOfIngredients];
			int[] ingredientIndices = new int[quantityOfIngredients];
			
			for (int j = 0; j < quantityOfIngredients; j++) {
				itemIngredients[j] = scan.next();
				ingredientAmounts[j] = scan.nextDouble();
			}
			
			int index;
			
			for (int k = 0; k < quantityOfIngredients; k++) {
				index = 0;
				while (!itemIngredients[k].equals(names[index])) {
					index++;
				}
				ingredientIndices[k] = index;
			}
			
			double[] ozPerItem = new double[length];
			
			for (int l = 0; l < length; l++) {
				ozPerItem[l] = 0;
			}
			
			for (int l = 0; l < quantityOfIngredients; l++) {
				ozPerItem[ingredientIndices[l]] += ingredientAmounts[l];
			}
			
			for (int l = 0; l < length; l++) {
				totalOzPerItem[i][l] = ozPerItem[l];
			}
		}
		
		double[] order = new double[menuLength];
		
		for (int i = 0; i < menuLength; i++) {
			order[i] = 0;
		}
		
		String next = scan.next();
		
		while (!next.equals("EndOrder")) {
			int index = 0;
			
			while (!menuNames[index].equals(next)) {
				index++;
			}
			
			order[index]++;
			next = scan.next();
		}
		
		for (int i = 0; i < order.length; i++) {
			for (int j = 0; j < length; j++) {
				totalOz[j] += order[i] * totalOzPerItem[i][j];
			}
		}
		
		System.out.println("The order will require:");
		for (int i = 0; i < length; i++) {
			System.out.println(String.format("%.2f", totalOz[i]) + " ounces of " + names[i]);
		}
	}
}
