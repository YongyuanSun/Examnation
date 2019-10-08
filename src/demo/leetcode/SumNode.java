package demo.leetcode;




class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
class SumNode {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
//		int len1 = checkLen(l1);
//		int len2 = checkLen(l2);
//		int minLen = Math.min(len1,len2);
//		int maxLen = Math.max(len1,len2);
		int carry = 0;
		ListNode head =new ListNode(0);
		ListNode cur= head;
//		for(int i=0;i<minLen;i++){
//			int a=l1.val;
//			int b=l2.val;
//			cur.next=new ListNode((a+b+carry)%10);
//			carry=(a+b+carry)/10;
//		}
		while(l1!=null&&l2!=null){
			int a=l1.val;
			int b=l2.val;
			cur.next=new ListNode((a+b+carry)%10);
			cur=cur.next;
			carry=(a+b+carry)/10;
			l1=l1.next;
			l2=l2.next;
		}
		while (l1!=null){
			int a=l1.val;
			cur.next=new ListNode((a+carry)%10);
			cur=cur.next;
			carry=(a+carry)/10;
			l1=l1.next;
		}
		while (l2!=null){
			int b=l2.val;
			cur.next=new ListNode((b+carry)%10);
			cur=cur.next;
			carry=(b+carry)/10;
			l2=l2.next;
		}
		if(carry!=0){
			cur.next=new ListNode(carry);
		}
		return head.next;
	}

	public static void main(String[] args) {
		ListNode h1=new ListNode(0);
		ListNode head1 = h1;
//		h1.next=new ListNode(4);
//		h1=h1.next;
//		h1.next=new ListNode(3);

		ListNode h2=new ListNode(5);
		ListNode head2 = h2;
		h2.next=new ListNode(6);
		h2=h2.next;
		h2.next=new ListNode(4);
		SumNode sumNode = new SumNode();
		ListNode listNode = sumNode.addTwoNumbers(head1, head2);
		while (listNode!=null){
			System.out.println(listNode.val);
			listNode=listNode.next;
		}

	}
}