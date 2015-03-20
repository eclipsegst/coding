/**
 * Author: Zhaolong Zhong
 * Date  : Feb 5, 2015 2:17:15 PM
 * Common Data Structure
 */
package common;
import java.util.*;
public class CommonDataStructure {
  public static void main(String[] args) {
    
    /*
     * Two Dimensional Array
     */
    String[][] array = new String[10][10];
    for(String[] row : array) Arrays.fill(row, "#");
    
    /*
     * Stack
     */
    Stack<Character> stack = new Stack<Character>();
    stack.isEmpty();
    stack.push('a');
    stack.peek();    // return a
    stack.pop();     // remove top
                     // do peek or pop if empty, throw java.util.EmptyStackException
    /*
     * Queue
     */
    //Creating a queue would require you to create instance of LinkedList and assign it to Queue
    //Object. You cannot create an instance of Queue as it is abstract
    Queue<String> queue = new LinkedList<String>();
    queue.add("Java");
    queue.add("C++");
    queue.add("C#");
    System.out.println(queue);//[Java, C++, C#]
    queue.peek();// get the queue if empty return null, queue.element() will throw NoSuchElementException
    queue.poll(); // get and remove queue head, if queue is empty return null
    queue.remove() ; // get and remove queue head, if queue is empty, it will throw NoSuchElementException
   
    /*
     * Hashtable
     */
    Hashtable<Integer, String> table = new Hashtable<Integer, String>();
    table.put(0, "Google");
    table.put(1, "Facebook");
    table.put(2, "Microsoft");
    table.get(0);  // return "Google"
    table.keySet();// key set, which has contains(), isEmpty(),add(),addAll(), toArray(), toString();
    table.values();// value set
    System.out.println(Arrays.toString(table.keySet().toArray()));
   
    /*
     * Hashtable VS HashMap
     * Similarities: Both them implements Map and store value as key-value pairs.
     * Difference:
     * - HashMap is not synchronized in nature but Hashtable is.
     * - HashMap permits null value and only one null key, while Hashtable doesn't allow key or value as null
     * - Iterator in the HashMap is fail-safe while the iterator for the Hashtable isn't fail-safe 
     *   if the Hashtable is structurally modified at any time after the iterator is created,
     *   in any way except through the iterator's own remove method, it will throw a ConcurrentModifiecationException.
     *   
     */
    /*
     * HashMap
     */
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    map.put('a', 'A');
    map.get('a');               // return 'A'
    map.values().contains('A'); // true
    map.keySet().contains('a'); // true
    
    /*
     * HashSet
     */
    Set<Character> set = new HashSet<Character>();
    Set<Character> setTwo = new HashSet<Character>();
    set.add('a');
    set.add('b');
    set.add('a');// It will not be added to set since HashSet only keep unique element.
    setTwo.add('c');
    set.addAll(setTwo);
    for(char a : set) System.out.println(a);
    Iterator<Character> it = set.iterator();
    while(it.hasNext()){
      System.out.println(it.next().toString());
      it.remove();
    }
    for(char a : set) System.out.println(a);
    
    set.remove('a');
    System.out.println(set.contains('a'));
    
    set.isEmpty();// false
    set.size();   // size
    set.remove('a');
    set.clear();
    
    /*
     * Set VS List
     * - List can contain duplicate values but Set maintains only unique values.
     * - List allows retrieval of data to be the same order in the way it is inserted.
     *   But Set doesn't ensure the sequence in which data can be retrieved except LinkedHashSet.
     * 
     * HashSet VS TreeSet VS LinkedHashSet:
     * - If you need a fast set, you should use HashSet which is implemented using a hash table.
     *   Elements are not sorted. The add, remove and contains methods have constant time complexity O(1).
     *   
     * - If you need a sorted a set, then TreeSet should be used, which is implemented using a red-black tree.
     *   Elements are sorted but the add, remove and contains has time complexity of O(log n).
     *   
     * - If you want to ensure the insertion order, LinkedHashSet should be used.
     *   Elements are kept in the order of insertion. The time complexity of basic methods is O(1).
     */
    
    /*
     * ArrayList
     */
    List<String> arrayList = new ArrayList<String>();
    arrayList.add("Google");// add an element, addAll() -> add another ArrayList
    arrayList.add("Facebook");
    arrayList.add("Microsoft");
    arrayList.get(2); // return "Microsoft", get the element in the specific position
    arrayList.indexOf("Facebook"); //return the index of an element, return -1 if not exist
    arrayList.clear(); // clear all elements
    //other function:
    //remove(), isEmpty(), clear(), contains(), size(), toArray(new String[arrayList.size())
    
    /*
     * ArrayList VS LinkedList
     * - ArrayList can give a better performance (O(1) VS O(n) in LinkedList) in search/lookup operations.
     * - LinkedList can give a better performance (O(1) VS O(n) in ArrayList) in insert/remove operations.
     * Because LinkedList's each element maintains two pointer(addresses) which points to the both neighbor
     * elements in the list. hence remove only requires change in the pointer location in the two neighbor
     * nodes(elements) of the node which is going to be removed. While in ArrayList all elements need to be shifted
     * to fill out the space created by removed/insert element.
     * - Memory Overhead: ArrayList maintains indexes and element data while LinkedList maintains element data and 
     * two pointers for neighbor node hence the memory consumption is high in LinkedList comparatively.
     * 
     */
    
    /*
     * LinkedList
     */
    LinkedList<String> linkedList = new LinkedList<String>();
    linkedList.add("Google");
    linkedList.addLast("Microsoft");
    linkedList.addFirst("Facebook");
    Iterator<String> listIt = linkedList.iterator();
    while(listIt.hasNext()){
      System.out.println(listIt.next());
    }
    ListIterator<String> listIterator = linkedList.listIterator(linkedList.size());
    while(listIterator.hasPrevious()){
      System.out.println(listIterator.previous());
    }
    
    /*
     * Set.iterator() or List.iterator() VS List.listIterator()
     * listIterator can
     * - iterate backwards
     * - obtain the index at any point
     * - add a new value at any point
     * - set a new value at any point
     * --hasNext(), next(), remove(), extra: nextIndex(), hasPrevious(), previous(), previousIndex() 
     */
  }
}
