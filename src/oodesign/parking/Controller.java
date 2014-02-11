package oodesign.parking;

public class Controller {
	ParkingLot		pl;
	Calculator		cal;
	
	public Controller (ParkingLot pl, Calculator cal) {
		this.pl  =  pl;
		this.cal =  cal;
	}
	
	public void register(int idx, Vehicle.Type type) throws ParkException {
		Time  time  =  Time.getCurrentTime();
		Vehicle  v  =  vehicleFactory(idx, type, time);
		pl.pullOver(idx, v);
	}
	
	public void unregister( Vehicle v ) throws ParkException{
		pl.pickUp(v.position);
		cal.calculateFee(v);
	}
	
	private Vehicle vehicleFactory (int idx, Vehicle.Type type, Time time) {
		switch (type) {
		case car:
			return new Car(idx, type, time);
		case suv:
			return new SUV(idx, type, time);
		case van:
			return new Van(idx, type, time);
		}
		return null;
	}
}