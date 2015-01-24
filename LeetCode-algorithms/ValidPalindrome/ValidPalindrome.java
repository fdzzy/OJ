/*
 * Valid Palindrome
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 */
public class ValidPalindrome {
	
    public boolean isPalindrome(String s) {
    	if(s == null || s.isEmpty()) return true;
    	
    	for(int i=0, j=s.length()-1; i<j ; ++i, --j) {
    		while(i<j && !Character.isLetterOrDigit(s.charAt(i))) ++i;
    		while(i<j && !Character.isLetterOrDigit(s.charAt(j))) --j;
    		if(i>=j) return true;
    		if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
    	}
        return true;
    }
    
    public static void main(String[] args) {
    	ValidPalindrome v = new ValidPalindrome();
    	String[] tc = {"A man, a plan, a canal: Panama", "race a car", "", ",", ".,"};
    	for(String s : tc) {
    		System.out.println(s + "\n" + v.isPalindrome(s));
    	}
    }
	
}
