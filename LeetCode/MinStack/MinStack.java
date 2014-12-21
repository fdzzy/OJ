/*
 * Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Use another stack to store the minimum number
 * Optimization: only push minimum stack when new min is found
 */
import java.util.Arrays;

public class MinStack {
	static class IntStack {
		private static final int DEFAULT_SIZE = 16;
		private int capacity = DEFAULT_SIZE;
		private int size = 0;
		private int[] stack = new int[DEFAULT_SIZE];
		
		public void add(int x) {
			if(size >= capacity) {
				capacity *= 2;
				stack = Arrays.copyOf(stack, capacity);
			}
			stack[size] = x;
			++size;
		}
		
		public void pop() {
			if(isEmpty()) return;
			--size;
		}
		
		public int peek() {
			if(isEmpty()) return 0;
			return stack[size-1];
		}
		
		public boolean isEmpty() {
			return (size <= 0);
		}
	}
	
	private IntStack valStack = new IntStack();
	private IntStack minStack = new IntStack();
	
    public void push(int x) {
    	valStack.add(x);
    	if(minStack.isEmpty()) minStack.add(x);
    	else {
    		int min = minStack.peek();
    		if(x <= min) minStack.add(x);
    	}
    }

    public void pop() {
    	if(valStack.peek() == minStack.peek()) minStack.pop();
    	valStack.pop();
    }

    public int top() {
    	if(valStack.isEmpty()) return 0;
    	return valStack.peek();
    }

    public int getMin() {
    	if(minStack.isEmpty()) return 0;
    	return minStack.peek();
    }
    
    public static void main(String[] args) {
    	MinStack m = new MinStack();
    	m.push(5);
    	m.push(6);
    	m.push(3);
    	m.push(8);
    	m.push(9);
    	m.push(2);
    	m.push(7);
        m.pop();
    	System.out.println(m.top());
    	System.out.println(m.getMin());
    	m.pop();
    	System.out.println(m.top());
    	System.out.println(m.getMin());
    	m.pop();
    	System.out.println(m.top());
    	System.out.println(m.getMin());
    	m.pop();
    	System.out.println(m.top());
    	System.out.println(m.getMin());
    	m.pop();
    	System.out.println(m.top());
    	System.out.println(m.getMin());
    	m.pop();
    	System.out.println(m.top());
    	System.out.println(m.getMin());
    }
}
