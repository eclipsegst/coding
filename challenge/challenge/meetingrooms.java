package challenge;
import java.util.Arrays;

public class meetingrooms {
	
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, (a, b) -> a.start - b.start);;
		
		int maxend = 0;
		for (Interval i : intervals) {
			if (i.start < maxend) {
				return false;
			}
			
			maxend = Math.max(maxend, i.end);
		}
		return true;
	}
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

}
