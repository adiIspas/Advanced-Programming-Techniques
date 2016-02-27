
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
	
	public String toString(){
		return "   " + profit + "       " + termen;
	}
}
