package demo.binarytree;

import demo.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {
	private static List<Integer> val;
	public static int[] preOder(TreeNode root){
		val=new ArrayList<>();
		traversing(root);
		int[] res = val.stream().mapToInt(i -> i).toArray();
		return res;



	}

	private static void traversing(TreeNode root) {
		if(root==null){
			return;
		}
		val.add(root.val);
		if(root.left!=null){
			traversing(root.left);
		}
		if(root.right!=null){
			traversing(root.right);
		}

	}
}
