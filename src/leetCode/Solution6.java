package leetCode;

public class Solution6 {
	public static void main (String[] args) {
		System.out.println( new Solution6().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println( new Solution6().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
    public boolean isInterleave(String s1, String s2, String s3) {
        // trivial case
        return helper(s1, s2, s3);
    }
    private boolean helper(String s1, String s2, String s3) {
        // trivial case
        if ( s1.length()==0 ) {
            return s2.equals(s3);
        } else if ( s2.length()==0 ) {
            return s1.equals(s3);
        } 
        
        if ( s1.charAt(0) == s3.charAt(0) && s2.charAt(0) != s3.charAt(0) ){
            return helper(s1.substring(1), s2, s3.substring(1));    
        } else if ( s2.charAt(0) == s3.charAt(0) && s1.charAt(0) != s3.charAt(0) ) {
            return helper(s1, s2.substring(1), s3.substring(1));
        } else if ( s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0) ) {
            return helper(s1.substring(1), s2, s3.substring(1)) 
            || helper(s1, s2.substring(1), s3.substring(1));
        } else {
            return false;
        }
    }
}