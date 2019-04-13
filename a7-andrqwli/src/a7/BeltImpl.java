package a7;

import java.util.ArrayList;
import java.util.List;

import a7.PlateEvent.EventType;
import comp401sushi.Plate;


public class BeltImpl implements Belt {

	private Plate[] _belt;
	private List<BeltObserver> observers;
	private Customer[] customers;
	
	public BeltImpl(int belt_size) {
		if (belt_size < 1) {
			throw new IllegalArgumentException("Illegal belt size");
		}
		
		_belt = new Plate[belt_size];
		customers = new Customer[belt_size];
		this.observers = new ArrayList<BeltObserver>();
	}
	
	public int getSize() {
		return _belt.length;
	}
	
	public Plate getPlateAtPosition(int position) {
		position = normalize_position(position);

		return _belt[normalize_position(position)];
	}
	
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}
		
		_belt[position] = plate;
		
		PlateEvent e = new PlateEvent(EventType.PLATE_PLACED, plate, position);
		
		this.notifyObservers(e);
	}

	public void clearPlateAtPosition(int position) {
		position = normalize_position(position);
		
		this.notifyObservers(new PlateEvent(EventType.PLATE_REMOVED, this.getPlateAtPosition(position), position));
		
		_belt[position] = null;		
	}

	private int normalize_position(int position) {
		int size = getSize();
		return (((position % size) + size) % size);
	}
	
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int offset = 0;
		position = normalize_position(position);

		while (offset < getSize()) {
			try {
				setPlateAtPosition(plate, position+offset);

				return normalize_position(position+offset);
			}
			catch (BeltPlateException e) {
				offset += 1;
			}
		}
		throw new BeltFullException(this);
	}

	public void rotate() {
		Plate last_plate = _belt[getSize()-1];
		
		for (int i=getSize()-1; i>0; i--) {
			_belt[i] = _belt[i-1];
		}
		_belt[0] = last_plate;
		
		notifyCustomers();
	}

	public void addBeltObserver(BeltObserver o) {
		observers.add(o);
	}

	public void removeBeltObserver(BeltObserver o) {
		observers.remove(o);
	}
	
	public void notifyObservers(PlateEvent e) {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).handlePlateEvent(e);
		}
	}
	
	public void registerCustomerAtPosition(Customer c, int position) {
		if (c == null) {
			throw new IllegalArgumentException();
		}
		
		position = normalize_position(position);
		
		
 		if (customers[position] != null) {
 			throw new RuntimeException("Belt position already has a registered Customer");
		} else {
			System.out.println(customers.length);
			for (int i = 0; i < customers.length; i++) {
				if (customers[i] == c) {
					throw new RuntimeException("Customer already registered");
				}
			}
			customers[position] = c;
		}
		
	}

	public Customer unregisterCustomerAtPosition(int position) {
		position = normalize_position(position);
		
		if (customers[position] == null) {
			return null;
		} else {
			Customer temp = customers[position];
			customers[position] = null;
			return temp;
		}
	}
	
	public void notifyCustomers() {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] == null) {
				continue;
			}
			customers[i].observePlateOnBelt(this, getPlateAtPosition(i), i);
		}
	}
}
