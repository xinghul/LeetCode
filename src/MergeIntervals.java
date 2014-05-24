import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 5));
		intervals = merge(intervals);
	}
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		while (!intervals.isEmpty())
		{
			Interval tmp = intervals.get(0);
			intervals.remove(0);
			int start = tmp.start;
			int end = tmp.end;
			
			for (int i = 0; i < intervals.size(); i ++)
			{
				if (intervals.get(i).start <= end && intervals.get(i).start >= start ||
						intervals.get(i).end <= end && intervals.get(i).end >= start ||
						intervals.get(i).start <= start && intervals.get(i).end >= end) {
					end = Math.max(end, intervals.get(i).end);
					start = Math.min(start, intervals.get(i).start);
					intervals.remove(i);
					i = -1;
				}
			}
			System.out.println(start + " " + end);
			result.add(new Interval(start, end));
		}
		return result;
	}
	
	public static ArrayList<Interval> mergeSorted(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		for (int i = 0; i < intervals.size(); i ++)
			for (int j = i; j < intervals.size(); j ++)
			{
				if (intervals.get(i).start > intervals.get(j).start) {
					Interval tmp = intervals.get(i);
					intervals.set(i, intervals.get(j));
					intervals.set(j, tmp);
				}
			}
		int index = 0;
		while (index < intervals.size()) 
		{
			Interval tmp = intervals.get(index);
			int start = tmp.start;
			int end = tmp.end;
			if (index == intervals.size() - 1) {
				result.add(tmp);
				break;
			}
			else {
				while (++ index < intervals.size() && intervals.get(index).start <= end)
				{
					end = intervals.get(index).end;
				}
				Interval newInterval = new Interval(start, end);
				result.add(newInterval);		}
		}
		return result;
	
	}
	
	public static class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

}
