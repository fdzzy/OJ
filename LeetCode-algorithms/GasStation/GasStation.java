/*
 * Gas Station
 * 
 * There are N gas stations along a circular route, where the amount of gas at station 
 * i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel 
 * from station i to its next station (i+1). You begin the journey with an empty tank 
 * at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, 
 * otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 */
import java.util.ArrayList;
import java.util.List;

public class GasStation {

	// merge the two value i and (i+1) % size
	private void mergeValues(List<Integer> value, List<Integer> index, int i) {
		int sum = value.get(i);
		int nextIndex = (i+1) % value.size();
		sum += value.get(nextIndex);
		value.remove(nextIndex);
		value.set((nextIndex == 0 ? i-1 : i), sum);
		index.remove(nextIndex);
	}
	
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas.length <= 0 || cost.length <= 0 || gas.length != cost.length)
    		return -1;
    	List<Integer> value = new ArrayList<>();
    	List<Integer> index = new ArrayList<>();
    	for(int i=0; i<gas.length ; i++) {
    		value.add(gas[i] - cost[i]);
    		index.add(i);
    	}
    	while(true) {
    		if(value.size()==1) {
    			if(value.get(0) >= 0) return index.get(0);
    			else return -1;
    		}
    		int size = value.size();
    		for(int i=0; value.size()>1 && i<value.size() ; ) {
    			int ithValue = value.get(i);
    			int nextIndex = (i+1) % value.size();
    			if(ithValue >= 0) {
    				/* if I'm positive, find the longest sequence that the sum
    				 * is still positive
    				 */
    				if(ithValue + value.get(nextIndex) >= 0) {
    					mergeValues(value, index, i);
    				} else {
    					i++;
    				}
    			} else { // ithValue < 0, merge negatives
    				if(value.get(nextIndex) < 0) {
    					mergeValues(value, index, i);
    				} else {
    					i++;
    				}
    			}
    		}
    		if(value.size() == size) return -1;
    	}
    }
    
    public static void main(String[] args) {
    	//int[] gas  = {5,0,9,4,3,3,9,9,1,2};
    	//int[] cost = {6,7,5,9,5,8,7,1,10,5};
    	int[] gas  = {5,7,9,2};
    	int[] cost = {6,5,8,3};
    	GasStation g = new GasStation();
    	System.out.println(g.canCompleteCircuit(gas, cost));
    }
}
