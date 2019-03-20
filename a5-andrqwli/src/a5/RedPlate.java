package a5;

public class RedPlate extends PlateImpl {
	
	public RedPlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.RED, 1, contents);
		if (contents != null) {
			if (getProfit() <= 0) {
				throw new PlatePriceException();
			}
		}
	}
}
