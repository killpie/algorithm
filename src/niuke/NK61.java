package niuke;

public class NK61 {

    //{8,6,9,5,7,7,5}
    TreeNode root = new TreeNode(8);
    TreeNode root1 = new TreeNode(6);
    TreeNode root2 = new TreeNode(6);
    TreeNode root3 = new TreeNode(5);
    TreeNode root4 = new TreeNode(7);
    TreeNode root5 = new TreeNode(7);
    TreeNode root6 = new TreeNode(5);

    public static void main(String[] args) {
        NK61 nk61 = new NK61();
        nk61.root.left=nk61.root1;
        nk61.root.right=nk61.root2;
        nk61.root1.left=nk61.root3;
        nk61.root1.right=nk61.root4;
        nk61.root2.left=nk61.root5;
        nk61.root2.right=nk61.root6;
        System.out.println(nk61.Serialize(nk61.root));
        nk61.preIt(nk61.Deserialize(nk61.Serialize(nk61.root)));
    }

    String Serialize(TreeNode root) {
        if (root==null)
            return "";
        return pre(root,"");
    }

    String pre(TreeNode node, String str){
        if (node==null){
            str+="#,";
            return str;
        }else {
            str+=node.val+",";
        }
        str = pre(node.left,str);
        str =pre(node.right,str);
        return str;
    }



    int i = 0;
    TreeNode Deserialize(String str) {
        if (str==null||str.length()==0)
            return null;
        String[] strings = str.split(",");
        return createPre(strings);
    }


    TreeNode createPre(String[] str){
        if (str[i].charAt(0)=='#'){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[i]));
        if (i==str.length)
            return root;
        else
            i++;
        root.left=createPre(str);
        root.right=createPre(str);
        return root;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    void preIt(TreeNode node){
        if (node==null)
            return;
        System.out.print(node.val);
        preIt(node.left);
        preIt(node.right);
    }
}
