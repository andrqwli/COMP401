package a6;

public class GreenPlate extends PlateImpl {

	public GreenPlate(Sushi contents) throws PlatePriceException {
		super(Plate.Color.GREEN, 2, contents);
		if (contents != null) {
			if (getProfit() <= 0) {
				throw new PlatePriceException();
			}
		}
	}
}
