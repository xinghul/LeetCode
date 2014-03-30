import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	HashMap<String, Boolean> palindromes = new HashMap<String, Boolean>();
	HashMap<String, ArrayList<ArrayList<String>>> dict;
	public ArrayList<ArrayList<String>> partition(String s) {
		dict = new HashMap<String,ArrayList<ArrayList<String>>>();
	    return partitionSub(s);
	}
	public ArrayList<ArrayList<String>> partitionSub(String s) {
		if(dict.containsKey(s)) 
			return dict.get(s);   

	    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	    if(s.length() == 0)
	    	res.add(new ArrayList<String>()); 
	    else
	    	for(int i=1; i <= s.length(); i ++)
	    	{ 
	    		String start = s.substring(0, i);
	    		if(isPalindrome(start)) {    
	    			ArrayList<ArrayList<String>> part = partitionSub(s.substring(i)); 
	    			for(ArrayList<String> sample : part)
	    			{
	    				ArrayList<String> added = new ArrayList<String>(sample);
	    				added.add(0, start);  
	    				res.add(added);
	    			}
	    		}
	    	}
	    dict.put(s, res);  
	    return res;
	}
	 
	public boolean isPalindrome(String s) {            
		if (palindromes.containsKey(s))
			return (palindromes.get(s)).booleanValue();
	    int m = 0;
	    int n = s.length() - 1;
	    while (m < n)
	    {
	    	if(s.charAt(m ++) != s.charAt(n --)) {
	    		palindromes.put(s, new Boolean(false));
	    		return false;
	    	}
	    }
	    palindromes.put(s, new Boolean(true));
	    return true;
	}
}
