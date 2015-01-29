/*
 * Excel Sheet Column Title 
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *  1 -> A
 *  2 -> B
 *  3 -> C
 *  ...
 *  26 -> Z
 *  27 -> AA
 *  28 -> AB
 *   
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
    	if(n < 1) return "";
    	
    	StringBuilder sb = new StringBuilder();
    	while(n > 26) {
    		n--;
    		sb.append((char)('A' + n%26));
    		n /= 26;
    	}
    	if(n > 0) {
    		sb.append((char)('A' + n - 1));
    	}

        return sb.reverse().toString(); 
    }
    
    public static void main(String[] args) {
    	ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
    	for(int i=1; i<=(26*26+26+1) ; i++) {
    		System.out.println(i + ": " + e.convertToTitle(i));
    	}
    }
}
