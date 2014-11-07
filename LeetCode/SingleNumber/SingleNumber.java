
public class SingleNumber {

	public int singleNumber(int[] A) {
        int num = 0;
        for(int ele : A) {
        	num ^= ele;
        }
        return num;
    }
	
	public static void main(String[] args) {
		SingleNumber s = new SingleNumber();
		int[] array = {1,3,5,4,-9,7,4,3,2,-9,5,7,1};  
		System.out.println(s.singleNumber(array));
	}
}
