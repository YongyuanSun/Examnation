package demo.leetcode;


class AToI {
	public int myAtoi(String str) {
		if(str==null||str.length()==0) return 0;
		boolean findNum=false;
		boolean negtive=false;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char c =str.charAt(i);
			if (c=='-'){
				if(i+1<str.length()){
					char c1=str.charAt(i+1);
					if (c1<='9'&&c1>='0'){
						//find
						findNum=true;
						negtive=true;
						//sb.append(c1);
						i++;
						while (c1<='9'&&c1>='0'){
							sb.append(c1);
							//i++;
							if(i+1>=str.length()){
								break;
							}
							c1=str.charAt(++i);
						}
						return convert(sb,negtive);
					}
				}

			}
			if(c<='9'&&c>='0'){
				//find
				findNum=true;
				while (c<='9'&&c>='0'){
					sb.append(c);
					if(i+1>=str.length()){
						break;
					}
					c=str.charAt(++i);
				}
				return convert(sb,negtive);
			}
			if(c=='+'){
				if(i+1<str.length()){
					char c1=str.charAt(i+1);
					if (c1<='9'&&c1>='0'){
						//find
						findNum=true;
						//negtive=true;
						//sb.append(c1);
						i++;
						while (c1<='9'&&c1>='0'){
							sb.append(c1);
							//i++;
							if(i+1>=str.length()){
								break;
							}
							c1=str.charAt(++i);
						}
						return convert(sb,negtive);
					}
				}
			}
			if(!(c==' ')){
				return 0;
			}
		}
		return 0;
	}

	private int convert(StringBuffer sb, boolean negtive) {
		while (sb.charAt(0)=='0'){
			sb.delete(0,1);
			if(sb.length()==0){
				return 0;
			}
		}
		int flag=checkRange(sb,negtive);
		if(flag>0){
			return Integer.MAX_VALUE;
		}
		if(flag<0){
			return Integer.MIN_VALUE;
		}

		return negtive?- new Integer(sb.toString()):new Integer(sb.toString());
	}

	private int checkRange(StringBuffer sb, boolean negtive) {
		if(sb.length()>10){
			return negtive?-1:1;
		}
		Long aLong = Long.parseLong(sb.toString());
		if(negtive){
			return aLong>=Math.abs(new Long(Integer.MIN_VALUE))?-1:0;
		}
		return aLong>=Integer.MAX_VALUE?1:0;
	}

	public static void main(String[] args) {
		String s = "  0000000000012345678";
		AToI solution= new AToI();
		int i = solution.myAtoi(s);
		System.out.println(i);
		System.out.println(Math.abs(new Long(Integer.MIN_VALUE)));
	}
}