package a6;

public class GoldPlate extends PlateImpl {

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(Plate.Color.GOLD, checkPrice(price), contents);
		if (contents != null) {
			if (getProfit() <= 0) {
				throw new PlatePriceException();
			}
		}
	}
	
	public static double checkPrice(double price) {
		if (price < 5.0) {
			throw new IllegalArgumentException();
		} else {
			return price;
		}
	}
}
