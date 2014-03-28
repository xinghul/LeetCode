public class LRU {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		System.out.println(cache.get(2));
		cache.set(2, 6);
		cache.print();
		System.out.println(cache.get(1));
		cache.set(1, 5);
		cache.print();
		cache.set(1, 2);
		cache.print();
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	} 
	public static class LRUCache {
	    CacheNode head, tail;
		int capacity;
		int count;
		public LRUCache(int capacity) {
		    head = null;
		    tail = null;
		    this.capacity = capacity;
		    count = 0;
		}
		public int get(int key) {
		    CacheNode tmp = head;
		    CacheNode prev = tmp;
		    while (tmp != null) {
		        if (tmp.key == key)
		            break;
		        prev = tmp;
		        tmp = tmp.next;
		    }
		    if (tmp == null)
		        return -1;
		    else if (tmp == prev) {
		        head = head.next;
		    }
		    else {
		        prev.next = tmp.next;
		        if (tmp == tail)
		        	tail = prev;
		    }
		    count --;
		    addToTail(tmp.key, tmp.value);
		    return tmp.value;
	    }
	    public void set(int key, int value) {
	        if (get(key) == -1)
	            addToTail(key, value);
		    else {
		        tail.value = value;
		    }
	    }
	    public void addToTail(int key, int value) {
	        count ++;
	        CacheNode newNode = new CacheNode(key, value);
	        CacheNode tmp = head;
	        if (tmp == null) {
	            head = newNode;
	            tail = newNode;
	            return;
	        }
	        tail.next = newNode;
	        tail = tail.next;
	        if (count > capacity) {
	            head = head.next;
	            count --;
	        }
	    }
		public void print() {
			System.out.println("---print begin---");
			System.out.println("head:" + head.key + "*" + head.value);
			System.out.println("tail:" + tail.key + "*" + tail.value);
		    CacheNode tmp = head;
		    while (tmp != null) {
		    	System.out.println(tmp.key + "*" + tmp.value);
		        tmp = tmp.next;
		    }
		    System.out.println("---print end---");
	    }
	}
	static class CacheNode {
	    int key, value;
	    CacheNode next;
	    public CacheNode(int key, int value) {
	        this.key = key;
	        this.value = value;
	        next = null;
	    }
	}
}