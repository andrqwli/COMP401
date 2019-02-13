package a3;

public class IngredientPortionImpl implements IngredientPortion {
	
	double amount;
	Ingredient ing;

	public IngredientPortionImpl(Ingredient ing, double amount) {
		if (ing == null || amount < 0) {
			throw new RuntimeException("Ingredient must not be null and amount must be nonnegative");
		}
		
		this.amount = amount;
		this.ing = ing;
	}
	
	public Ingredient getIngredient() {
		return this.ing;
	}

	public double getAmount() {
		return this.amount;
	}

	public String getName() {
		return this.ing.getName();
	}

	public boolean getIsVegetarian() {
		return this.ing.getIsVegetarian();
	}

	public double getCalories() {
		return ing.getCaloriesPerOunce() * amount;
	}

	public double getCost() {
		return ing.getPricePerOunce() * amount;
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (ing == null) {
			throw new RuntimeException("Ingredient cannot be null");
		} else if (other.getIngredient() != ing) {
			throw new RuntimeException("Must use the same ingredient");
		} 
		if (other == null) {
			return this;
		} else {
			IngredientPortion result = new IngredientPortionImpl(this.ing, amount + other.getAmount());
			return result;
		}
	
	}

}
