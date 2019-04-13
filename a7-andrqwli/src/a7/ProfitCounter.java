package a7;

public class ProfitCounter implements BeltObserver {
	
	private double profit;
	private Belt b;
	private int plateCount;
	
	public ProfitCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		this.b = b;
		this.b.addBeltObserver(this);
		this.profit = 0;
		
		for (int i = 0; i < this.b.getSize(); i++) {
			if (b.getPlateAtPosition(i) == null) {
				continue;
			}
			
			profit += this.b.getPlateAtPosition(i).getProfit();
		}
		
		this.plateCount = 0;
		
		for (int i = 0; i < this.b.getSize(); i++) {
			if (b.getPlateAtPosition(i) != null) {
				plateCount++;
			}
		}
	}

	public double getTotalBeltProfit() {
		return profit;
	}
	
	public double getAverageBeltProfit() {
		if (plateCount == 0) {
			return 0.0;
		} else {
			return profit / plateCount;
		}
		
	}
	public void handlePlateEvent(PlateEvent e) {
		switch (e.getType()) {
		case PLATE_PLACED:
			profit += e.getPlate().getProfit();
			plateCount++;
			break;
		case PLATE_REMOVED:
			profit -= e.getPlate().getProfit();
			plateCount--;
			break;
		}
	}
}
