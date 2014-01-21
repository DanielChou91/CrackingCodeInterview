package chapter14;

import java.util.Iterator;


public class CircularArray<E> implements Iterable<E>{

	E[]			item ;
	int			p;		// start position of the array
	int			r;		// end position of the array, r points to available
	// when the Circular Array is full, we have p + 1 = r
	// if the Circular Array is emtpy, p  =  r
	// by convention, we circular array can hold n-1 elment at most
	int			n;		// size of array
	@SuppressWarnings("unchecked")
	public CircularArray (int	n) {
		this.n  =  n;
		item    =  (E[])new Object[n];
		p  =  0;
		r  =  0;
	}

	public void add (E e) {
		if ( p == r + 1 ) {
			throw new IndexOutOfBoundsException();
		}
		item[r] =  e;
		r  =  (r + 1) % n;
	}

	public E get (int idx) {
		int		count  =  ( r - p + n ) % n;
		if ( idx > count - 1) {
			throw new IndexOutOfBoundsException("illegal position");
		}
		return item[ (p + idx) % n];
		
	}

	public void set (int idx, E e) {
		int		count  =  ( r - p + n ) % n;
		if ( idx > count - 1 ) {
			throw new IndexOutOfBoundsException("illegal position");
		}
		item[(p+idx) % n ]  =  e;
	}
	@Override
	public Iterator<E> iterator() {
		return new Itr();
	}
	private class Itr implements Iterator<E> {
		int		cursor = p;  
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cursor == r-1;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			// TODO Auto-generated method stub
			cursor = (cursor + 1) % n;
			Object[]	obj  =  item;
			
			return (E) obj[cursor];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}
