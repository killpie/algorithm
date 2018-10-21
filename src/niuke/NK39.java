package niuke;

public class NK39 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null)
            return false;
        int d = treeDeep(root.left)-treeDeep(root.right);
        if (d==0||d==1||d==-1){
            IsBalanced_Solution(root.left);
            IsBalanced_Solution(root.right);
        }else {
            return false;
        }

        return true;
    }


    public int treeDeep(TreeNode root){
        if (root==null)
            return 0;
        return Math.max(treeDeep(root.left),treeDeep(root.right))+1;
    }



    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}


