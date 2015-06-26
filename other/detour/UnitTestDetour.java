package detour;

import static org.junit.Assert.*;

import org.junit.Test;

import detour.Detour.Point;

public class UnitTestDetour {

	Detour detour = new Detour();
	
	@Test
	public void testDiscanceOfTwoPoints() {
		
		// Distance between A and B is 1795.7865970367857
		Point A = new Point(36.12, -86.64);
		Point B = new Point(33.94, -118.40);
		
		double result = detour.distance(A, B);
		
		assertEquals(1796, Math.round(result));
	}

	@Test
	public void testMinDetour() {
		
		// Minimum detour is ACDB, the distance is 2249.0230013256787
		detour.A = new Point(25, 75);
		detour.B = new Point(35, 60);
		detour.C = new Point(25, 100);
		detour.D = new Point(35, 100);
		
		detour.preparePoints();
		
		double result = detour.minDetour();
		assertEquals(2249, Math.round(result));
	}
}
