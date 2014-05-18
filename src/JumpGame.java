/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 3, 1 ,1, 4};
		System.out.println(canJump(A));
	}
	
	public static boolean canJumpRecursive(int[] A) {
		return jump(A, 0);
	}
	private static boolean jump(int[] A, int index) {
		if (index == A.length - 1)
			return true;
		else if (index >= A.length)
			return false;
		int maxStep = A[index];
		for (int i = 1; i <= maxStep; i ++)
			if (jump(A, index + i))
				return true;
		return false;
	}
	
	public static boolean canJump(int[] A) {
		boolean[] visited = new boolean[A.length];
		boolean[] possible = new boolean[A.length];
		
		possible[A.length - 1] = true;
		boolean existNew = true;
		
		while (existNew) 
		{
			existNew = false;
			for (int i = A.length - 1; i >= 0; i --)
			{
				if (possible[i] && !visited[i]) {
					visited[i] = true;
					existNew = true;
					for (int j = i - 1; j >= 0; j --)
					{
						if (A[j] >= i - j)
							possible[j] = true;
					}
				}
			}
		}
		return possible[0];
	}

}
