/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp1 = head;
        Map<Node,Node> map = new HashMap<>();
        while(temp1!=null){
            Node newNode = new Node(temp1.val);
            map.put(temp1,newNode);
            temp1 = temp1.next;
        }

        Node temp2 = head;

        while(temp2!=null){
            Node copyNode = map.get(temp2);
            copyNode.next = map.get(temp2.next);
            copyNode.random = map.get(temp2.random);
            temp2 = temp2.next;
        }
        return map.get(head);
    }
}