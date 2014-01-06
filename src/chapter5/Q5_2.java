package chapter5;

public class Q5_2 {

	public static void main (String[] args) {
		System.out.println( getBinaryFloat(0.5f));
		System.out.println( getBinaryFloat(0.625f));
	}
	public static String getBinaryFloat (float f) {
		assert ( 0.0 < f &&  f < 1.0) : " f in (0.0, 1.0)";
		StringBuffer	sb  =  new StringBuffer();
		sb.append("0.");
		f = f*2;
		while ( f > 0 ) {
			if ( sb.length() > 32 ) {
				return "ERROR";
			}
			if ( f >= 1) {
				sb.append( 1 );
				f = ( f - 1 ) * 2;
			} else if ( f < 1) {
				sb.append( 0 );
				f = f * 2;
			}
		}
		return sb.toString();
	}
}
