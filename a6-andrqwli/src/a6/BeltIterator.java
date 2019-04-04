package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int position;
	private int size;
	private int lastIndex;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.size = belt.getSize();
		this.position = ((start_position % size) + size) % size;
		this.lastIndex = -2;
	}
	
	public boolean hasNext() {
		int range = size + position;
		int x = position;
		while (x < range) {
			if (belt.getPlateAtPosition(x) != null) {
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
			if (belt.getPlateAtPosition(x) != null) {
				lastIndex = x;
				position = x + 1;
				return belt.getPlateAtPosition(x);
			}
			x++;
		}
		throw new NoSuchElementException();
	}
	
	public void remove() {
		if (lastIndex < 0) {
			throw new IllegalStateException();
		}
		belt.removePlateAtPosition(lastIndex);
		lastIndex = -1;
	}
	
	public int pos() {
		return position;
	}
}
