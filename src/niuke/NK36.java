package niuke;

public class NK36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;
        int length1=0;
        int length2=0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (pHead1!=null){
            length1++;
            pHead1=pHead1.next;
        }
        while (pHead2!=null){
            length2++;
            pHead2=pHead2.next;
        }

        if (length1>=length2){
            int sub = length1-length2;
            while (sub!=0){
                node1=node1.next;
                sub--;
            }
        }else {
            int sub = length2-length1;
            while (sub!=0){
                node2=node2.next;
                sub--;
            }
        }

        while (node1!=null||node2!=null){
            if (node1==node2){
                return node1;
            }
            node1=node1.next;
            node2=node2.next;
        }
        return null;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
