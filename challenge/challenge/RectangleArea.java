package challenge;

/**
 * @author Zhaolong Zhong May 29, 2016
 * 
 * Rectangle Area
 * 
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 * 
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		// comment below is for overlap area
		// if (A >= G || D <= E || B >= H || D <= F) {
        //     return 0;
        // }
        
        // if (A == 0 && B == 0 && C == 0 && D == 0) {
        //     return (G - E) * ( H - F);
        // }
        
        // if (E == 0 && F == 0 && G == 0 && H == 0) {
        //     return (C - A) * (D - B);
        // }
        
        // int width = 0, height = 0;
        
        // if (E < C) {
        //     width = C - E;
        // } else {
        //     width = G - A;
        // }
        
        // if (H > B) {
        //     height = H - B;
        // } else {
        //     height = D - F;
        // }
        
        // return width * height;
		
		if(C < E || G < A)
	        return (G - E) * (H - F) + (C - A) * (D - B);
	 
	    if(D < F || H < B)
	        return (G - E) * (H - F) + (C - A) * (D - B);
	   
	    int right = Math.min(C,G);
	    int left = Math.max(A,E);
	    int top = Math.min(H,D);
	    int bottom = Math.max(F,B);
	 
	    return (G - E) * (H - F) + (C - A) * (D - B) - (right - left) * (top - bottom);
	}
}
