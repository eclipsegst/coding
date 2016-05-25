package challenge;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author Zhaolong Zhong May 24, 2016
 * 
 * Flatten Nested List Iterator
 * 
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * Given the list [1,[4,[6]]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        NestedInteger n = stack.pop();
        return n.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            NestedInteger n = stack.peek();
            if (n.isInteger()) {
                return true;
            }
            
            stack.pop();
            for (int i = n.getList().size() - 1; i >= 0; i--) {
                stack.push(n.getList().get(i));
            }
        }
        
        return false;
    }
}

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();
	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();
	
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}