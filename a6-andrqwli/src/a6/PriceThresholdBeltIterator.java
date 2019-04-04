package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriceThresholdBeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int position;
	private int size;
	private int lastIndex;
	private double max;

	public PriceThresholdBeltIterator(Belt belt, int start_position, double max_price) {
		this.belt = belt;
		this.size = belt.getSize();
		this.position = ((start_position % size) + size) % size;
		this.lastIndex = -1;
		this.max = max_price;
	}
	
	public boolean hasNext() {
		int range = size + position;
		int x = position;
		while (x < range) {
			if (belt.getPlateAtPosition(x) != null && belt.getPlateAtPosition(x).getPrice() < max) {
				return true;
			}
			x++;
		}
		return false;
	}
	
	public Plate next() {
		int range = size + position;
		int x = position;
		while (x < range) {
			if (belt.getPlateAtPosition(x) != null && belt.getPlateAtPosition(x).getPrice() < max) {
				lastIndex = x;
				position = x + 1;
				return belt.getPlateAtPosition(x);
			}
			x++;
		}
		throw new NoSuchElementException();
	}
	
	public void remove() {
		if (lastIndex == -1) {
			throw new IllegalStateException();
		}
		belt.removePlateAtPosition(lastIndex);
		lastIndex = -1;
	}
}
