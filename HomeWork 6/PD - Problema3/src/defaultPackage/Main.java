package defaultPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("F:\\Java WorkSpace\\PD - Problema3\\in.txt");
		Scanner input = new Scanner(file);
		 
		int numarPenalizari = 0, penalizare = 0, penalizareSpatiu = 0, penalizareAltaAliniere = 0;
		String secventaX = null, secventaY = null, secventaPenalizare = null;
		String aliniereaX = "", aliniereaY = "";
		
		// Citim secventele
		secventaX = input.next();
		secventaY = input.next();
		
		int[][] matriceaPenalizarilor = new int[secventaX.length()][secventaY.length()];
		int[][] matriceaScorului = new int[secventaX.length() + 1][secventaY.length() + 1];
		
		// Citim penalizarile
		numarPenalizari = input.nextInt();
		for(int i = 0; i < numarPenalizari; i++){
			secventaPenalizare = input.next();
			penalizare = input.nextInt();
			
			if(secventaPenalizare.equals("spatiu") == true)
				penalizareSpatiu = penalizare;
			
			if(secventaPenalizare.equals("rest") == true)
				penalizareAltaAliniere = penalizare;
			
			// Pentru penalizarile dintre litere definite construim matricea penalizarilor
			// de unde vom lua mai tarziu pentru calculul matricei scorurilor penalizarile
			// *Se cauta in secventa pozitia literi si se completeaza in pozitia corespunzatoare in matrice
			for(int j = 0; j < secventaX.length(); j++){
				if(secventaPenalizare.charAt(0) == secventaX.charAt(j)){
					for(int k = 0; k < secventaY.length(); k++){
						if(secventaPenalizare.charAt(1) == secventaY.charAt(k)){
							matriceaPenalizarilor[j][k] = matriceaPenalizarilor[k][j] = penalizare;
						}
					}
				}
				else
					if(secventaPenalizare.charAt(1) == secventaX.charAt(j)){
						for(int k = 0; k < secventaY.length(); k++){
							if(secventaPenalizare.charAt(0) == secventaY.charAt(k)){
								matriceaPenalizarilor[j][k] = matriceaPenalizarilor[k][j] = penalizare;
							}
						}
					}
			}
			
		}	
		input.close();
		
		// Matricea penalizarilor
		// Dupa ce s-au citit toate penalizarile definite mai ramane de adaugat penalizarile nedefinite
		// ce le gasim in variabila penalizareAltaAliniere
		for(int i = 0; i < secventaX.length(); i++){
			for(int j = 0; j < secventaY.length(); j++)
				if((secventaX.charAt(i) != secventaY.charAt(j)) && matriceaPenalizarilor[j][i] == 0)
					matriceaPenalizarilor[j][i] = penalizareAltaAliniere;

		}
		
		// Pentru a afisa matricea penalizarilor se pot decomenta urmatoarele linii de cod
//		for(int i = 0; i < secventaX.length(); i++){
//			for(int j = 0; j < secventaY.length(); j++){
//				System.out.print(matriceaPenalizarilor[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		// Matricea scorului
		// Pentru inceput bordam prima linie si prima coloana cu penalizarea pentru spatiu pentru situatia in care 
		// in primul cuvant avem 0 caractere si in al doilea x si invers
		for(int i = 0; i < secventaX.length() + 1; i++)
			matriceaScorului[0][i] = penalizareSpatiu * i;
		for(int i = 0; i < secventaY.length() + 1; i++)
			matriceaScorului[i][0] = penalizareSpatiu * i;
		
		// Pentru restul matricei aplicam relatia de recurenta
		// Pe pozitia (i,j) vom pune minimul dintre {valoarea din diagonala plus penalizarea litera (ceea ce inseamna ca se adauga o literea din fiecare secventa);
 		//                                           valoarea de sus plus penalizarea pentru spatiu (ceea ce inseamna ca se adauga o litera in secventa X si spatiu in Y);
		//											 valoarea din stanga plus penalizarea pentru spatiu (ceea ce inseamna ca se adauga o litera in secventa Y si spatiu in X)}                                             
		for(int i = 1; i < secventaX.length() + 1; i++){
			for(int j = 1; j < secventaY.length() + 1; j++){
				/*if(secventaX.charAt(i - 1) == secventaY.charAt(j - 1)){
					matriceaScorului[i][j] = Math.min(Math.min(matriceaScorului[i - 1][j - 1], penalizareSpatiu + matriceaScorului[i - 1][j]), 
							penalizareSpatiu + matriceaScorului[i][j - 1]);
				}
				else{*/
					matriceaScorului[i][j] = Math.min(Math.min(matriceaPenalizarilor[j - 1][i - 1] + matriceaScorului[i - 1][j - 1], 
											 penalizareSpatiu + matriceaScorului[i - 1][j]), penalizareSpatiu + matriceaScorului[i][j - 1]);
				//}
			}
		}
		
		// Pentru a afisa matricea penalizarilor se pot decomenda urmatoarele linii de cod
//		for(int i = 0; i < secventaX.length() + 1; i++){
//			for(int j = 0; j < secventaY.length() + 1; j++){
//				System.out.print(matriceaScorului[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		System.out.println("Alinierea de scor minim: " + matriceaScorului[secventaX.length()][secventaY.length()] + " pentru secventele " + secventaX + ", " + secventaY + " este: ");
		
		// Reconstructie aliniere
		int i = secventaX.length();
		int j = secventaY.length();
		
		// Plecam din coltul dreapta jos si reconstruim secventa dupa modul in care am definit matricea scorurilor
		// Ceea ce inseamna ca vom verifica de unde provine valoarea curenta
		while(i > 0 || j > 0){
			
			// daca provine din diagonala stim ca trebuie sa adaugam o litera din fiecare secventa
			if(i > 0 && j > 0 && (matriceaScorului[i][j] == matriceaScorului[i - 1][j - 1] + matriceaPenalizarilor[j - 1][i - 1])){
				aliniereaX = secventaX.charAt(i - 1) + aliniereaX;
				aliniereaY = secventaY.charAt(j - 1) + aliniereaY;
				
				i = i - 1;
				j = j - 1;
			}
			else
				// daca provine de sus stim ca trebuie sa adaugam o litera in secventa X si spatiu in Y
				if(i > 0 && (matriceaScorului[i][j] == matriceaScorului[i - 1][j] + penalizareSpatiu)){
					aliniereaX = secventaX.charAt(i - 1) + aliniereaX;
					aliniereaY = "-" + aliniereaY;
					
					i = i - 1;
				}
				else
					// altfel privine din stanga si adaugam spatiu in secventa X si litera in secventa Y
					{
						aliniereaX = "-" + aliniereaX;
						aliniereaY = secventaY.charAt(j - 1) + aliniereaY;
					
						j = j - 1;
					}
		}
		
		System.out.println(aliniereaX);
		System.out.println(aliniereaY);
	}
}
