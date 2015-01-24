package decodeWays;
import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
	
	public static void main(String[] args){
		decode("","1123");
		System.out.println(decode("","1123"));
	}
	
	public static Set<String> decode(String prefix, String code) {
		Set<String> set = new HashSet<String>();
		if (code.length() == 0) {
			set.add(prefix);
			return set;
		}

		if (code.charAt(0) == '0')
			return set;

		set.addAll(decode(prefix + (char) (code.charAt(0) - '1' + 'a'),
				code.substring(1)));
		if (code.length() >= 2 && code.charAt(0) == '1') {
			set.addAll(decode(
					prefix + (char) (10 + code.charAt(1) - '1' + 'a'),
					code.substring(2)));
		}
		if (code.length() >= 2 && code.charAt(0) == '2'
				&& code.charAt(1) <= '6') {
			set.addAll(decode(
					prefix + (char) (20 + code.charAt(1) - '1' + 'a'),
					code.substring(2)));
		}
		return set;
}

}
