package hash;

public class MyHashtable<K, V> {
  
  private static int SIZE = 256;
  private int size;
  /* initialize an array to store the values */
  @SuppressWarnings("unchecked")
  private V[] tableValues = (V[]) new Object[SIZE];
  @SuppressWarnings("unchecked")
  private K[] tableKeys = (K[]) new Object[SIZE];
  
  public int size() {

    return this.size;
}

  public synchronized V put(K key, V value){
    if (value == null) {
      throw new NullPointerException();
    }
    
    int index = hash(key.hashCode()) % SIZE;
    tableValues[index] = value;
    tableKeys[index] = key;
    size ++;
    return value;
  }
  
  public synchronized V get (K key) {
    int index = hash(key.hashCode()) % SIZE;
    return tableValues[index];
  }
  
  public synchronized int hash (int h){
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>>4);
  }
  
  public static void main(String[] args) {
    MyHashtable<String, String> table = new MyHashtable<String, String>();
    for (int i = 0; i < 3; i++) {
      table.put("key" + i, "value" + i);
    }
    
    for (int i = 0; i < 3; i++) {
      System.out.println(table.get("key" + i));
    }
    
    System.out.println(table.size());
  }
}
