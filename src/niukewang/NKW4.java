package niukewang;

import leetcode.TreeNode;

import java.math.BigInteger;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历
 * 的结果中都不含重复的数字。例如输入前序遍历序列
 * {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 *
 * startPre+1，指的是前序遍历左子树的开始位置，即前序遍历根节点的下一个节点。
 *
 * i-startIn，i指的是中序遍历根节点的位置，减去中序遍历开始位置即左子树的长度。
 * 所以startPre+i-startIn是前序遍历左子树结束的位置。
 *
 * i-startIn+startPre+1，即startPre+(i-startIn)+1，
 * 即从startPre位置越过左孩子及其子节点的偏移值再往下一个节点走。
 */
public class NKW4 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return null;
    }
}
