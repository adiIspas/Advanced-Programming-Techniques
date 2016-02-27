import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;



public class Main {
	
	static int []p = new int[100];
	static int []h = new int[100];
	
	static int Find(int u){
		int x = u;
		while(p[x] != x){
			x = p[x];
		}
		
		int y;
		while(p[u] != u){
			y = p[u];
			p[u] = x;
			u = y;
		}
		
		return x;
	}
	
	static void Union(int u, int v){
		u = Find(u);
        v = Find(v);
        
        p[u] = v; 
        //System.out.println(u + " " + v);  
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		int nrActivitati = 0, profit = 0, termen = 0, maxTermen = 0;
		Vector<Activitate> activitati = new Vector<Activitate>();
		Vector<Activitate> activitatiAlese = new Vector<Activitate>();
		
		File file = new File("F:\\Java WorkSpace\\Varianta2 - Pb3_v2\\in.txt");
		Scanner sc = new Scanner(file);
		
		nrActivitati = sc.nextInt();
		for(int i = 0; i < nrActivitati; i++){
			profit = sc.nextInt();
			termen = sc.nextInt();
			if(maxTermen < termen)
				maxTermen = termen;
			activitati.addElement(new Activitate(profit,termen));
		}
		sc.close();
		
		int []v = new int[nrActivitati];
		for(int i = 0; i < nrActivitati; i++)
			v[i] = -1;
		for(int i = 0; i <= maxTermen; i++)
			p[i] = i;
		
		Collections.sort(activitati);
	
		for(Activitate activitate:activitati){
			termen = activitate.termen;
			if(Find(termen) != 0){
//				for(int j = 0; j <= maxTermen; j++)
//					System.out.print(p[j] + " ");
//				System.out.println("\n");
				Union(Find(termen),Find(termen) - 1);
				activitatiAlese.add(activitate);
			}
			else
				break;
		}
		
		Collections.sort(activitatiAlese, Activitate.TERMEN);
		profit = 0;
		System.out.println("  Activitati\nProfit  Termen");
		for(Activitate activitate:activitatiAlese){
				System.out.println(activitate);
				profit += activitate.profit;
			}
		System.out.println("Total: " + profit);	
	}

}
