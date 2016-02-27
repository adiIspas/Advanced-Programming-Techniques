package defaultPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Cub> cuburi = new ArrayList<Cub>();
		File file = new File("F:\\Java WorkSpace\\PD - Problema1\\in.txt");
		Scanner input = new Scanner(file);
		
		int numarCuburi = 0, latura, culoare;
		Cub cub;
		
		numarCuburi = input.nextInt();

		for(int i = 0; i < numarCuburi; i++){
			latura = input.nextInt();
			culoare = input.nextInt();
			
			cub = new Cub(latura,culoare);
			cuburi.add(cub);
		}
		
		input.close();
		
		Turn.algoritm(cuburi);
		
	}

}
