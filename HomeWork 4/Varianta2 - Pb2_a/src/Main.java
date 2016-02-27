import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author NOI 25
 * Se sorteaza textele descrescator dupa raportul frecventa/lungime si se afiseaza in functie de aceasta frecventa.
 * Astfel un text cu cat are un raport mai mare cu atat trebuie pus mai in fata.
 */

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		int lungime = 0, frecventa = 0, nrTexte = 0;
		Vector<Text> texte = new Vector<Text>();
		
		File file = new File("F:\\Java WorkSpace\\Varianta2 - Pb2_a\\in.txt");
		Scanner sc = new Scanner(file);
		
		nrTexte = sc.nextInt();
		for(int i = 0; i < nrTexte; i++){
			lungime = sc.nextInt();
			frecventa = sc.nextInt();
			
			texte.addElement(new Text(lungime,frecventa));
		}
		sc.close();
		
		Collections.sort(texte);
		for(Text text:texte){
			System.out.println(text);
		}
		
	}
}
