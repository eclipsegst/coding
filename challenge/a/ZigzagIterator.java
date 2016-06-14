package a;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * @author Zhaolong Zhong Jun 13, 2016
 */
public class ZigzagIterator implements Iterator<Integer>{
	private List<Iterator<Integer>> itList;
	private int turns;
	
	public ZigzagIterator(List<Iterator<Integer>> list) {
		this.itList = new LinkedList<Iterator<Integer>>();
		
		for (Iterator<Integer> it : list) {
			this.itList.add(it);
		}
		
		turns = 0;
	}
	
	public Integer next() {
		if (!hasNext()) {
			return 0;
		}
		
		Integer res = 0;
		
		int position = turns % itList.size(); // get position
		Iterator<Integer> current = itList.get(position);
		res = current.next();
		
		// remove iterator if it's empty
		if (!current.hasNext()) {
			itList.remove(turns % itList.size());
			turns = position - 1;
		}
		
		turns++;
		
		return res;
	}
	
	public boolean hasNext() {
		return itList.size() > 0;
	}
	
	public static void main(String[] args) {		
		List<Integer> l1 = new LinkedList<Integer>(Arrays.asList(1,2,3));
		List<Integer> l2 = new LinkedList<Integer>(Arrays.asList(4,5,6,7));
		List<Integer> l3 = new LinkedList<Integer>(Arrays.asList(8,9));
	
		List<Iterator<Integer>> list = new LinkedList<Iterator<Integer>>();
		list.add(l1.iterator());
		list.add(l2.iterator());
		list.add(l3.iterator());
		
		ZigzagIterator solution = new ZigzagIterator(list);
		
		while (solution.hasNext()) {
			System.out.print(solution.next() + " ");
		}
	}
}
