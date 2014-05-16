import java.util.Stack;


/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/home//foo/"));
	}
	
	public static String simplifyPath(String path) {
		String[] folders = path.split("/+");
		Stack<String> stack = new Stack<String>();
		for (String f : folders) 
		{
			if (f.equals("..")) {
				if (stack.isEmpty())
					continue;
				stack.pop();
			}
			else if (f.equals(".") || f.isEmpty()) {
				continue;
			}
			else {
				stack.push(f);
			}
		}
		if (stack.isEmpty())
			return "/";
		String result = stack.pop();
		
		while (!stack.isEmpty())
			result = stack.pop() + "/" + result;
		return "/" + result;
	}

}
