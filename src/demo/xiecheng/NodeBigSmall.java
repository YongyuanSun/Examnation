package xiecheng;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NodeBigSmall {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/*请完成下面这个函数，实现题目要求的功能
	 ******************************开始写代码******************************/
	static ListNode partition(ListNode head,int m) {
		List<Integer> big = new ArrayList();
		List<Integer> small = new ArrayList<>();
		if(head==null){
			return head;
		}
		if(head.next==null){
			return head;
		}
		while (head!=null){
			if(head.val>m){
				big.add(head.val);
			}
			if(head.val<=m){
				small.add(head.val);
			}
			head=head.next;
		}
		ListNode res = new ListNode(0);
		ListNode cur = res;
		Iterator<Integer> iterator = small.iterator();
//		while (iterator.hasNext()){
//			ListNode node = new ListNode(iterator.next());
//			cur.next=node;
//			cur=cur.next;
//		}
//		Iterator<Integer> sIt = big.iterator();
//		while (sIt.hasNext()){
//			ListNode node = new ListNode(sIt.next());
//			cur.next=node;
//			cur=cur.next;
//		}
		while (!small.isEmpty()){
			ListNode node = new ListNode(small.remove(0));
			cur.next=node;
			cur=cur.next;
		}
		while (!big.isEmpty()){
			ListNode node = new ListNode(big.remove(0));
			cur.next=node;
			cur=cur.next;
		}
		return res.next;
	}
	/******************************结束写代码******************************/


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ListNode head=null;
		ListNode node=null;
		int m=in.nextInt();
		while(in.hasNextInt()){
			int v=in.nextInt();
			if(head==null){
				node=new ListNode(v);
				head=node;
			}else{
				node.next=new ListNode(v);
				node=node.next;
			}
		}
		head= partition(head,m);
		if(head!=null){
			System.out.print(head.val);
			head=head.next;
			while(head!=null){
				System.out.print(",");
				System.out.print(head.val);
				head=head.next;
			}
		}
		System.out.println();
	}
}
