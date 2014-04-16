import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class DecodeWays {

	/**
	 * @param args
	 */
	static Map<String, Integer> numWays = new HashMap<String, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "01";
		System.out.println(numDecodings(s));
		for (Entry<String, Integer> entry : numWays.entrySet()) {
			System.out.println(entry.getKey() + "*" + entry.getValue());
		}
	}
	
	public static int numDecodings(String s) {
		if (s.isEmpty())
			return 0;
		return subDecoding(s);
	}
	
	private static int subDecoding(String s) {
		if (s.startsWith("0"))
			return 0;
		if (s.isEmpty())
			return 1;
		if (numWays.containsKey(s))
			return numWays.get(s);
		int num = 0;
		if (s.length() > 1) {
			String token = s.substring(0, 2);
			if (Integer.parseInt(token) <= 26)
				num += subDecoding(s.substring(2));
		}
		num += subDecoding(s.substring(1));
		numWays.put(s, num);
		return num;
	}
	
}
