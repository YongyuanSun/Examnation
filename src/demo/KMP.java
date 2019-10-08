package demo;

public class KMP {

	/**
	 * 求出一个字符数组的next数组
	 * @param t 字符数组
	 * @return next数组
	 */
	public static int[] getNextArray(char[] t) {
		int[] next=new int[t.length];
		int k=-1;
		next[0]=-1;
		int j=0;
		while (j<t.length-1){
			if(k==-1||t[j]==t[k]){
				next[++j]=++k;
			}else {
				k=next[k];
			}
		}
		return next;
	}

	/**
	 * 对主串s和模式串t进行KMP模式匹配
	 * @param s 主串
	 * @param t 模式串
	 * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
	 */
	public static int kmpMatch(String s, String t){
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		int[] next = getNextArray(t_arr);
		int i = 0, j = 0;
		while (i<s_arr.length && j<t_arr.length){
			if(j == -1 || s_arr[i]==t_arr[j]){
				i++;
				j++;
			}
			else
				j = next[j];
		}
		if(j == t_arr.length)
			return i-j;
		else
			return -1;
	}

	public static void main(String[] args) {
		System.out.println(kmpMatch("abcabababaaaabaabcacb", "ababaa"));
	}

}
