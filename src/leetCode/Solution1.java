package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;


public class Solution1 {
	public static void main (String[] args) {
		Solution1	 app  =  new Solution1();
		System.out.println( app.evalRPN(new String[]{"1","2","+","1","*"}) );
		System.out.println( app.evalRPN(new String[]{"4", "13", "5", "/", "+"}) );
		System.out.println( app.evalRPN(new String[]{"2", "1", "+", "3", "*"}) );
		System.out.println( app.evalRPN(new String[]{"2", "1", "+"}) );
		System.out.println( app.evalRPN(new String[]{"2", "1", "1","+","+"}) );
		System.out.println( app.evalRPN(new String[]{"2", "1", "1","1","+","+","+"}) );
		
		
	}
    public int evalRPN(String[] tokens) {
        return evalRPNHelper(  new LinkedList<String>(Arrays.asList(tokens)  ));
    }
	private int evalRPNHelper( List<String> los ){
		// trivial case
		if ( los.size() == 1 ) {
			return Integer.parseInt(los.get(0));
		}
		// non trivial case
		// 1. process the los
		List<String>	ret  =  new ArrayList<>();
		
		int		 i  =  2;	// index
		while ( i < los.size() ){
			if ( isOperator( los.get(i)) ){
				// once the first operator is found , break.
				int		k  =  compute(los.get(i-2), los.get(i-1), los.get(i));
				ret.add( Integer.toString(k) );
				ret.addAll( los.subList(i+1, los.size()));
				break;
			}
			ret.add( los.get(i-2) );
			++i;
		}
		// 2. do recursion on the result
		return evalRPNHelper(ret);
	}


	private int compute( String s1, String s2, String op ) {
		int		a  =  Integer.parseInt(s1);
		int		b  =  Integer.parseInt(s2);
		int		ret = 0;
		switch (op) {
		case "+":
			ret = a + b;
			break;
		case "-":
			ret = a - b;
			break;
		case "*":
			ret = a * b;
			break;
		case "/":
			ret = a / b;
			break;
		default:
			break;
		}
		return ret;
	}

	private boolean isOperator( String op ) {
		return op.equals("+") || op.equals("-") 
			|| op.equals("/") || op.equals("*");
	}
}
