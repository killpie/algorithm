package niuke;


public class NK62 {
    int i = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k==0)
            return null;
        if (pRoot!=null){

            TreeNode node = KthNode(pRoot.left,k);
            if (node!=null)
                return node;
            if (++i==k){
                return pRoot;
            }
            node = KthNode(pRoot.right,k);
            if (node!=null)
                return node;
        }
        return null;
    }

}
