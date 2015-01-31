/*
 * Reverse Words in a String 
 * 
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Clarification:
 * 
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * 
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * 
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if(s == null) return null;
        if(s.isEmpty()) return s; 
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        boolean first = true;
        while(i>=0) {
        	while(i>=0 && s.charAt(i) == ' ') i--;
        	if(i<0) break;
        	int end = i;
        	i--;
        	while(i>=0 && s.charAt(i) != ' ') i--;
        	if(i<0) {
        		if(first) first = false;
        		else sb.append(' ');
        		sb.append(s.substring(0, end+1));
        	} else {
        		if(first) first = false;
        		else sb.append(' ');
        		sb.append(s.substring(i+1, end+1));
        	}
        	i--;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	ReverseWordsInAString r = new ReverseWordsInAString();
    	String s = "the sky is blue";
    	System.out.println(r.reverseWords(s));
    }
}
