package chapter3;

import java.util.LinkedList;

public class Shelter {
	LinkedList<Animal>		dogs = new LinkedList<>();
	LinkedList<Animal>		cats = new LinkedList<>();
	int			time  =  0;
	
	public Shelter () {
		
	}
	public	Animal	dequeueAny () {			
		if ( dogs.peek().getTime() < cats.peek().getTime() ) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}
	
	public Animal dequeueDog () {
		return dogs.poll();
	}
	
	public Animal dequeueCat () {
		return cats.poll();
	}
	
	public void enqueue (Animal a) {
		a.setTime( time );
		if (a instanceof Dog) {
			dogs.addLast( a );
		}else if (a instanceof Cat) {
			cats.addLast( a );
		}
	}
}