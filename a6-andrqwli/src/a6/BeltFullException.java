package a6;

public class BeltFullException extends Exception {

	private Belt belt;
	
	public BeltFullException(Belt belt) {
		this.belt = belt;
	}
	
	public Belt getBelt() {
		return this.belt;
	}
}
