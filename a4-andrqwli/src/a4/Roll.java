package a4;

import java.util.ArrayList;

public class Roll implements Sushi {
	
	private String name;
	private IngredientPortion[] ing;
	
	public Roll(String name, IngredientPortion[] roll_ingredients) {
		this.name = name;
		this.ing = roll_ingredients.clone();
		
		if (this.ing.clone() == null) {
			throw new RuntimeException("Ingredient portion array must not be null");
		}
				
		for (int i = 0; i < this.ing.clone().length; i++) {
			if (this.ing[i] == null) {
				throw new RuntimeException("Ingredients cannot be null");
			}
		}
		
		IngredientPortion[] arr = ing.clone();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				for (int j = 0; j < arr.length; j++) {
					if (i != j && arr[j] != null) {
						if (arr[i].getIngredient().equals(arr[j].getIngredient())) {
							arr[i] = arr[i].combine(arr[j]);
							arr[j] = null;
						}
					}
				}
			}
		}
		
		ArrayList<IngredientPortion> ingList = new ArrayList<IngredientPortion>();
	
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				ingList.add(arr[i]);
			}
		}
		
		IngredientPortion[] arr2 = new IngredientPortion[ingList.size()];
		
		for (int i = 0; i < ingList.size(); i++) {
			arr2[i] = ingList.get(i);
		}
		
		if (!hasSeaweed(arr2)) {
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i].getName().equals("seaweed")) {
					ingList.remove(i);
				}
			}
			IngredientPortion newSeaweed = new SeaweedPortion(.1);
			ingList.add(newSeaweed);
		}
		
		IngredientPortion[] ingF = new IngredientPortion[ingList.size()];
		
		for (int i = 0; i < ingList.size(); i++) {
			ingF[i] = ingList.get(i);
		}

		this.ing = ingF;
	}
	
	
	public String getName() {
		return name;
	}

	public IngredientPortion[] getIngredients() {
		return ing.clone();
	}

	public int getCalories() {
		double x = 0;
		for (int i = 0; i < ing.length; i++) {
			x += ing[i].getCalories();
		}
		return (int) (x + .5);
	}
	
	public double getCost() {
		double total = 0;
		for (int i = 0; i < ing.length; i++) {
			total += ing[i].getCost();
		}
		
		return (double)Math.round(total * 100d) / 100d;
	}

	public boolean getHasRice() {
		for (int i = 0; i < ing.length; i++) {
			if (ing[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	public boolean getHasShellfish() {
		for (int i = 0; i < ing.length; i++) {
			if (!ing[i].getIsShellfish()) {
				return false;
			}
		}
		return true;
	}

	public boolean getIsVegetarian() {
		for (int i = 0; i < ing.length; i++) {
			if (!ing[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hasSeaweed(IngredientPortion[] input) {
		for (int i = 0; i < input.length; i++) {
			if (input[i].getName().equals("seaweed") && input[i].getAmount() >= 0.1) {
				return true;
			}
		}
		return false;
	}
}