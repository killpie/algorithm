package niuke;


import java.util.ArrayList;

public class BulidTree {

    int sum = 0;
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> arrayLists = new  ArrayList<>();
    public static void main(String[] args) {
        BulidTree bulidTree = new BulidTree();
        int[] s = {3,2,1};
        System.out.println();
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null)
            return arrayLists;
        arrayList.add(root.val);
        if (target-root.val==0&&root.right==null&&root.left==null){
            arrayLists.add(new ArrayList<>(arrayList));
        }
        FindPath(root.left,target-root.val);
        FindPath(root.right,target-root.val);
        arrayList.remove(arrayList.size()-1);//回退
        return arrayLists;
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
