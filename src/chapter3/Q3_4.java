package chapter3;

import java.util.Stack;

public class Q3_4 {

	public static void main ( String[] args ) {
		hanoi( 4 );
	}
	// the classical algorithm for Tower of Hanoi
	public static void hanoi( int d ) {
		// d is the number of disk
		hanoiHelper(d, 1, 3, 2);
	}
	public static void hanoiHelper (int d, int src, int dst, int mid) {
		// trivial case
		if ( d == 0 ) {
			return;
		} 
		hanoiHelper(d-1, src, mid, dst);
		System.out.println( src + "->" + dst );
		hanoiHelper(d-1, mid, dst, src);
	}
	
	// Class Tower
	public class Tower {
		Stack<Integer>	disks ;
		private		       int  idx; // integer that identify the disk
		
		public Tower (int idx) {
			disks     =  new Stack<>();
			this.idx  =  idx;
		}
		
		// put disk on the top
		public void put ( Integer i ) {
			disks.push( i );
		}

		public int getIdx () {
			return idx;
		}
		private void moveTopDisk(Tower dst) {
			Integer  top  =  disks.pop();
			dst.disks.push( top );
			System.out.println( this.getIdx() + "->" + dst.getIdx() );
		}
		public void moveDisk(int d, Tower dst, Tower mid) {
			if ( d == 0 ) {
				return ;
			}
			moveDisk( d-1, mid, dst);
			moveTopDisk(dst);
			mid.moveDisk( d-1, dst, this);
		}		
	}
}