package zigzag;

/*
 * Date: 2015-01-07 01:32:03
 * 
 * Problem:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR".
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * 
 */

public class Zigzag {
	public static void main(String[] args){
		char m [][] = new char[][]{
				{'a', 'b', 'c'},
				{'d', 'e', 'f'},
				{'g', 'h', 'i'},
				{'j', 'k', 'l'}
		};
		
		int height = m.length;
		int width =m[0].length;
		System.out.println(height);
		System.out.println(width);
		
		int i =0, j = 0;

		while(!((i==height-1) && (j==width-1)) && (i<height -1 && j<width-1)){	
			
			System.out.println(m[i][j]);
			if(i<height-1){
				i++;//go down in left edge
			}else if(j<width-1){
				j++;//go right in bottom edge
			}else{
				break;
			}
			//go right top
			while(i>0 && j<width-1){
				System.out.println(m[i][j]);
				i--;
				j++;
			}
			
			System.out.println(m[i][j]);//top edge
			
			if(i==0 && j<width-1){
				j++;//go right on top edge
			}else
			{
				i++;//go down on right edge
			}
			// go down left
			while(j>0 && i<height-1){
				System.out.println(m[i][j]);
				j--;
				i++;
			}
		}
	}
}
