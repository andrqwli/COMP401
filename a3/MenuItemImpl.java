package a3;

public class MenuItemImpl implements MenuItem {

	private String name;
	private IngredientPortion[] ingredients;

	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
	
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
		
		if (ingredients == null) {
			throw new RuntimeException("Ingredients cannot be null");
		}
		
		if (ingredients.length == 0) {
			throw new RuntimeException("Ingredients array must have a length greater than 0");
		}
		
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] == null) {
				throw new RuntimeException("Individual ingredients cannot be null");
			}
		}
		
		this.name = name;
		this.ingredients = ingredients.clone();
	
	}
	
	public String getName() {
		return this.name;
	}

	public IngredientPortion[] getIngredients() {
		return this.ingredients.clone();
	}

	public int getCalories() {
		double total = 0;
		for (int i = 0; i < this.ingredients.length; i++) {
			total += this.ingredients[i].getCalories();
		}
		return (int) total;
	}
	
	public double getCost() {
		double total = 0;
		for (int i = 0; i < this.ingredients.length; i++) {
			total += this.ingredients[i].getCost();
		}
		return (double)Math.round(total * 100d) / 100d;
	}

	public boolean getIsVegetarian() {
		for (int i = 0; i < this.ingredients.length; i++) {
			if (!this.ingredients[i].getIsVegetarian()) {
				return false;
			}
		}
		return true;
	}

	
}
