package challenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {
	public static void main(String[] args){
		
		List<Integer> list = grayCode(3);
		System.out.println(Arrays.toString(list.toArray()));
	}
	public static List<Integer> grayCode(int n){
		List<Integer> ret = new LinkedList<>();
        ret.add(0);
        for (int i = 0; i < n; i++) {
            int size = ret.size();
            for (int j = size - 1; j >= 0; j--)
                ret.add(ret.get(j) + size);
        }
        return ret;
	}
}
