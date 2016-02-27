package book;
import exceptions.ExistElementException;
import java.util.*;

public abstract class BookElement {
	String title;
	ArrayList<BookElement> elements = new ArrayList<>();
	
	public boolean equals(Object element){
		if(title.equals(((BookElement)element).title))
			return true;
		return false;
	}
	
	public abstract void add(String element) throws ExistElementException;
	public abstract void add(String element, int position) throws ExistElementException;
	public abstract boolean remove(String element);
	
	@Override
	public String toString(){
		return title;
	}
}
