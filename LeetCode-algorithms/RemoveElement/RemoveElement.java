/*
 * Remove Element 
 * 
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
    	if(A.length <= 0) return 0;
        int i = 0;
        int j = A.length-1;
        int len = A.length;
        while(i<j) {
        	while(i<j && A[i] != elem) i++;
        	while(i<j && A[j] == elem) {
        		j--;
        		len--;
        	}
        	if(i<j) {
        		A[i] = A[j];
        		len--;
        		i++;
        		j--;
        	}
        }
        if(A[i] == elem) len--;
        return len;
    }
    
    public static void main(String[] args) {
    	int[] A = {0,4,4,0,4,4,4,0,2};
    	RemoveElement r = new RemoveElement();
    	int len = r.removeElement(A, 4);
    	System.out.println(len);
    	for(int i=0; i<len ; i++) {
    		System.out.print(A[i] + " ");
    	}
    	
    }
}
