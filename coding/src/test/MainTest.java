package test;
import java.util.Hashtable;

public class MainTest {
	public static void main(String[] args){
		System.out.println("Test");
		Hashtable  table = new Hashtable();
		table.put("a", 1);
		table.put("b", 2);
		table.put("c", 3);
		System.out.println(table.size());
		System.out.println(table.toString());
		
	}
}
