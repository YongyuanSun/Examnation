package demo;

/**
 * 输出两个日期之间的天数差
 */
public class DayNum{
	public static int parse(int[] old,int[] now ){
//		if(now[0]<old[0]){
//			throw new RuntimeException("起始年份不能大于终止年份");
//		}
//		if(now[0]==old[0]&&now[1]<old[1]){
//			throw new RuntimeException("同一年起始月份不能高于终止月份");
//		}
//		if(now[0]==old[0]&&now[1]==old[1]&&now[2]<old[2]){
//			throw new RuntimeException("同年同月起始日期不能高于终止日期");
//		}
		if(now[0]==old[0]&&now[1]==old[1]&&now[2]>=old[2]){
			return now[2]-old[2];
		}
		if(now[0]==old[0]&&now[1]>old[1]){
			int oldDays=getNowYearDays(old);
			int newDays=getNowYearDays(now);
			return newDays-oldDays;
		}
		if(now[0]>old[0]){
			int passed=getNowYearDays(old);
			int entityYearDays = getEntityYearDays(old[0],now[0]);
			int nowYearDays=getNowYearDays(now);
			return entityYearDays-passed+nowYearDays;
		}
		throw new RuntimeException("起始时间不大于终止时间");

	}

	private static int getEntityYearDays(int oldYear, int newYear) {
		int sum=0;
		for(int i=oldYear;i<newYear;i++){
			if (((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)){
				sum+=366;
			}else {
				sum+=365;
			}
		}
		return sum;
	}

	private static int getOldYearDays(int[] old) {
		int passed = getNowYearDays(old);
		int year=old[0];
		int sum=0;
		if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)){
			sum=366-passed;
		}else {
			sum=365-passed;
		}
		return sum;
	}

	private static int getNowYearDays(int[] now) {
		int year=now[0];
		int month=now[1];
		int day=now[2];
		int sum=0;
		for (int i = 1; i < month; i++) {
			switch (i) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					sum += 31;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum += 30;
					break;
				case 2:
					//闰年的2月29天，平年28天
					if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
						sum += 29;
					} else {
						sum += 28;
					}
				default:
					break;
			}
		}
		sum += day;
		return sum;
	}

	public static void main(String[] args) {
		int[] old={2016,2,28};
		int[] now={2016,3,2};
		System.out.println(parse(old,now));
	}
}
