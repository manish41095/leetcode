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

        Node temp = head;
        //Step1 create new copy node 
        while(temp!=null){
            Node copyNode = new Node(temp.val);
            copyNode.next =temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        //step2 connecting random pntr
        Node temp1 = head;
        while(temp1!=null){
            Node copyNode = temp1.next;
            if(temp1.random!=null)
             copyNode.random = temp1.random.next;
             else
                copyNode.random = null;
            temp1 = temp1.next.next;
        }

        //Step3 connecting next ptr
        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp2 = head;
        while(temp2!=null){
            res.next = temp2.next;
            temp2.next = temp2.next.next;
            res = res.next;
            temp2 = temp2.next;
        }

        return dummy.next;
    }
}