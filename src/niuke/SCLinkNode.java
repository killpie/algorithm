package niuke;

public class SCLinkNode {
    public TreeNode realHead ;
    public TreeNode pre;
    //为什么我把你的程序不加引用之后就会出错呢，而且只会出现右半边的数据
//必须要加，因为pre是动态变化的，如果不加的话，调用结束后很可能pre没有变化，一直为空
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null)
            return null;
        in(pRootOfTree);
        return realHead;
    }

    public void in(TreeNode root){
        if (root==null)
            return ;

        in(root.left);
        if (pre==null){
            pre=root;
            realHead=root;
        }else {
            pre.right=root;
            root.left=pre;
            pre=root;
        }
        in(root.right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);

    public static void main(String[] args) {
        SCLinkNode node = new SCLinkNode();
        node.node6.left=node.node4;
        node.node6.right=node.node7;
        node.node4.left=node.node3;
        node.node4.right=node.node5;
        node.node7.right=node.node8;

        TreeNode treeNode = node.Convert(node.node6);

        while (treeNode!=null){
            System.out.println(treeNode.val);
            treeNode=treeNode.right;
        }
    }
}
