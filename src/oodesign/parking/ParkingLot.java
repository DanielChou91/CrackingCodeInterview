package oodesign.parking;

public class ParkingLot {
	// data definition
	Vehicle[]		lot ;
	int				size;
	
	// function definition
	public ParkingLot (int size) {
		this.size  =  size;
		lot  =  new Vehicle[size];
	}
	
	public void pullOver ( int idx, Vehicle v ) throws ParkException {
		if ( lot[idx] != null ) {
			throw new LotFullException(idx +" is full!");
		}
		lot[idx]  =  v;
	}
	
	public Vehicle pickUp (int idx) throws ParkException{
		if ( lot[idx] == null ) {
			throw new LotEmptyException( idx + " is empty!");
		}
		Vehicle  ret  =  lot[idx];
		lot[idx]  =  null;
		return ret;
	}
}