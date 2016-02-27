import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	static int v[] = new int[100];
	
	static boolean cauta(int st, int dr){
		int m;
		
		if(st >= dr)
			return v[st] == st;
		
		m = (dr + st) / 2;
		
		if(v[m] == m)
			return true;
		else
			if(v[m] > m)
				return cauta(st, m - 1);
			else
				return cauta(m + 1, dr);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("F:\\Java WorkSpace\\Tema 5 - Problema 1\\in.txt");
		Scanner sc = new Scanner(file);
		
		int n;
		n = sc.nextInt();
		
		for(int i = 1; i <= n; i++){
			v[i] = sc.nextInt();
		}
		
		System.out.println(cauta(1, n));
				
		sc.close();

	}

}
