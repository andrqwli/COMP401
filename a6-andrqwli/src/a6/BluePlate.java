package a6;

public class BluePlate extends PlateImpl {
	
	public BluePlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.BLUE, 4, contents);
		if (contents != null) {
			if (getProfit() <= 0) {
				throw new PlatePriceException();
			}
		}
	}
}
