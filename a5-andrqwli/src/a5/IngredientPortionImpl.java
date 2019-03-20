package a5;

public class IngredientPortionImpl implements IngredientPortion {

	private double amount;
	private String name;
	private int calories;
	private double price;
	private boolean is_vegetarian;
	private boolean is_rice;
	private boolean is_shellfish;
	private Ingredient ingType;

	public IngredientPortionImpl(Ingredient ing, double amount) {
		
		if (amount <= 0) {
			throw new RuntimeException("Amount must be positive");
		}
		
		this.name = ing.getName();
		this.calories = ing.getCaloriesPerOunce();
		this.price = ing.getPricePerOunce();
		this.is_rice = ing.getIsRice();
		this.is_vegetarian = ing.getIsVegetarian();
		this.is_shellfish = ing.getIsShellfish();
		this.ingType = ing;
		this.amount = amount;
	}
	
	public Ingredient getIngredient() {
		return ingType;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return calories * amount;
	}

	public double getCost() {
		return price * amount;
	}

	public boolean getIsVegetarian() {
		return is_vegetarian;
	}

	public boolean getIsRice() {
		return is_rice;
	}

	public boolean getIsShellfish() {
		return is_shellfish;
	}

	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		} else if (!this.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Must combine IngredientPortions of the same type.");
		}
		IngredientPortion result = new IngredientPortionImpl(ingType, amount + other.getAmount());
		return result;
	}

}
