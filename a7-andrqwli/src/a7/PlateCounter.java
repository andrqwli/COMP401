package a7;

import comp401sushi.Plate;

public class PlateCounter implements BeltObserver {

	private int redCount;
	private int greenCount;
	private int blueCount;
	private int goldCount;
	
	public PlateCounter (Belt b) {
		if (b == null) {
			throw new IllegalArgumentException();
		}
		b.addBeltObserver(this);
		
		redCount = greenCount = blueCount = goldCount = 0;
		
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) == null) {
				continue;
			}
			switch (b.getPlateAtPosition(i).getColor()) {
			case RED:
				this.redCount++;
				continue;
			case GREEN:
				this.greenCount++;
				continue;
			case BLUE:
				this.blueCount++;
				continue;
			case GOLD:
				this.goldCount++;
				continue;
			}
		}
	}
	
	public int getRedPlateCount() {
		return redCount;
	}
	
	public int getGreenPlateCount() {
		return greenCount;
	}

	public int getBluePlateCount() {
		return blueCount;
	}
	
	public int getGoldPlateCount() {
		return goldCount;
	}
	
	public void handlePlateEvent(PlateEvent e) {
		switch (e.getType()) {
		case PLATE_PLACED:
			addCounters(e.getPlate());
			break;
		case PLATE_REMOVED:
			subtractCounters(e.getPlate());
			break;
		}
	}
	
	public void addCounters(Plate p) {
		switch (p.getColor()) {
		case RED:
			this.redCount++;
			break;
		case GREEN:
			this.greenCount++;
			break;
		case BLUE:
			this.blueCount++;
			break;
		case GOLD:
			this.goldCount++;
			break;
		}
	}
	
	public void subtractCounters(Plate p) {
		switch (p.getColor()) {
		case RED:
			this.redCount--;
			break;
		case GREEN:
			this.greenCount--;
			break;
		case BLUE:
			this.blueCount--;
			break;
		case GOLD:
			this.goldCount--;
			break;
		}
	}
}
