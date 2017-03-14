import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

	class Node {
        int freq;
        String str;
        public Node(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        String[] rst = new String[k];
        if (words == null || words.length == 0 || k <= 0) {
            return rst;
        }
        //map
        HashMap<String, Node> map = new HashMap<String, Node>();
        for (int i = 0 ; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new Node(words[i], 0));
            }
            map.get(words[i]).freq = map.get(words[i]).freq + 1; 
        }
        //queue
        PriorityQueue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>(){
            public int compare(Node a, Node b) {
                if (a.freq == b.freq) {
                    return a.str.compareTo(b.str);
                } else {
                    return b.freq - a.freq;
                }
            } 
        });
        for (Map.Entry<String, Node> entry : map.entrySet()) {
            queue.offer(entry.getValue());
        }
        //output
        for (int i = 0; i < k; i++) {
            rst[i] = queue.poll().str;
        }
        
        return rst;
    }
    
    
    
    public static void main(String args[]){
    	
    	String[] input = {"yes", "lint", "code",
    		    "yes", "code", "baby",
    		    "you", "baby", "chrome",
    		    "safari", "lint", "code",
    		    "body", "lint", "code"};
    	
    	Solution s = new Solution();
    	String[] result = s.topKFrequentWords(input, 3);
    	for(String str: result){
    		System.out.println(str);
    	}
    	
    }
	
}
