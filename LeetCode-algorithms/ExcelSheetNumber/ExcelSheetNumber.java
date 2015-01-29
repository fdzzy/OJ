/*
 * Excel Sheet Column Number 
 * 
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28 
 */
public class ExcelSheetNumber {
    public int titleToNumber(String s) {
    	if(s == null || s.isEmpty()) return 0;
    	int result = 0;
    	for(char ch : s.toCharArray()) {
    		if(ch < 'A' || ch > 'Z') return result;
    		result = result * 26 + ch - 'A' + 1;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	ExcelSheetNumber e = new ExcelSheetNumber();
    	System.out.println(e.titleToNumber("Z"));
    	System.out.println(e.titleToNumber("AA"));
    	System.out.println(e.titleToNumber("AAA"));
    }
}
