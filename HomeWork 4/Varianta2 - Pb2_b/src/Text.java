
public class Text implements Comparable<Text>{
	int lungime;
	
	Text(int lungime){
		this.lungime = lungime;
	}

	@Override
	public int compareTo(Text text) {
		return this.lungime > text.lungime ? 1 : -1;
	}
	
	public String toString(){
		return "" + lungime;
	}
	
}
