package book;

import exceptions.ExistElementException;
import exceptions.NoExistElementException;

public class Chapter extends BookElement {
	Chapter(String title){
		this.title = title;
	}
	
	@Override
	public void add(String subchapterTitle) throws ExistElementException {
		Subchapter subchapter = new Subchapter(subchapterTitle);
		
		if(this.elements.contains(subchapter) == false){
			this.elements.add(subchapter);
		}
		else
			throw new ExistElementException();
		
	}

	@Override
	public void add(String subchapterTitle, int position) throws ExistElementException {
		Subchapter subchapter = new Subchapter(subchapterTitle);
		
		if(this.elements.contains(subchapter) == false){
			this.elements.add(position,subchapter);
		}
		else
			throw new ExistElementException();
		
	}
	
	public void addParagraph(String subchapterTitle, String... paragraphs) throws NoExistElementException{
		Subchapter subchapter = new Subchapter(subchapterTitle);
		
		if(this.elements.contains(subchapter) == true){
			((Subchapter)this.elements.get(this.elements.indexOf(subchapter))).addParagraphs(paragraphs);
		}
		else
			throw new NoExistElementException();
	}
	
	public void addParagraph(String subchapterTitle, String paragraphTitle, int position) throws NoExistElementException, ExistElementException{
		Subchapter subchapter = new Subchapter(subchapterTitle);
		
		if(this.elements.contains(subchapter) == true){
			((Subchapter)this.elements.get(this.elements.indexOf(subchapter))).add(paragraphTitle, position);
		}
	}
	
	@Override
	public boolean remove(String subchapterTitle){
		Subchapter subchapter = new Subchapter(subchapterTitle);
		
		if(this.elements.contains(subchapter) == true){
			return this.elements.remove(subchapter);
		}
		return false;
	}
	
	public boolean remove(String subchapterTitle, String paragraph){
		Subchapter subchapter = new Subchapter(subchapterTitle);
		
		if(this.elements.contains(subchapter) == true){
			return ((Subchapter)(this.elements.get(this.elements.indexOf(subchapter)))).remove(paragraph);
		}
		return false;
	}
}
