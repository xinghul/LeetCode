import java.util.Stack;

/**
 * 
 */

/**
 * @author xinghu
 *
 */
public class LargestRectangleHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
	
	public static int largestRectangleArea(int[] height) {
		int max = 0, w = 0, h;
		if (height.length == 0)
			return 0;
		Stack<Integer> heightStack = new Stack<Integer>();
		Stack<Integer> indexStack = new Stack<Integer>();
		
		for (int i = 0; i < height.length; i ++)
		{
			if (heightStack.isEmpty() || height[i] > heightStack.peek()) {
				heightStack.push(height[i]);
				indexStack.push(i);
			}
			else if (height[i] < heightStack.peek()) {
				
				while (!heightStack.isEmpty() && height[i] < heightStack.peek()) 
				{
					w = i - indexStack.pop();
					h = heightStack.pop();
					max = Math.max(max, w * h);
				}
				heightStack.push(height[i]);
				indexStack.push(i - w);
			}
		}
		
		while (!heightStack.isEmpty())
		{
			h = heightStack.pop();
			w = height.length - indexStack.pop();
			max = Math.max(max, w * h);
		}
		return max;
	}
}
