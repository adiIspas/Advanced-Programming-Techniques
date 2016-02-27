
public class Text implements Comparable<Text>{
	int lungime;
	int frecventa;
	double raport;
	
	Text(int lungime, int frecventa){
		this.lungime = lungime;
		this.frecventa = frecventa;
		this.raport = (double)frecventa/lungime;
	}

	@Override
	public int compareTo(Text text) {
		return this.raport < text.raport ? 1 : -1;
	}
	
	public String toString(){
		return "" + lungime + "  " + frecventa;
	}
}
