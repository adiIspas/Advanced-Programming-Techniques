import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author NOI 25
 * Se sorteaza textele crescator din input. Se incepe aranjarea lor in ordinea sortari de la banda 1 la banda p.
 * Se reia procedura de aranjare atata timp cat exista texte.
 */

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		int nrTexte = 0, nrBenzi = 0, lungime = 0, bandaCurenta = 0;
		Vector<Text> texte = new Vector<Text>();
		
		File file = new File("F:\\Java WorkSpace\\Varianta2 - Pb2_b\\in.txt");
		Scanner sc = new Scanner(file);
		
		nrTexte = sc.nextInt();
		nrBenzi = sc.nextInt();
		
		for(int i = 0; i < nrTexte; i++){
			lungime = sc.nextInt();
			texte.addElement(new Text(lungime));
		}
		sc.close();
		
		Collections.sort(texte);
		bandaCurenta = 1;
		System.out.println("Text   Banda");
		for(Text text:texte){
			if(bandaCurenta <= nrBenzi){
				System.out.println("  " + text + " 	 " + bandaCurenta);
				bandaCurenta++;
			}
			else{
				bandaCurenta = 1;
				System.out.println("  " + text + " 	 " + bandaCurenta);
				bandaCurenta++;
				
			}
		}
	}

}
