package orderStatistic;

public class main {

	public static void main(String[] args) {
		Integer[] la = { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 };
		KLargestOrderStatisticsImpl<Integer> i = new KLargestOrderStatisticsImpl();
		QuickSelect<Integer> j = new QuickSelect();
		
		System.out.println(j.quickSelect(la, 3));
	}

}
