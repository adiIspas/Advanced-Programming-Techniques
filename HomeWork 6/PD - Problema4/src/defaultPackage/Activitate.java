package defaultPackage;
import java.util.Comparator;

//implements Comparable<Activitate>

public class Activitate  {
	public int profit;
	public int durata;
	public int termen;
	
	Activitate(int profit, int durata, int termen){
		this.profit = profit;
		this.termen = termen;
		this.durata = durata;
	}
	
	Activitate(){
		this.profit = 0;
		this.termen = 0;
		this.durata = 0;
	}

//	@Override
//	public int compareTo(Activitate activitate) {
//		return this.profit < activitate.profit ? 1 : -1;
//	}
	
	public static Comparator<Activitate> TERMEN = new Comparator<Activitate>() {
         @Override
         public int compare(Activitate a1, Activitate a2) {
        	 return a1.termen > a2.termen ? 1 : -1;
         }
	};
	
	public String toString(){
		return profit + "   " + durata + "   " + termen;
	}

}
