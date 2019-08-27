public class LRUCache {
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node target = map.get(key);
        removeNodeFromList(target);
        insertNode(target);
        return target.value;
    }
    
    private void removeNodeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insertNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            removeNodeFromList(map.get(key));
            insertNode(map.get(key));
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertNode(newNode);
        
            if (map.size() > capacity) {
                Node toDelete = tail.prev;
                map.remove(toDelete.key);
                toDelete.prev.next = tail;
                tail.prev = toDelete.prev;
            }    
        }
    }
}