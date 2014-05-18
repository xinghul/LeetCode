import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 5));


		intervals = insert(intervals, new Interval(0, 0));
		for (int i = 0; i < intervals.size(); i ++)
			System.out.print("[" + intervals.get(i).start + "," + intervals.get(i).end + "] ");
	}
	
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		boolean findS = false, findE = false;
		int s = 0, e = 0;
		int index = 0;
		while (!findS || !findE)
		{
			if (index >= intervals.size()) {
				System.out.println(s + "!" + e);
				if (!findS)
					s = newInterval.start;
				if (!findE)
					e = newInterval.end;
				break;
			}
			Interval interval = intervals.get(index);
			System.out.println(interval.start + "*" + interval.end);
			if (!findS) {
				System.out.print("start :");
				if (interval.end < newInterval.start) {
					System.out.println("skip");
					result.add(interval);
				}
				else {
					System.out.print("overlap ");
					findS = true;
					if (interval.start <= newInterval.start)
						s = interval.start;
					else
						s = newInterval.start;
					
					if (interval.end >= newInterval.end) {
						System.out.print(" over ");
						findE = true;
						e = interval.end;
					}
					if (interval.start > newInterval.end) {
						findE = true;
						e = newInterval.end;
						break;
					}
					System.out.println(s);
				}
			}
			else if (!findE) {
				System.out.println("end");
				if (interval.start > newInterval.end) {
					findE = true;
					e = newInterval.end;
					break;
				}
				else if (interval.end >= newInterval.end) {
					findE = true;
					e = interval.end;
				}
			}
			index ++;
			System.out.println(findS + "~" + findE);
		}
		
		result.add(new Interval(s, e));
		
		while (index < intervals.size())
			result.add(intervals.get(index ++));
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
