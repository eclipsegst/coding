package challenge;

public class BreakNumber {
	public static void main(String[] args){
		String s = "3 , 6 , 48 , 60 ,72 ";
		
		String [] sArray = s.replaceAll("\\s","").split(",");
		
		System.out.println(sArray.length);
		String r="";
		for(int i=0; i<sArray.length-1; i++){
			int curr = Integer.parseInt(sArray[i]);
			int next = Integer.parseInt(sArray[i+1]);
			
			if(i==0){
				if (curr >1){
					r += "0-"+(curr-1) + "," + (curr+1) + "-" + (next-1);
				}
			}else{
				r += ","+(curr+1)+"-"+(next-1);
			}
			
			if(i==sArray.length-2){
				if(next<100){
					r += ","+(next+1)+"-99";
				}
			}			
		}
		System.out.println(r);
	}

}
