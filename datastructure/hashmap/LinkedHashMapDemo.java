/**
 * Author: Zhaolong Zhong
 * Date  : 2015 4:47:06 PM
 * 
 * LinkedHashMap:
 * This class extends HashMap and maintains a linked list of the entries in the map, 
 * in the order in which they were inserted
 */
package hashmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class LinkedHashMapDemo {
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static void main(String args[]) {
    LinkedHashMap map = new LinkedHashMap();
    
    map.put("google", "Nexus 6");
    map.put("apple", "iPhone 6");
    map.put("microsoft", "Lumia 640");
    
    Set set = map.entrySet();
    Iterator i = set.iterator();
    
    while(i.hasNext()) {
      Map.Entry me = (Map.Entry)i.next();
      System.out.print(me.getKey() + ": ");
      System.out.println(me.getValue());
    }
    
  }
}
