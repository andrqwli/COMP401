package a6;

import java.util.Iterator;

public class BeltImpl implements Belt {
	
	private Plate[] belt;
	private int size;

	public BeltImpl(int belt_size) {
		if (belt_size < 0) {
			throw new IllegalArgumentException("Belt size must be positive");
		}
		this.belt = new Plate[belt_size];
		this.size = belt_size;
	}

	
	public int getSize() {
		return this.belt.length;
	}
	
	
	public Plate getPlateAtPosition(int position) {
		int normalized_position = ((position % size) + size) % size;
		return belt[normalized_position];
	}

	
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException("Plate parameter can't be null");
		}
		int normalized_position = ((position % size) + size) % size;
		if (belt[normalized_position] != null) {
			throw new BeltPlateException(normalized_position, plate, this);
		}
		belt[normalized_position] = plate;
	}
	
	
	public void clearPlateAtPosition(int position) {
		belt[position] = null;
	}

	
	public Plate removePlateAtPosition(int position) {
		if (this.getPlateAtPosition(position) == null) {
			throw new java.util.NoSuchElementException();
		}
		Plate temp = this.getPlateAtPosition(position);
		this.clearPlateAtPosition(position);
		return temp;
	}
	
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException, BeltPlateException {
		int normalized_position = ((position % size) + size) % size;
		int range = normalized_position + getSize();
		while (normalized_position < range) {
			if (this.getPlateAtPosition(normalized_position) == null) {
				setPlateAtPosition(plate, normalized_position);
				return normalized_position;
			}
			normalized_position++;
		}
		throw new BeltFullException(this);
	}

	public Iterator<Plate> iterator() {
		return new BeltIterator(this, 0);
	}
	
	public Iterator<Plate> iterator(double max_price) {
		return new PriceThresholdBeltIterator(this, 0, max_price);
	}
	
	public Iterator<Plate> iterator(Plate.Color color) {
		return new ColorFilteredBeltIterator(this, 0, color);
	}
	
	public Iterator<Plate> iteratorFromPosition(int position) {
		return new BeltIterator(this, position);
	}
	
	public Iterator<Plate> iteratorFromPosition(int position, double max_price) {
		return new PriceThresholdBeltIterator(this, position, max_price);
	}
	
	public Iterator<Plate> iteratorFromPosition(int position, Plate.Color color) {
		return new ColorFilteredBeltIterator(this, position, color);
	}

	public void rotate() {
		Plate[] output = new Plate[size];
		output[0] = this.belt[size - 1];
		for (int i = 1; i < size; i++) {
			output[i] = this.belt[i - 1];
		}
		this.belt = output;
	}

}
