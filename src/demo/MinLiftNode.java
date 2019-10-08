package demo;






class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class MinLiftNode {
	static int minValue = Integer.MAX_VALUE;
	static int count = 0;
	public int run(TreeNode root) {
		if(root==null){
			return 0;
		}

		solute(root);
		int res=minValue;
		count=0;
		minValue= Integer.MAX_VALUE;
		return res;
	}

	private void solute(TreeNode root) {
		count++;
		if(root.left==null&&root.right==null){
			if(minValue>count){
				minValue=count;
			}

		}
		if(root.left!=null){
			solute(root.left);
		}
		if(root.right!=null){
			solute(root.right);
		}
		count--;
	}
}