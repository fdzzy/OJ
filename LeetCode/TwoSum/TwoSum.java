/*
 * Two Sum 
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {	
	
	public int[] twoSum(int[] numbers, int target) {
		int[] results = new int[2];
		Map<Integer,List<Integer>> map = new HashMap<>();
		
		for(int i=0; i<numbers.length; ++i) {
			List<Integer> list = map.get(numbers[i]);
			if(list == null) {
				list = new ArrayList<>();
				list.add(i+1);
				map.put(numbers[i], list);
			} else {
				list.add(i+1);
			}
		}
		for(int i=0; i<numbers.length ; ++i) {
			int diff = target - numbers[i];
			if(map.get(diff) != null) {
				if(diff == numbers[i] && map.get(diff).size() == 1)
					continue;
				results[0] = i + 1;
				List<Integer> indices = map.get(diff);
				results[1] = (diff == numbers[i]) ? indices.get(1) : indices.get(0);
				return results;
			}
		}
		return results;
	}
	/*
	public void quickSort(int[] numbers, int low, int high) {
		if(numbers.length <= 1 || low < 0 || high < 0 || low >= high)
			return;
		int pivot = numbers[low];
		int l = low, h = high;
		while(l < h) {
			while(l < h && numbers[h] >= pivot) h--;
			numbers[l] = numbers[h];
			while(l < h && numbers[l] < pivot) l++;
			numbers[h] = numbers[l];
		}
		numbers[l] = pivot;
		quickSort(numbers, low, l-1);
		quickSort(numbers, l+1, high);
	}
	
	private void merge(int[] num, int low, int middle, int high) {
		if(num.length <= 0 || low < 0 || high < 0 || low >= high) return;
		int[] helper = new int[high-low+1];
		int l = low, h = middle+1;
		int idx = 0;
		while(l <= middle && h <= high) {
			if(num[l] <= num[h]) {
				helper[idx++] = num[l];
				l++;
			} else {
				helper[idx++] = num[h];
				h++;
			}
		}
		while(l <= middle) helper[idx++] = num[l++];
		while(h <= high) helper[idx++] = num[h++];
		for(int i=0; i<helper.length ; i++) {
			num[low+i] = helper[i];
		}
	}
	
	public void mergeSort(int[] num, int low, int high) {
		if(num.length <= 0 || low < 0 || high < 0 || low >= high) return;
		int middle = (low+high)/2;
		mergeSort(num, low, middle);
		mergeSort(num, middle+1, high);
		merge(num, low, middle, high);
	}
	
	public int[] indexOf(int[] numbers, int target1, int target2) {
		int[] results = new int[2];
		if(numbers.length <= 0) return results;
		int index = 0;
		for(int i=0; index<2 && i<numbers.length ; ++i) {
			if(numbers[i] == target1 || numbers[i] == target2) {
				results[index] = i + 1;
				index++;
			}
		}
		return results;
	}
	
	public int[] twoSum3(int[] numbers, int target) {
		int[] sortNumbers = Arrays.copyOf(numbers, numbers.length);
		mergeSort(sortNumbers, 0, sortNumbers.length-1);
		int low = 0, high = sortNumbers.length-1;
		while(low < high) {
			int sum = sortNumbers[low] + sortNumbers[high];
			if(sum == target) break;
			else if(sum < target) low++;
			else high--;			
		}
		return indexOf(numbers, sortNumbers[low], sortNumbers[high]);
	}
	
	public int binarySearch(int[] numbers, int target) {
		if(numbers.length <= 0) return -1;
		int low = 0, high = numbers.length - 1;
		while(low < high) {
			int middle = (low + high) / 2;
			if(numbers[middle] == target) return middle;
			else if(numbers[middle] > target) high = middle - 1;
			else low = middle + 1;
		}
		return -1;
	}
	
	public int[] twoSum2(int[] numbers, int target) {
		int[] results = new int[2];
		for(int i=0; i<numbers.length-1; ++i) {
			for(int j=i+1; j<numbers.length; ++j) {
				if(target == (numbers[i] + numbers[j])) {
					results[0] = i+1;
					results[1] = j+1;
					return results;
				}
			}
		}
		return results;
	}*/

	public static void main(String[] args) {
		TwoSum t = new TwoSum();
		//int[] numbers = {4,7,1,3,9,8,5};
		int[] numbers = {0,4,3,0};
		//t.quickSort(numbers, 0, numbers.length-1);
		int[] results = t.twoSum(numbers, 0);
		System.out.println(Arrays.toString(results));
	}
}
