package a5;

public class IngredientImpl implements Ingredient {

	private String name;
	private int calories;
	private double price;
	private boolean is_vegetarian;
	private boolean is_rice;
	private boolean is_shellfish;
	
	public IngredientImpl(String name, int calories, double price, boolean is_vegetarian, boolean is_rice, boolean is_shellfish) {
		this.name = name;
		this.calories = calories;
		this.price = price;
		this.is_rice = is_rice;
		this.is_vegetarian = is_vegetarian;
		this.is_shellfish = is_shellfish;
	}
	
	public String getName() {
		return name;
	}

	public double getCaloriesPerDollar() {
		return getCaloriesPerOunce() / getPricePerOunce();
	}

	public int getCaloriesPerOunce() {
		return calories;
	}

	public double getPricePerOunce() {
		return price;
	}

	public boolean equals(Ingredient other) {
		if (other.getName() == name && other.getCaloriesPerOunce() == calories) {
		} else { return false; }
		if (Math.abs(other.getPricePerOunce() - price) <= 0.1) {	
		} else { return false; }
		if (other.getIsRice() == is_rice && other.getIsShellfish() == is_shellfish && other.getIsVegetarian() == is_vegetarian) {
		} else { return false; }
		return true;
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
}
