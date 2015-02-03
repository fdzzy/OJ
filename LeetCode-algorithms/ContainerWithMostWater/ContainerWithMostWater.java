/*
 * Container With Most Water 
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point 
 * at coordinate (i, ai). n vertical lines are drawn such that the two end points 
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
 * forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    	if(height.length <= 0) return 0;
    	
    	int maxArea = 0;
    	int low = 0;
    	int high = height.length-1;
    	while(low < high) {
    		int area = ((height[low] < height[high]) ? height[low] : height[high])
    				* (high - low);
    		if(area > maxArea) maxArea = area;
    		if(height[low] < height[high]) low++;
    		else if(height[low] > height[high]) high--;
    		else { // height[low] == height[high]
    			int left = low+1;
    			int right = high-1;
    			while(left < right && height[left] == height[right]) {
    				left++;
    				right--;
    			}
    			if(left == right) { // all same, choose whatever
    				low++;
    			} else {
    				if(height[left] < height[right]) low++;
    				else high--;
    			}
    			
    		}
    	}
        return maxArea;
    }
    
    public static void main(String[] args) {
    	//int[] height = {5,6,3,7,1,2};
    	int[] height = {3,1,9,2,3,9,1,3};
    	ContainerWithMostWater c = new ContainerWithMostWater();
    	System.out.println(c.maxArea(height));
    }
}
