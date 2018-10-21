package niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class NK57 {
    //{8,6,9,5,7,7,5}
    TreeNode root = new TreeNode(8);
    TreeNode root1 = new TreeNode(6);
    TreeNode root2 = new TreeNode(6);
    TreeNode root3 = new TreeNode(5);
    TreeNode root4 = new TreeNode(7);
    TreeNode root5 = new TreeNode(7);
    TreeNode root6 = new TreeNode(5);

    public static void main(String[] args) {
        NK57 nk57 = new NK57();
        nk57.root.left=nk57.root1;
        nk57.root.right=nk57.root2;
        nk57.root1.left=nk57.root3;
        nk57.root1.right=nk57.root4;
        nk57.root2.left=nk57.root5;
        nk57.root2.right=nk57.root6;
        System.out.println(nk57.isSymmetrical(nk57.root));
    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null)
            return true;
        return f(pRoot.left,pRoot.right);
    }

    boolean f(TreeNode left, TreeNode right){
        if (left==null&&right==null)
            return true;
        if (left==null||right==null)
            return false;
        return (left.val==right.val)&&f(left.left,right.right)&&f(left.right,right.left);
    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
