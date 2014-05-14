import java.util.HashMap;

/**
 * 
 */

/**
 * @author Xinghu
 *
 */
public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
	
	public static String minWindow(String S, String T) {
		if (S == null || T == null) {
            return null;
        }
        
        if (S.length() == 0 && T.length() == 0){
            return "";
        }
        
        if (S.length() < T.length()){
            return "";
        }
        
        HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
        HashMap<Character, Integer> alreadyFind = new HashMap<Character, Integer>();
        
        for(int i = 0; i < T.length(); i ++)
        {
            alreadyFind.put(T.charAt(i), 0);
            
            if (needFind.containsKey(T.charAt(i))) {
                needFind.put(T.charAt(i), needFind.get(T.charAt(i)) + 1);
            }
            else{
                needFind.put(T.charAt(i), 1);
            }
        }
        int minStart = -1;
        int minEnd = S.length();
        int start = 0;
        int count = 0;
        for (int i = 0; i < S.length(); i ++)
        {
            if (alreadyFind.containsKey(S.charAt(i))){
                alreadyFind.put(S.charAt(i), alreadyFind.get(S.charAt(i)) + 1);
                
                if (alreadyFind.get(S.charAt(i)) <= needFind.get(S.charAt(i))){
                	count++;
                }
                
                if (count == T.length()) {
                    while (!needFind.containsKey(S.charAt(start)) || alreadyFind.get(S.charAt(start))>needFind.get(S.charAt(start))){
                        if (needFind.containsKey(S.charAt(start))){
                            alreadyFind.put(S.charAt(start), alreadyFind.get(S.charAt(start)) - 1);
                        }
                        start ++;
                    }
                    if (i - start < minEnd - minStart){
                        minStart = start;
                        minEnd = i;
                    }
                }
            }
        }
        if (minStart == -1){
            return "";
        }
        return S.substring(minStart, minEnd + 1);
	}

}
