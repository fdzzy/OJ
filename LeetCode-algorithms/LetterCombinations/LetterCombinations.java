/*
 * Letter Combinations of a Phone Number 
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
	private char[][] maps = {
			{'a', 'b', 'c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
	};
	
	private List<String> subCombinations(String digits) {
		List<String> results = new ArrayList<>();
		if(digits.length() == 1) {
			for(char ch : maps[digits.charAt(0) - '2']) {
				results.add("" + ch);
			}
			return results;
		}
		char first = digits.charAt(0);
		List<String> subResults = subCombinations(digits.substring(1));
		for(char ch : maps[first - '2']) {
			for(String str : subResults) {
				results.add(ch + str);
			}
		}
		return results;
	}
	
    public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() <= 0) {
			List<String> result = new ArrayList<>();
			result.add("");
			return result;
		}
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<digits.length() ; i++) {
    		char ch = digits.charAt(i);
    		if(ch >= '2' && ch <= '9') sb.append(ch);
    	}
    	return subCombinations(sb.toString());
    }
    
    public static void main(String[] args) {
    	LetterCombinations l = new LetterCombinations();
    	System.out.println(l.letterCombinations(""));
    	System.out.println(l.letterCombinations("23"));
    }

}
