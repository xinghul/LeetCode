public class MaxPoints {
	public static void main(String[] args) {
		Point[] points = {new Point(84, 250), new Point(0, 0), new Point(1, 0), new Point(0, -70), new Point(0, -70), new Point(1, -1), new Point(21, 10), new Point(42, 90), new Point(-42, -230)};

		System.out.println(maxPoints(points));
	}
	public static int maxPoints(Point[] points) {
		if (points.length == 0)
			return 0;
		
		int pNumber = 1;
		
		for (int i = 0; i < points.length; i ++) {
			SortedList slopes = new SortedList();
			for (int j = 0; j < points.length; j ++) {
				if (j == i)
					continue;
				slopes.Add(GetSlope(points[i], points[j]));
			}
			int count = slopes.GetCount() + 1;
			if (count > pNumber)
				pNumber = count;
			System.out.println(pNumber + "*");
		}
		
		return pNumber;
	}

	public static float GetSlope(Point a, Point b) {
		if (a.x == b.x) {
			if (a.y == b.y)
				return Float.MIN_VALUE;
			else
				return Float.MAX_VALUE;
		}
		else
			return (float)(b.y - a.y)/(b.x - a.x);
	}
	static class SortedList {
		int dublicate;
		SortedListNode head;
		public SortedList() {
			head = null;
			dublicate = 0;
		}
		public void Add(float value) {
			if (value == Float.MIN_VALUE) {
				dublicate ++;
				return;
			}
			SortedListNode newNode = new SortedListNode(value);
			if (head == null || newNode.value <= head.value) {
				System.out.println("insert head : " + value);
				newNode.next = head;
				head = newNode;
			}
			else {
				SortedListNode tmp = head, prev = head;
				while (tmp != null && tmp.value < newNode.value) {
					prev = tmp;
					tmp = tmp.next;
				}
				System.out.println("insert mid : " + prev.value + " -> " + value);
				prev.next = newNode;
				newNode.next = tmp;
			}
		}
		public int GetCount() {
			int count = 0, same = 0;
			SortedListNode tmp = head;
			while (tmp != null) {
				same ++;
				if (tmp.next == null || tmp.value != tmp.next.value) {
					if (same > count)
						count = same;
					same = 0;
				}
				tmp = tmp.next;
 			}
			return count + dublicate;
		}
	}
	static class SortedListNode {
		float value;
		SortedListNode next;
		public SortedListNode(float value) {
			this.value = value;
			next = null;
		}
	}
	static class Point {
		int x;
		int y;
		public Point() {
			x = 0;
			y = 0;
		}
		public Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}