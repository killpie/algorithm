package niuke;

public class NK58 {

    public ListNode deleteDuplication(ListNode pHead) {

            ListNode first = new ListNode(-1);//设置一个trick

            first.next = pHead;

            ListNode p = pHead;
            ListNode pre = first;
            while (p != null && p.next != null) {
                if (p.val == p.next.val) {
                    int val = p.val;
                    while (p!= null&&p.val == val)
                        p = p.next;
                    pre.next = p;
                } else {
                    pre = p;
                    p = p.next;
                }
            }
            return first.next;
        }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
