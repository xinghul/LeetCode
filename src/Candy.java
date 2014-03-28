import java.util.ArrayList;

public class Candy {
	public static void main(String[] args) {
		int[] ratings = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
		System.out.println(candy(ratings));
	}
	public static int candy(int[] ratings) {
		if (ratings.length == 0)
            return 0;
        else if (ratings.length == 1)
            return 1;
		int number = 0;
		ArrayList<Integer> tPoints = new ArrayList<Integer>();
		int[] candies = new int[ratings.length];
		
		tPoints.add(0);
		for (int i = 1; i < ratings.length - 1; i ++) {
			if (ratings[i] >= ratings[i - 1] && ratings[i] >= ratings[i + 1])
				tPoints.add(i);
			else if (ratings[i] < ratings[i - 1] && ratings[i] < ratings[i + 1])
				tPoints.add(i);
		}
		tPoints.add(ratings.length - 1);
		for (int i = 0; i < tPoints.size(); i ++)
			System.out.println(tPoints.get(i));
		int left, right, index = 0;
		while (index < tPoints.size() - 1) {
			left = tPoints.get(index);
			right = tPoints.get(index + 1);
			System.out.println(left + "*" + right);
			
			int n = 1;
			if (ratings[left] < ratings[right]) {
				candies[left] = 1;
				for (int j = 0; j < right - left; j ++) 
				{
					if (ratings[left + j] < ratings[left + j + 1])
						n ++;
					candies[left + j + 1] = max(candies[left + j + 1], n);
					System.out.println(candies[left + j + 1] + "~");
				}
			} else {
				candies[right] = 1;
				for (int j = 0; j < right - left; j ++) 
				{
					if (ratings[right - j] < ratings[right - j - 1])
						n ++;
					candies[right - j - 1] = max(candies[right - j - 1], n);
					System.out.println(candies[right - j - 1] + "!");
				}
			}
			index ++;
		}
		for (int i = 0; i < candies.length; i ++)
		{
			System.out.print(candies[i]);
			number += candies[i];
		}
			
		System.out.println();
		return number;
		
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static int myCandy(int[] ratings) {
		int number = 0;
		int[] candies = new int[ratings.length];
		boolean[] tPoints = new boolean[ratings.length];
		
		boolean leftHigher, rightHigher;
		for (int i = 0; i < ratings.length; i ++) {
			leftHigher = false;
			rightHigher = false;
			if (i == 0 || ratings[i - 1] > ratings[i])
				leftHigher = true;
			if (i == ratings.length - 1 || ratings[i + 1] > ratings[i]) 
				rightHigher = true;
			if (leftHigher && rightHigher) {
				candies[i] = 1;
				tPoints[i] = true;
			}
			if (!leftHigher && rightHigher && i - 1 >= 0 && candies[i - 1] > 0)
			{
				candies[i] = candies[i - 1] + 1;
				System.out.println(candies[i]);
			}
				
		}
		for (int i = 0; i < ratings.length; i ++)
			System.out.print(candies[i]);
		System.out.println();
		for (int i = 0; i < ratings.length; i ++) {
			if (candies[i] > 0)
				continue;
			candies[i] = GetDistance(tPoints, i);
		}
		for (int i = 0; i < ratings.length; i ++)
		{
			System.out.print(candies[i]);
			number += candies[i];
		}
		System.out.println();
			
		return number;
		
	}
	
	private static int GetDistance(boolean[] tPoints, int i) {
		int distance = 1;
		while (true) 
		{
			if (i - distance >= 0 && tPoints[i - distance])
				break;
			if (i + distance < tPoints.length && tPoints[i + distance])
				break;
			if (i - distance < 0 && i + distance >= tPoints.length)
				return 1;
			distance ++;
		}
		return distance;		
	}
}