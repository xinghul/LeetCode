import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	static int minLength = 1;
	static ArrayList<String> result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("010010"));
	}
	public static ArrayList<String> restoreIpAddresses(String s) {
		result = new ArrayList<String>();
		if (s.length() == 12)
			minLength = 3;
		else if (s.length() == 11)
			minLength = 2;
		explore(s, new ArrayList<String>());
		return result;
	}
	
	private static void explore(String remain, ArrayList<String> subStr) {
		if (subStr.size() == 4) {
			if (remain.isEmpty())
				connect(subStr);
			return;
		}
		int maxLength = remain.length() > 3 ? 3 : remain.length();
		for (int i = minLength; i <= maxLength; i ++)
		{
			String sub = remain.substring(0, i);
			if (Integer.parseInt(sub) <= 255) {
				if (sub.startsWith("0") && sub.length() > 1)
					continue;
				remain = remain.substring(i);
				subStr.add(sub);
				explore(remain, subStr);
				subStr.remove(subStr.size() - 1);
				remain = sub + remain;
			}
		}
	}
	
	private static void connect(ArrayList<String> subStr) {
		String s = "";
		for (int i = 0; i < subStr.size(); i ++)
		{
			s += subStr.get(i);
			if (i != subStr.size() - 1)
				s += ".";
		}
		result.add(s);
	}

}
