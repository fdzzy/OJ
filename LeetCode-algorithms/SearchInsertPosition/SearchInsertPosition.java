/*
 * Search Insert Position 
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * 
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
    	if(A == null || A.length <= 0) return 0;
    	
    	int low = 0, high = A.length-1;
    	while(low < high) {
    		int middle = (low + high) / 2;
    		if(target < A[middle]) {
    			high = middle - 1;
    		} else if (target > A[middle]) {
    			low = middle + 1;
    		} else {
    			return middle;
    		}
    	}
    	// low == high
		if(target <= A[low]) return low;
		else return low+1;
    }
    
    public static void main(String[] args) {
    	SearchInsertPosition s = new SearchInsertPosition();
    	int[] A = {1,3,5,6};
    	int[] targets = {5,2,7,0};
    	for(int target : targets) {
    		System.out.println(s.searchInsert(A, target));
    	}
    }
}
