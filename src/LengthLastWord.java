/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class LengthLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((" a").split(" ")[1]);
	}
	
	public int lengthOfLastWord(String s) {
		String[] words = s.split(" +"); 
		if (words.length == 0)
			return 0;
		return words[words.length - 1].length();
	}

}
