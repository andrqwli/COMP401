package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int length = scan.nextInt();
		String[] names = new String[length];
		double[] prices = new double[length];
		boolean[] isVegetarian = new boolean[length];
		double[] calories = new double[length];
		
		for (int i = 0; i < length; i++) {
			names[i] = scan.next();
			prices[i] = scan.nextDouble();
			if (scan.next().equals("true")) {
				isVegetarian[i] = true;
			} else {
				isVegetarian[i] = false;
			}
			calories[i] = scan.nextDouble();
		}
		
		int menuLength = scan.nextInt();
		String[] menuNames = new String[menuLength];
		double[] menuCalories = new double[menuLength];
		double[] menuPrices = new double[menuLength];
		boolean[] menuVegetarian = new boolean[menuLength];
		
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
			
			for (int l = 0; l < quantityOfIngredients; l++) {
				menuCalories[i] += calories[ingredientIndices[l]] * ingredientAmounts[l];
				menuPrices[i] += (prices[ingredientIndices[l]] * ingredientAmounts[l]);
			}
			
			for (int m = 0; m < quantityOfIngredients; m++) {
				if (isVegetarian[ingredientIndices[m]]) {
					menuVegetarian[i] = true;
				} else {
					menuVegetarian[i] = false;
					break;
				}
			}		
		}
		
		for (int i = 0; i < menuLength; i++) {
			System.out.println(menuNames[i] + ":");
			System.out.println("  " + ((int) (menuCalories[i] + 0.5)) + " calories");
			System.out.println("  $" + String.format("%.2f", menuPrices[i]));
			
			if (menuVegetarian[i]) {
				System.out.println("  Vegetarian");
			} else {
				System.out.println("  Non-Vegetarian");
			}
		}
	}
}
