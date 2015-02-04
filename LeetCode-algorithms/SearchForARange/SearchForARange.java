/*
 * Search for a Range 
 * 
 * Given a sorted array of integers, find the starting and ending position of a given 
 * target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * 
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
    	int[] range = new int[2];
    	if(A == null || A.length <= 0) {
    		range[0] = range[1] = -1;
    		return range;
    	}
    	
    	int low = 0, high = A.length-1;
    	while(low < high) {
    		int middle = (low + high) / 2;
    		if(target < A[middle]) {
    			high = middle - 1;
    		} else if (target > A[middle]) {
    			low = middle + 1;
    		} else {
    			// target == A[middle]
    			int leftLow = low, leftHigh = middle;
    			while(leftLow < leftHigh) {
    				int leftMiddle = (leftLow + leftHigh) / 2;
    				if(target == A[leftMiddle]) {
    					leftHigh = leftMiddle - 1;
    				} else {
    					// target > A[leftMiddle]
    					leftLow = leftMiddle + 1;
    				}
    			}
    			range[0] = (A[leftLow] == target) ? leftLow : (leftLow+1);
    			int rightLow = middle, righHigh = high;
    			while(rightLow < righHigh) {
    				int rightMiddle = (rightLow + righHigh) / 2;
    				if(target == A[rightMiddle]) {
    					rightLow = rightMiddle + 1;
    				} else {
    					// target < A[rightMiddle]
    					righHigh = rightMiddle - 1;
    				}
    			}
    			range[1] = (A[righHigh] == target) ? righHigh : (righHigh-1);
    			return range;
    		}
    	}
    	if(A[low] == target) {
    		range[0] = range[1] = low;
    	} else {
    		range[0] = range[1] = -1;
    	}
    	return range;
    }
    
    public static void main(String[] args) {
    	SearchForARange s = new SearchForARange();
    	//int[] A = {5,7,7,8,8,8,8,8,9,10,10,10,10};
    	//int[] A = {0,3,4,5,6,7,8};
    	int[] A = {8,9,10};
    	int[] range = s.searchRange(A, 8);
    	System.out.println(range[0]+","+range[1]);
    }
}
