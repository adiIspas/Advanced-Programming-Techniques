import java.util.Comparator;

public class Activitate implements Comparable<Activitate> {
	int profit;
	int termen;
	
	Activitate(int profit, int termen){
		this.profit = profit;
		this.termen = termen;
	}

	@Override
	public int compareTo(Activitate activitate) {
		return this.profit < activitate.profit ? 1 : -1;
	}
	
	public static Comparator<Activitate> TERMEN = new Comparator<Activitate>() {
         @Override
         public int compare(Activitate a1, Activitate a2) {
        	 return a1.termen > a2.termen ? 1 : -1;
         }
	};
	
	public String toString(){
		return "   " + profit + "       " + termen;
	}
}
