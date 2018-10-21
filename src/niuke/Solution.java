package niuke;




public class Solution {

    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);


    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode mergeList = null;
        ListNode head = null;
        if (list1==null&&list2==null){
            return null;
        }
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){

                if (mergeList==null)
                    head=mergeList=list1;
                else {
                    mergeList.next=list1;
                    mergeList = mergeList.next;
                }
                list1 = list1.next;
            }else {
                if (mergeList==null)
                    head=mergeList=list2;
                else {
                    mergeList.next=list2;
                    mergeList = mergeList.next;
                }
                list2 = list2.next;
            }
        }

        if (list1!=null){
            mergeList.next=list1;
        }else {
            mergeList.next=list2;
        }

        return head;
    }




    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = {1,2,6,7};

        solution.node1.next=solution.node3;

        solution.node3.next=solution.node5;

        solution.node2.next=solution.node4;
        solution.node4.next=solution.node6;

        ListNode v = solution.Merge(solution.node1,solution.node2);

        while (v!=null){
            System.out.println(v.val);
            v=v.next;
        }

    }
}