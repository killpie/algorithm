package niuke;

import java.util.HashSet;

/**
 *
 * 思路：leetcode上也有这道题，具体思想是，两个指针fast和slow，fast以slow两倍速度前进，
 * 如果没有环，那么fast和slow不会相遇此时返回null；如果有环，那fast和slow肯定会再次相遇
 * 相遇的时候，fast刚好比slow多走了一圈环的长度。
 * https://uploadfiles.nowcoder.net/images/20170422/943729_1492841744777_3BB680C9CBA20442ED66C5066E1F7175">
 * 用图来描述下，当fast与slow相遇时，fast走过的距离为a + b + c + b，而slow走过的距离为
 * a + b，因为fast是slow速度的两倍，则有a+b+c+b = 2*(a+b)，登出a=c;此时slow节点所处X处
 * 到环起点Y处的距离a和X节点到Y处距离c其实是相等的，此时第三个指针p从x处，以和slow指针
 * 相同的速度前进，当它两相遇时，即为环的起点Y处！
 */
public class NK55 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null)
            return null;
        HashSet set = new HashSet();
        ListNode setHead =  pHead;
        boolean flag=false;
        while (setHead!=null){
            int t = set.size();
            set.add(setHead);
            if (set.size()==t) {
                flag=true;
                break;
            }
            setHead = setHead.next;
        }
        if (!flag){
            return null;
        }
        int length = set.size();

        int i =0;
        while (i++<length){
            pHead = pHead.next;
        }
        return pHead;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


