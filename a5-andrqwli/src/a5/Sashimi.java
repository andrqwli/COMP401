package a5;

public class Sashimi implements Sushi {

	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	private String name;
	private IngredientPortion[] ing;
	
	public Sashimi(SashimiType type) {
		ing = new IngredientPortion[1];
		if (type == SashimiType.TUNA) {
			this.name = "tuna sashimi";
			this.ing[0] = new TunaPortion(.75);
		} else if (type == SashimiType.YELLOWTAIL) {
			this.name = "yellowtail sashimi";
			this.ing[0] = new YellowtailPortion(.75);
		} else if (type == SashimiType.EEL) {
			this.name = "eel sashimi";
			this.ing[0] = new EelPortion(.75);
		} else if (type == SashimiType.CRAB) {
			this.name = "crab sashimi";
			this.ing[0] = new CrabPortion(.75);
		} else if (type == SashimiType.SHRIMP) {
			this.name = "shrimp sashimi";
			this.ing[0] = new ShrimpPortion(.75);
		}
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

