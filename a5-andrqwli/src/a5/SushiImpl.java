package a5;

public class SushiImpl implements Sushi {

	private String name;
	private IngredientPortion[] ing;

	public SushiImpl(String name, IngredientPortion[] ing) {
		this.name = name;
		this.ing = ing;
	}
	
	public String getName() {
		return name;
	}

	public IngredientPortion[] getIngredients() {
		return ing;
	}

	public int getCalories() {
		double x = 0;
		for (int i = 0; i < ing.length; i++) {
			x += ing[i].getCalories() * ing[i].getAmount();
		}
		return (int) x;
	}

	public double getCost() {
		double total = 0;
		for (int i = 0; i < ing.length; i++) {
			total += ing[i].getCost() * ing[i].getAmount();
		}
		
		return (double)Math.round(total * 100d) / 100d;
	}

	public boolean getHasRice() {
		for (int i = 0; i < ing.length; i++) {
			if (!ing[i].getIsRice()) {
				return false;
			}
		}
		return true;
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

}
