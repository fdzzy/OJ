/*
 * Find Peak Element 
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any one of the 
 * peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return
 * the index number 2.
 * 
 * Note:
 * Your solution should be in logarithmic complexity.
 * 
 */
public class FindPeakElement {
    public int findPeakElementSlow(int[] num) {
        if(num == null || num.length <= 0) return -1;
        if(num.length == 1) return 0;
        if(num[0] > num[1]) return 0;
        int i;
        for(i=1; i<num.length-1 ; i++) {
        	if((num[i] > num[i-1]) && (num[i] > num[i+1])) return i;
        }
        if(num[i] > num[i-1]) return i;
        else return -1;
    }

    public int findPeakElement(int[] num) {
        if(num == null || num.length <= 0) return -1;
        if(num.length == 1) return 0;
       
        int low = 0;
        int high = num.length - 1;
        while(true) {
        	int middle = (low + high) / 2;
        	if((middle == 0 || num[middle] > num[middle-1]) && 
        	   (middle == (num.length-1) || num[middle] > num[middle+1])) {
        		return middle;
        	}
        	if(middle == low) {	// only two element left
        		low++;
        	} else if(num[middle-1] > num[middle]) {
        		high = middle;
        	} else {	// must be num[middle+1] > num[middle]
				low = middle;
			}
        }
    }
    
    public static void main(String[] args) {
    	FindPeakElement f = new FindPeakElement();
    	int[][] nums = {
    			{2},
    			{1,2},
    			{2,1},
    			{1,2,3,1},
    			{1,2,3,4,5,6,4,3,2}
    	};
    	for(int i=0; i<nums.length ; i++)
    	System.out.println(f.findPeakElement(nums[i]));
    }
}
