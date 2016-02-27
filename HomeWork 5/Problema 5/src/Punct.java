import java.util.Comparator;
public class Punct implements Comparable<Punct>{
	double x;
	double y;
	
	Punct(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	double distanta(Punct punct){
		return Math.sqrt((this.x - punct.x)*(this.x - punct.x) + (this.y - punct.y)*(this.y - punct.y));
	}
	
	@Override
	public int compareTo(Punct punct) {
		 if(this.x < punct.x)
	            return -1;
	        if(this.x == punct.x && this.y < punct.y)
	            return -1;
	        return 1;
	}
	
	public static Comparator<Punct> Y = new Comparator<Punct>() {
         @Override
         public int compare(Punct x, Punct y) {
        	 if(x.y < y.y)
                 return -1;
             if(x.y == y.y && x.x < y.x)
                 return -1;
             return 1;
         }
	};
	
	public String toString(){
		return  x + " " + y;
	}
	
}
