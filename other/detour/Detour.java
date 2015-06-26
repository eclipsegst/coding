package detour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Calculate the detour distance between two different rides.
 *  
 * Given four latitude / longitude pairs, where driver one is traveling from point A to point B 
 * and driver two is traveling from point C to point D, write a function (in your language of 
 * choice) to calculate the shorter of the detour distances the drivers would need to take to 
 * pick-up and drop-off the other driver.
 * 
 * Notes: Assume the driver can drive straight between two points no matter there is mountain or water.
 */

public class Detour {

	static class Point{
		
		private double lat, lon;
		
		public Point(double lat, double lon) {
			this.lat = lat;
			this.lon = lon;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}

		public double getLon() {
			return lon;
		}

		public void setLon(double lon) {
			this.lon = lon;
		}
	}
	
	public double distance(Point origin, Point destination) {
		
		final double earthRadius = 3960;	// Earth radius is about 3960 miles. - wiki
		
		double dLat = Math.toRadians(destination.lat - origin.lat);
		double dLon = Math.toRadians(destination.lon - origin.lon);
		
		double lat1 = Math.toRadians(origin.lat);
		double lat2 = Math.toRadians(destination.lat);
		
		double a = Math.pow(Math.sin(dLat/2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon/2), 2);
		double distance = 2 * earthRadius * Math.asin(Math.sqrt(a));
		
		return distance;
	}
	
	public Point A, B, C, D;
	
	// Map the four points
	private HashMap<String, Point> points = new HashMap<String, Point>();
	
	// List of possible detours
	private List<String> possibleDetours = new ArrayList<String>();
	
	public double minDetour() {
		List<Double> detourDistances = new ArrayList<Double>();
		double detourDistance = 0;
		for (String detour : possibleDetours){
			
			for (int i = 0; i < detour.length() - 1; i++) {
				String origin = "" + detour.charAt(i);
				String destination = "" + detour.charAt(i+1);
				detourDistance = distance(points.get(origin), points.get(destination));
			}
			
			detourDistances.add(detourDistance);
		}
		
		// min distance of detour
		double minDistance = detourDistances.stream().mapToDouble(p -> p).min().getAsDouble();
		int index = detourDistances.indexOf(minDistance);
		System.out.println("The detour with minmum distance " + Math.round(minDistance) + " miles is " + possibleDetours.get(index));
		
		return minDistance;
	}
	
	public void preparePoints() {
		
		// There are two possible detour since driver 1 drives from A to B, driver 2 drives from C to D.
		possibleDetours.add("ACDB");
		possibleDetours.add("CABD");
		
		points.put("A", A);
		points.put("B", B);
		points.put("C", C);
		points.put("D", D);
		
	}
}
