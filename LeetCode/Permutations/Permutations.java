/*
 * Permutations
 * 
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * Divide and Conquer
 *  
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Combination {
	private List<Integer> nums;
	
	public Combination(List<Integer> nums) {
		this.nums = nums;
	}
	
	public List<Integer> getList() {
		return nums;
	}
	
	@Override
	public boolean equals(Object comb) {
		if(this == comb) return true; 
		if(!(comb instanceof Combination)) return false;
		Combination otherComb = (Combination)comb;
		if(nums.size() != otherComb.nums.size()) return false;
		for(int i=0; i<nums.size() ; ++i) {
			if(nums.get(i) != otherComb.nums.get(i)) return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 0;
		for(Integer num : nums) {
			result += num.hashCode();
		}
		return result;
	}
}

public class Permutations {	
	
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<>();
		if(num.length == 0) return result;
		if(num.length == 1) {
			List<Integer> comb = new ArrayList<>();
			comb.add(num[0]);
			result.add(comb);
			return result;
		}
		Set<Combination> combinations = new HashSet<>();
		int first = num[0];
		int[] subNum = new int[num.length-1];
		System.arraycopy(num, 1, subNum, 0, num.length-1);
		List<List<Integer>> subPerms = permute(subNum);
		for(List<Integer> comb : subPerms) {
			for(int i=0; i<num.length ; ++i) {
				List<Integer> newComb = new ArrayList<>(comb);
				newComb.add(i, first);
				Combination combination =  new Combination(newComb);
				combinations.add(combination);
			}
		}
		for(Combination c : combinations) {
			result.add(c.getList());
		}
		return result;
	}
	
	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = {1,1,2};
		List<List<Integer>> result = p.permute(nums);
		for(List<Integer> c : result) {
			System.out.println(Arrays.toString(c.toArray()));
		}
		System.out.println(result.size());
	}
}
