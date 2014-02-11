package oodesign.parking;

public abstract class Vehicle {
	
	public enum Type {
		van, car, suv;
	}

	int		position;
	Type	type;
	Time	arrival;
	
	public Vehicle (int position, Type type, Time arrival) {
		this.type  =  type;
		this.arrival = arrival;
		this.position  =  position;
	}

}