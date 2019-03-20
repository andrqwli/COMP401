package a5;

public class PlateImpl implements Plate {

	protected Sushi contents;
	protected double price;
	protected Plate.Color color;

	protected PlateImpl(Plate.Color color, double price, Sushi contents) {
		this.color = color;
		this.price = price;
		this.contents = contents;
	}
	
	public Sushi getContents() {
		return contents;
	}
	
	public Sushi removeContents() {
		Sushi temp = contents;
		this.contents = null;
		return temp;
	}
	
	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		if (price - s.getCost() <= 0) {
			throw new PlatePriceException();
		}
		contents = s;
	}
	
	public boolean hasContents() {
		if (contents == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public double getPrice() {
		return price;
	}
	
	public Color getColor() {
		return color;
	}
	
	public double getProfit() {
		if (contents == null) {
			return 0;
		}
		return price - contents.getCost();
	}
}
