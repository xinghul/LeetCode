import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		fullJustify(words, 16);
		for (int i = 0; i < result.size(); i ++)
			System.out.println(result.get(i));
	}
	static ArrayList<String> result = new ArrayList<String>();
	static int index = 0;
	public static ArrayList<String> fullJustify(String[] words, int L) {
		generateLine(words, L);
		return result;
	}
	
	private static void generateLine(String[] words, int L) {
		if (index >= words.length)
			return;
		
		String line = "";
		
		ArrayList<String> tokens = new ArrayList<String>();
		tokens.add(words[index]);
		int length = words[index ++].length();
		
		while (index < words.length && length + words[index].length() + tokens.size() <= L)
		{
			tokens.add(words[index]);
			length += words[index ++].length();
		}
		
		int space, extra;
		if (tokens.size() == 1 || index >= words.length) {
			line += tokens.get(0);
			for (int i = 1; i < tokens.size(); i ++)
			{
				line += " ";
				line += tokens.get(i);
			}
			extra = L - line.length();
			while ((extra --) > 0)
				line += " ";
		}
		else {
			space = (L - length) / (tokens.size() - 1);
			extra = L - length - space * (tokens.size() - 1);
			line = tokens.get(0);
			for (int i = 1; i < tokens.size(); i ++)
			{
				for (int j = 0; j < space; j ++)
					line += " ";
				if ((extra --) > 0)
					line += " ";
				line += tokens.get(i);
			}
		}
		result.add(line);
		generateLine(words, L);
	}

}
