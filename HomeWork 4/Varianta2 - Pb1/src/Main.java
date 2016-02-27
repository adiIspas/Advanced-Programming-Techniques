import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author NOI 25
 * Se sorteaza cuburile descrescator dupa lungimile laturilor. Se parcurge vectorul sortat astfel si se afiseaza cuburi astfel incat
 * oricare 2 cuburi alaturate sa nu aiba aceasi culoare.
 */

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		int nrCuburi = 0, latura = 0, culoare = 0, culoareAnterioara = 0, inaltime = 0;
		Vector<Cub> cuburi = new Vector<Cub>();
		
		File file = new File("F:\\Java WorkSpace\\Varianta2 - Pb1\\in.txt");
		Scanner sc = new Scanner(file);
		nrCuburi = sc.nextInt();
		
		for(int i = 0; i < nrCuburi; i++){
			latura = sc.nextInt();
			culoare = sc.nextInt();
			
			cuburi.addElement(new Cub(latura,culoare));
		}
		
		sc.close();
		
		Collections.sort(cuburi);
		
		System.out.println("Turn");
		System.out.println(cuburi.elementAt(0));
		culoareAnterioara = cuburi.elementAt(0).getCuloare();
		inaltime += cuburi.elementAt(0).getLatura();
		for(Cub cub:cuburi)
			if(cub.getCuloare() != culoareAnterioara)
				{
				 System.out.println(cub);
				 culoareAnterioara = cub.getCuloare();
				 inaltime += cub.getLatura();
				}
		System.out.println("Inaltime: " + inaltime);
	}
}
