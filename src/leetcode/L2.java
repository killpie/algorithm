package leetcode;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，
 * 它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode head1 = null;

        int carry = 0;
        while (l1!=null&&l2!=null){
            int temp = l1.val+l2.val+carry;
            int g = temp%10;
            carry = temp/10;

            if (head!=null){
                ListNode node = new ListNode(g);
                head.next = node;
                head = node;
            }else {
                head = new ListNode(g);
                head1 = head;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1==null&&l2==null){
            if (carry!=0){
                head.next = new ListNode(carry);
            }

            return head1;
        }

        ListNode l3 = l1==null?l2:l1;

        while (l3!=null){
            int temp = l3.val+carry;
            int g = temp%10;
            carry = temp/10;

            if (head!=null){
                ListNode node = new ListNode(g);
                head.next = node;
                head = node;
            }else {
                head.val=g;
            }

            l3 = l3.next;
        }

        if (carry!=0){
            head.next = new ListNode(carry);
        }

        return head1;

    }
}
