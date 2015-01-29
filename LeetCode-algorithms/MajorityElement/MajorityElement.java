/*
 * Majority Element 
 * 
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always 
 * exist in the array.
 */
import java.util.Collections;
import java.util.PriorityQueue;


public class MajorityElement {
    public int majorityElement(int[] num) {
    	int size = num.length/2 + num.length % 2;
    	PriorityQueue<Integer> heap = new PriorityQueue<>(size, Collections.reverseOrder());
    	int i;
        for(i=0; i<size; i++) {
        	heap.offer(num[i]);
        }
        int top = heap.peek();
        for(; i<num.length ; i++) {
        	if(num[i] < top) {
        		heap.poll();
        		heap.offer(num[i]);
        	}
        }
        
        return heap.peek();
    }
    
    public int majorityElementBit(int[] num) {
    	int majority = 0;
    	for(int i=0; i<32 ; i++) {
    		int ithBit = 0;
    		for(int j=0; j<num.length ; j++) {
    			ithBit += (num[j] >> i) & 0x01;
    		}
    		if(ithBit >= (num.length/2 + num.length%2)) {
    			majority += 1 << i;
    		}
    	}
    	return majority;
    }
    
    public int majorityElementMooreVoting(int[] num) {
    	int current = num[0];
    	int counter = 1;
    	for(int i=1; i<num.length ; i++) {
    		if(num[i] == current) counter++;
    		else counter--;
    		if(counter == 0) {
    			current = num[i];
    			counter++;
    		}
    	}
    	return current;
    }
    
    public static void main(String[] args) {
    	MajorityElement m = new MajorityElement();
    	int[] num = {3,1,3,2,3};
    	//int[] num = {1,2,2,5,5,2,1,2,2};
    	System.out.println(m.majorityElement(num));
    	System.out.println(m.majorityElementBit(num));
    	System.out.println(m.majorityElementMooreVoting(num));
    }
}
