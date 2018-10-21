package niuke;

public class FZLinkNode {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null)
            return null;
        RandomListNode head1 = pHead;
        RandomListNode head2 = pHead;


        while (pHead!=null){//先复制下一个节点
            RandomListNode next = pHead.next;
            RandomListNode node = new RandomListNode(pHead.label);
            node.next=next;
            pHead.next=node;
            pHead = next;
        }

        while (head1!=null){//对随机指针进行赋值
            if (head1.random!=null){
                RandomListNode randomNext = head1.random.next;
                head1.next.random = randomNext;
            }
            head1 = head1.next.next;
        }

        RandomListNode g = head2;
        RandomListNode newHead = head2.next;
        head2 = head2.next;
        g.next=null;
        g.random=null;
        g=null;
        while (head2.next!=null){//删除原节点
            RandomListNode temp = head2.next;
            head2.next = temp.next;
            head2=head2.next;
            temp.random = null;
            temp.next = null;
        }
        return newHead;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    RandomListNode node1 = new RandomListNode(1);
    RandomListNode node2 = new RandomListNode(2);
    RandomListNode node3 = new RandomListNode(3);
    RandomListNode node4 = new RandomListNode(4);
    RandomListNode node5 = new RandomListNode(5);
    RandomListNode node6 = new RandomListNode(6);
    public static void main(String[] args) {
        FZLinkNode node = new FZLinkNode();
        node.node1.next = node.node2;
        node.node2.next = node.node3;
        node.node3.next = node.node4;
        node.node4.next = node.node5;
        node.node5.next = node.node6;

        node.node1.random = node.node3;
        node.node3.random=node.node3;
        node.node5.random=node.node1;
        RandomListNode c = node.Clone(node.node1);

/*        System.out.println(c.random.label);
        System.out.println(c.next.label);*/
       while (c.next!=null){
            System.out.println("currnt"+c.label+" next:"+c.next.label);
            if (c.random!=null){
                System.out.println("random: "+c.random.label);
            }
            c=c.next;
        }



    }
}
