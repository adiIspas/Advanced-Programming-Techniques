package defaultPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void afiseazaOptimul(ArrayList<Activitate> activitati, int[][] programareActivitati, int numarActivitate, int termenMaxim){
		if(numarActivitate == 0)
			return;
		
		int termenAuxiliar = 0;
		
		if(programareActivitati[numarActivitate][termenMaxim] == programareActivitati[numarActivitate - 1][termenMaxim])
			afiseazaOptimul(activitati, programareActivitati, numarActivitate - 1, termenMaxim);
		else{
			termenAuxiliar = Math.min(termenMaxim, activitati.get(numarActivitate).termen) - activitati.get(numarActivitate).durata;
			afiseazaOptimul(activitati,programareActivitati,numarActivitate - 1,termenAuxiliar);
			System.out.println(activitati.get(numarActivitate));
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("F:\\Java WorkSpace\\PD - Problema4\\in.txt");
		Scanner input = new Scanner(file);
		
		int numarActivitati = 0, profitActivitate = 0, durataActivitate = 0, termenActivitate = 0;
		int termenMaxim = 0, termenAuxiliar = 0;
		
		ArrayList<Activitate> activitati = new ArrayList<Activitate>();
		
		activitati.add(new Activitate());
		
		numarActivitati = input.nextInt();
		for(int i = 0; i < numarActivitati; i++){
			
			profitActivitate = input.nextInt();
			durataActivitate = input.nextInt();
			termenActivitate = input.nextInt();
			
			if(termenMaxim < termenActivitate)
				termenMaxim = termenActivitate;
			
			activitati.add(new Activitate(profitActivitate,durataActivitate,termenActivitate));
		}
		input.close();
		
		Collections.sort(activitati,Activitate.TERMEN);
		
		int[][] programareActivitati = new int[numarActivitati + 1][termenMaxim + 1];
		
		for(int i = 1; i <= numarActivitati; i++){
			for(int termen = 0; termen <= termenMaxim; termen++){
				
				termenAuxiliar = Math.min(termen, activitati.get(i).termen) - activitati.get(i).durata;
				
				if(termenAuxiliar < 0)
					programareActivitati[i][termen] = programareActivitati[i - 1][termen];
				else
					programareActivitati[i][termen] = Math.max(programareActivitati[i - 1][termen], activitati.get(i).profit + programareActivitati[i - 1][termenAuxiliar]);
			}
		}
		
		for(int i = 0; i <= numarActivitati; i++){
			for(int j = 0; j <= termenMaxim; j++){
				System.out.print(programareActivitati[i][j] + " ");
			}
			System.out.println();
		}
		
		afiseazaOptimul(activitati,programareActivitati,numarActivitati,termenMaxim);
	}

}
