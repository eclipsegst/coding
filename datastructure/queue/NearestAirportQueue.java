package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zhaolong Zhong Mar 25, 2016
 * 
 * Find the nearest k airports
 */

class Airport {
	int id;
	double x;
	double y;
	Airport(int id, double x, double y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}
}

public class NearestAirportQueue {
	
	public Airport[] findKNearestAirport(Airport[] airports, int k, Airport origin) {
		if (airports == null || airports.length == 0 || k <= 0) {
			return null;
		}
		
		PriorityQueue<Airport> queue = new PriorityQueue<Airport>(k, new Comparator<Airport>() {
			@Override
			public int compare(Airport a, Airport b) {
				double da = getRawDistance(a, origin);
				double db = getRawDistance(b, origin);
				
				if (da < db) {
					return 1;
				} else if (da > db) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		for (Airport airport : airports) {
			queue.offer(airport);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		
		Airport[] res = new Airport[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll();
		}
		
		return res;
	}
	
	// Assume it's 2D, we just need a raw distance
	private double getRawDistance(Airport a, Airport b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
//		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
	
	public static void main(String[] args) {
		NearestAirportQueue solution = new NearestAirportQueue();
		
		int n = 50;//total number of airports
		int k = 20;//total number of closest airports
		Airport origin = new Airport(-1, 0, 0);
		
		Airport[] airports = new Airport[n];
		for (int i = 0; i < n; i++) {
			airports[i] = new Airport(i, i, i);
		}
		
		Airport[] res = solution.findKNearestAirport(airports, k, origin);
		solution.printAirports(airports);
		System.out.println("result:");
		solution.printAirports(res);
	}
	
	public void printAirports(Airport[] airports) {
		for (Airport airport : airports) {
			System.out.println("id = " + airport.id + " : " + "x = " + airport.x + ", y = " + airport.y);
		}
	}
}
