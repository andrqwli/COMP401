package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ColorFilteredBeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int position;
	private int size;
	private int lastIndex;
	private Plate.Color filter;

	public ColorFilteredBeltIterator(Belt belt, int start_position, Plate.Color color_filter) {
		this.belt = belt;
		this.size = belt.getSize();
		this.position = ((start_position % size) + size) % size;
		this.lastIndex = -1;
		this.filter = color_filter;
	}
	
	public boolean hasNext() {
		int range = size + position;
		int x = position;
		while (x < range) {
			if (belt.getPlateAtPosition(x) != null && belt.getPlateAtPosition(x).getColor() == filter) {
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
			if (belt.getPlateAtPosition(x) != null && belt.getPlateAtPosition(x).getColor() == filter) {
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
