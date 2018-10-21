package niuke;

import java.util.ArrayList;

public class NK60 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<TreeNode> arrayDeque = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot==null)
            return arrayLists;
        arrayDeque.add(pRoot);

        while (!arrayDeque.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            int size = arrayDeque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = arrayDeque.get(i);
                arrayList.add(node.val);
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = arrayDeque.remove(0);
                if (node.left!=null){
                    arrayDeque.add(node.left);
                }
                if (node.right!=null){
                    arrayDeque.add(node.right);
                }
            }

            arrayLists.add(arrayList);
        }

        return arrayLists;
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
