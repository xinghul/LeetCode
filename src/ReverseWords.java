public class ReverseWords{
	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue  "));
	}
	public static String reverseWords(String s) {
		String output = "";
		int sIndex = 0;
		while (sIndex < s.length() && s.charAt(sIndex) == ' ')
			sIndex ++;
		s = s.substring(sIndex);
		String[] words = s.split(" +");
		for (int i = words.length - 1; i >=0 ; i--) {
			output += words[i];
			if (i != 0)
				output += " ";
		}
		
		return output;
	}
}