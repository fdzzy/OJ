/*
 * Generate Parentheses 
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GenerateParenthesis {
	public List<List<String>> parenths = new ArrayList<>();
	
	public GenerateParenthesis() {
		List<String> one = new ArrayList<>();
		one.add("()");
		parenths.add(one);
	}
	
    public List<String> generateParenthesis(int n) {
    	if(n <= 0) return null;
    	if(n <= parenths.size()) return parenths.get(n-1);
    	
        Set<String> resultSet = new HashSet<>();
        List<String> subResult = generateParenthesis(n-1);
        for(String subStr : subResult) {
        	resultSet.add("()" + subStr);
        	resultSet.add("(" + subStr + ")");
        	resultSet.add(subStr + "()");
        }

    	for (int i = 2; i < n; i++) {
    		List<String> sub1 = generateParenthesis(i);
    		List<String> sub2 = generateParenthesis(n-i);
    		for(int j = 0; j < sub1.size(); j++) {
    			for (int k = 0; k < sub2.size(); k++) {
    				resultSet.add(sub1.get(j) + sub2.get(k));
				}
    		}
			
		}
        
    	parenths.add(n-1, new ArrayList<String>(resultSet));
        return parenths.get(n-1);
    }
	
	public static void main(String[] args) {
		GenerateParenthesis g = new GenerateParenthesis();
		g.generateParenthesis(5);
		for(List<String> sub : g.parenths) {
			System.out.println("length: " + sub.size());
			System.out.println(sub + "\n");
		}
		
	}

}
