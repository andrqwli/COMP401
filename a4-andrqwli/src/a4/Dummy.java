package a4;

import a4.*;


// This is just a empty dummy class that was included in order to 
// make sure that the src/a4 directory structure needed for the 
// a4 package was created as part of the A4 template repository
// You don't have to do anything with it and can even delete it
// if you want.

public class Dummy {
	public static void main(String args[]) {

		System.out.println("Testing if roll constructor detects that enough seaweed is in ingredients");
		String name = "yummy";
		double tuna_amt = 1.2;
		double rice_amt = 0.33;
		double seaweed_amt = 0.05;
		double avocado_amt = 0.75;

		IngredientPortion[] ingredientPortion = {new RicePortion(rice_amt),
				new AvocadoPortion(avocado_amt), new TunaPortion(tuna_amt), new SeaweedPortion(seaweed_amt)};

		Roll roll = new Roll(name,ingredientPortion);
		
		// test if seaweed is added if not in roll constructor
		// iterating through returned ingredient portions to see if seaweed is there
		boolean hasSeaweed=false;
		for(IngredientPortion ip: roll.getIngredients()){
			if(ip.getIngredient().equals(new Seaweed())){
				hasSeaweed = true;
			}
		}
		
		System.out.println(roll.getCalories());

	}
}
