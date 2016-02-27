import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author NOI 25
 * Se sorteaza activitatile descrescator dupa profit. Se incepe cu aranjarea lor in ordinea sortarii astfel incat activitatea
 * curenta se incearca a fi pusa maxim la termenul ei limita. In cazul in care este ocupat, se incerca pozitionarea la termen limita - 1
 * pana cand se gaseste o pozitie libera in care poate fi pusa. In cazul in care nu se gaseste o pozitie nu va fi planificata.
 */

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		int nrActivitati = 0, profit = 0, termen = 0;
		Vector<Activitate> activitati = new Vector<Activitate>();
		
		File file = new File("F:\\Java WorkSpace\\Varianta2 - Pb3\\in.txt");
		Scanner sc = new Scanner(file);
		
		nrActivitati = sc.nextInt();
		for(int i = 0; i < nrActivitati; i++){
			profit = sc.nextInt();
			termen = sc.nextInt();

			activitati.addElement(new Activitate(profit,termen));
		}
		sc.close();
		
		Collections.sort(activitati);
		
		int []v = new int[nrActivitati];
		
		int i, k;
		for(i = 1; i < nrActivitati + 1; i++){
			for(k = activitati.get(i - 1).termen; k > 0 && v[k] > 0; k--);
			if(k > 0)
				v[k] = i;
		}
		
		profit = 0;
		System.out.println("  Activitati\nProfit  Termen");
		for(i = 0; i < nrActivitati; i++)
			if(v[i] != 0){
				System.out.println(activitati.get(v[i] - 1));
				profit += activitati.get(v[i] - 1).profit;
			}
		
		System.out.println("Total: " + profit);
	}

}
