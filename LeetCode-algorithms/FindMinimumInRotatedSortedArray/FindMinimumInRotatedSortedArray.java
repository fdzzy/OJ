/*
 * Find Minimum in Rotated Sorted Array 
 * 
 * I.
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * II.
 * 
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * 
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] num) {
    	if(num.length <= 0) return 0;
    	else if(num.length == 1) return num[0];
        int low = 0, high = num.length-1;
        if(num[low] < num[high]) return num[low];
        
        while(low < high) {
        	if((high - low) == 1) return num[high];
        	int middle = (low + high) / 2;
        	if(num[low] > num[middle]) high = middle;
        	else low = middle;
        }
        return low;
    }
    
    private int findSubMin(int[] num, int low, int high) {
    	if(num.length <= 0) return 0;
    	if(low == high) return num[low];
        if(num[low] < num[high]) return num[low];
        if((low + 1) == high) return num[high];

        int middle = (low + high) / 2;
        if(num[low] < num[middle]) {
        	return findSubMin(num, middle, high);
        } else if(num[low] > num[middle]) {
        	return findSubMin(num, low, middle);
        } else { // num[low] == num[middle]
        	int leftMin = findSubMin(num, low, middle);
        	int rightMin = findSubMin(num, middle, high);
        	return (leftMin < rightMin) ? leftMin : rightMin;
        }
    }
    
    public int findMinInDuplicates(int[] num) {
    	return findSubMin(num, 0, num.length-1);
    }
    
    public static void main(String[] args) {
    	//int[] num = {4,5,6,7,0,0,1,2,4};
    	int[] num = {10,1,10,10,10};
    	FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
    	System.out.println(f.findMinInDuplicates(num));
    }
}
