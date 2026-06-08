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
        // Node temp1 = head;
        // Map<Node,Node> map = new HashMap<>();
        // while(temp1!=null){
        //     Node newNode = new Node(temp1.val);
        //     map.put(temp1,newNode);
        //     temp1 = temp1.next;
        // }

        // Node temp2 = head;

        // while(temp2!=null){
        //     Node copyNode = map.get(temp2);
        //     copyNode.next = map.get(temp2.next);
        //     copyNode.random = map.get(temp2.random);
        //     temp2 = temp2.next;
        // }
        // return map.get(head); // Sol1

       if(head == null)
        return null;
        Node curr = head;
        //create new list
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        //Copy Random ptr;
        while(curr!=null){
            if(curr.random!=null)
                curr.next.random = curr.random.next;

            curr = curr.next.next;
        }

        curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        //Separate two list
        while(curr!=null){
            curr.next = newCurr.next;
            curr = curr.next;

            if(curr!=null)
            newCurr.next = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}