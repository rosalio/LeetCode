/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node dummyA = new Node(0, head, null);
        Node dummyB = new Node(0, null, null);
        
        Node A = head;
        Node B = dummyB;
        Map<Node, Node> map = new HashMap<>();
        
        while (A != null) {
            Node newNode = new Node(A.val, null, null);
            B.next = newNode;
            B = B.next;
            map.put(A, B);
            A = A.next;
        }
        
        A = dummyA.next;
        B = dummyB.next;
        
        while (A != null) {
            Node randomB = map.get(A.random);
            B.random = randomB;
            A = A.next;
            B = B.next;
        }
        
        return dummyB.next;
    }
}