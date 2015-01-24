package zigzag;

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
