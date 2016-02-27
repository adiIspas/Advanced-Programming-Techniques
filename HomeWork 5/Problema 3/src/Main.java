import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	private static ArrayList<Integer> a1;
	private static ArrayList<Integer> a2;
	
	static int cauta(int st1, int dr1, int st2, int dr2, int k){
		
		int n = dr1 - st1 + dr2 - st2;
		int a, b;
		int uk, lk;
		
		if(n <= 2){
			ArrayList<Integer> x = new ArrayList<Integer>();
			
			x.add(a1.get(st1));
			x.add(a1.get(dr1));
			x.add(a2.get(st2));
			x.add(a2.get(dr2));
			
			Collections.sort(x);
			
			return x.get(k - 1);	
		}
		
		if(k == 1)
			return a1.get(0) >= a2.get(0) ? a2.get(0) : a1.get(0); 
		
		if(k % 2 == 0)
			uk = lk = k /2;
		else
		{
			uk = k/2+1;
			lk = k/2;
		}
		
		a = a1.get(st1 + lk - 1);
		b = a2.get(st2 + uk - 1);
			
		if(a == b)
			return a;
		
		if(a > b)
			return cauta(st1, st1 + lk - 1, st2 + uk, st2 + k-1, lk);
		else
			return cauta(st1 + lk, st1 + k-1, st2, st2 + uk-1, uk);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		int n = 0, m = 0, k = 0;
		
		a1 = new ArrayList<Integer>();
		a2 = new ArrayList<Integer>();
		
		File file = new File("F:\\Java WorkSpace\\Tema 5 - Problema 3\\in.txt");
		Scanner sc = new Scanner(file);
	
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
				
	    for(int i = 0; i < n; i++){
	    	a1.add(sc.nextInt());
		}
	   	
		for(int i = 0; i < m; i++){
			a2.add(sc.nextInt());
		}
		
		for(int i = n - 1; i < 2*n; i++)
			a1.add(Integer.MAX_VALUE);
		
		for(int i = m - 1; i < 2*m; i++)
			a2.add(Integer.MAX_VALUE);
			
		int rezultat;
		rezultat = cauta(0, n - 1, 0, m - 1, k);
		
		System.out.println(rezultat);
		
		//for(int i = 0; i < a2.size(); i++)
			//System.out.print(a2.get(i) + " ");
		
		
		
		sc.close();

	}

}
