package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int itemCount = scan.nextInt();
		String[] itemNames = new String[itemCount];
		int[] numberOfCustomers = new int[itemCount];
		int[] numberOfItems = new int[itemCount];
		
		for (int i = 0; i < itemCount; i++) {
			itemNames[i] = scan.next();
			scan.nextDouble();
			numberOfCustomers[i] = 0;
			numberOfItems[i] = 0;
		}
		
		int customerCount = scan.nextInt();
		
		for (int i = 0; i < customerCount; i++) {
			
			scan.next();
			scan.next();
			int distinctItems = scan.nextInt();
			
			boolean[] itemBought = new boolean[itemCount];
			
			for (int k = 0; k < itemCount; k++) {
				itemBought[k] = false; 
			}
			
			for (int j = 0; j < distinctItems; j++) {
				
				int amount = scan.nextInt();
				String name = scan.next();
				int index = 0;
				
				while (!itemNames[index].equals(name)) {
					index++;
				}
				
				if (!itemBought[index]) {
					numberOfCustomers[index]++;
					itemBought[index] = true;
				}
				
				numberOfItems[index] += amount;
			}
		}
		
		for (int i = 0; i < itemCount; i++) {
			if (numberOfItems[i] == 0) {
				System.out.println("No customers bought " + itemNames[i]);
			} else {
				System.out.println(numberOfCustomers[i] + " customers bought " + numberOfItems[i] + " " + itemNames[i]);
			}
		}
	}
}
