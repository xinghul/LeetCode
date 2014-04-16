import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 */

/**
 * @author xinghul
 *
 */
public class WordLadderII {

	class WordWithLevel {  
        String word;  
        int level;  
  
        public WordWithLevel(String word, int level) {  
            this.word = word;  
            this.level = level;  
        }  
    }  
  
    private String end;  
    private ArrayList<ArrayList<String>> result;  
    private Map<String, List<String>> nextMap;  
  
    public ArrayList<ArrayList<String>> findLadders(String start, String end,  
            HashSet<String> dict) {  
        result = new ArrayList<ArrayList<String>>();  
        this.end = end;  
  
        // unvisited words set  
        Set<String> unVisited = new HashSet<String>();  
        unVisited.addAll(dict);  
        unVisited.add(start);  
        unVisited.remove(end);  
  
        // used to record the map info of <word : the words of next level>  
        nextMap = new HashMap<String, List<String>>();  
        for (String e : unVisited) {  
            nextMap.put(e, new ArrayList<String>());  
        }  
  
        // BFS to search from the end to start  
        Queue<WordWithLevel> queue = new LinkedList<WordWithLevel>();  
        queue.add(new WordWithLevel(end, 0));  
        boolean found = false;  
        int finalLevel = Integer.MAX_VALUE;  
        int currentLevel = 0;  
        int preLevel = 0;  
        Set<String> visitedWordsInThisLevel = new HashSet<String>();  
        while (!queue.isEmpty()) {  
            WordWithLevel wordWithLevel = queue.poll();  
            String word = wordWithLevel.word;  
            currentLevel = wordWithLevel.level;  
            if (found && currentLevel > finalLevel) {  
                break;  
            }  
            if (currentLevel > preLevel) {  
                unVisited.removeAll(visitedWordsInThisLevel);  
            }  
            preLevel = currentLevel;  
            char[] wordCharArray = word.toCharArray();  
            for (int i = 0; i < word.length(); ++i) {  
                char originalChar = wordCharArray[i];  
                boolean foundInThisCycle = false;  
                for (char c = 'a'; c <= 'z'; ++c) {  
                    wordCharArray[i] = c;  
                    String newWord = new String(wordCharArray);  
                    if (c != originalChar && unVisited.contains(newWord)) {  
                        nextMap.get(newWord).add(word);  
                        if (newWord.equals(start)) {  
                            found = true;  
                            finalLevel = currentLevel;  
                            foundInThisCycle = true;  
                            break;  
                        }  
                        if (visitedWordsInThisLevel.add(newWord)) {  
                            queue.add(new WordWithLevel(newWord,  
                                    currentLevel + 1));  
                        }  
                    }  
                }  
                if (foundInThisCycle) {  
                    break;  
                }  
                wordCharArray[i] = originalChar;  
            }  
        }  
  
        if (found) {  
            // dfs to get the paths  
            ArrayList<String> list = new ArrayList<String>();  
            list.add(start);  
            getPaths(start, list, finalLevel + 1);  
        }  
        return result;  
    }  
  
    private void getPaths(String currentWord, ArrayList<String> list, int level) {  
        if (currentWord.equals(end)) {  
            result.add(new ArrayList<String>(list));  
        } else if (level > 0) {  
            List<String> parentsSet = nextMap.get(currentWord);  
            for (String parent : parentsSet) {  
                list.add(parent);  
                getPaths(parent, list, level - 1);  
                list.remove(list.size() - 1);  
            }  
        }  
    }  

}
