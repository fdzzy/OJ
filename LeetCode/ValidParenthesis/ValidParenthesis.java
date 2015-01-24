/*
 * Valid Parentheses
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ValidParenthesis {
	Map<Character, Character> pairs = new HashMap<>();
	
	public ValidParenthesis() {
		pairs.put('}', '{');
		pairs.put(')', '(');
		pairs.put(']', '[');
	}

    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	for(char ch : s.toCharArray()) {
    		char top;
    		switch(ch) {
    		case '{':
    		case '(':
    		case '[':
    			stack.push(ch);
    			break;
    		case '}':
    		case ')':
    		case ']':
    			if(stack.empty()) return false;
    			top = stack.pop();
    			if(top != pairs.get(ch)) return false;
    			break;
    		default :
    			return false;
    		}
    	}
    	if(!stack.empty()) return false;
    	else return true;
    }
    
    public static void main(String[] args) {
    	ValidParenthesis v = new ValidParenthesis();
    	String[] strs = {"{{()[]}}", "()", "()[]{}", "(]", "([)]", "[", "}"};
    	for(String str : strs) {
    		System.out.println(str + ": " + v.isValid(str));
    	}
    }

}
