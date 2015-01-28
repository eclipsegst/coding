package missingRanges;
import java.util.List;
import java.util.ArrayList;
/*
 * Date: 2015-01-28 11:03
 * Problem:
 * Given an sorted integer array, find the missing ranges between those integers.
 * Input : A = {0, 1, 3, 50, 75};
 * Output: [2, 4->49, 51->74, 76->99]
 */
public class MissingRanges {
  
  static class Range {
    int start;
    int end;
    
    Range(int start, int end) {
      this.start = start;
      this.end   = end;     
    }
    
    public String toString(){
      if (start == end) return "" + start;
      return start + "->" + end;
    }
    
    boolean valid(){
      return end >= start;
    }
    
    void addIfValid(List<String> list){
      if (valid()){
        list.add(toString());
      }
    }
  }
  
  public static List<String> findMissingRanges(int[] A, int lower, int upper) {
    List<String> list = new ArrayList<String>();
    Range current = new Range(lower, upper);
    for(int i = 0; i < A.length; i++){
      if (A[i] > current.end) break;
      if (A[i] >= current.start) {
        Range temp = new Range(current.start, A[i] - 1);
        temp.addIfValid(list);
        current.start = A[i] + 1;
      }
    }
    current.addIfValid(list);
    return list;
  }
  
  public static void main(String[] args){
    int[] A = {0, 1, 3, 50, 75};
    List<String> list = findMissingRanges(A, 0, 99);
    System.out.println(list.toString()); //[2, 4->49, 51->74, 76->99]
  }
}