package compressString;

public class CompressString {
	public static void main(String[] args){
		String s = "abbcccddddeeeee";
		String output = "";
		output = output + s.charAt(0);
		int tmp = 0;
		for(int i=0; i<s.length();i++){
			if(output.charAt(output.length()-1)==s.charAt(i))
			{
				tmp = tmp + 1;
			}else{
				output = output + tmp + s.charAt(i);
				tmp = 1;
			}
		}
		
		output = output + tmp;
		System.out.println(output);
	}
}
