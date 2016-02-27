import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	static int piesa;
	
	static void acopera(int [][]m, int xa, int ya, int xb, int yb, int lg, int cg){
		
		if((int)Math.abs(xa - xb) == 1){
			
			// pozitia goala este in stanga sus
			if(lg % 2 == 0 && cg % 2 == 0){
				
				if(piesa % 10 == 0)
					piesa++;
				
				m[lg + 1][cg] = m[lg + 1][cg + 1] = m[lg][cg + 1] = piesa % 10; 
				piesa++;
			}
			else
				// pozitia goala in dreapta sus
				if(lg % 2 == 0 && cg % 2 == 1){
					
					if(piesa % 10 == 0)
						piesa++;
					
					m[lg][cg - 1] = m[lg + 1][cg - 1] = m[lg + 1][cg] = piesa % 10;
					piesa++;
				}
				else
					// pozitia goala in stanga jos
					if(lg % 2 == 1 && cg % 2 == 0){
						
						if(piesa % 10 == 0)
							piesa++;
						
						m[lg - 1][cg] = m[lg][cg + 1] = m[lg - 1][cg + 1] = piesa % 10;
						piesa++;
					}
					else
						// pozitia goala in dreapta jos
						if(lg % 2 == 1 && cg % 2 == 1){
							
							if(piesa % 10 == 0)
								piesa++;
							
							m[lg][cg - 1] = m[lg - 1][cg - 1] =  m[lg - 1][cg] = piesa % 10;
							piesa++;
						}
			return;
		}
		
		int xm = (xa + xb) / 2, ym = (ya + yb) / 2;
		// identificam in care subpatrat este pozitia goala
		
		// pozitia goala este in subpatratul stanga sus
		if(lg <= xm && cg <= ym){
			
			if(piesa % 10 == 0)
				piesa++;
			
			m[xm + 1][ym] = m[xm + 1][ym + 1] =  m[xm][ym + 1] = piesa % 10;
			piesa++;
			
			acopera(m, xa, ya, xm, ym, lg, cg); // 1
			acopera(m, xm + 1, ya, xb, ym, xm + 1, ym); // 4
			acopera(m, xm + 1, ym + 1, xb, yb, xm + 1, ym + 1); // 3
			acopera(m, xa, ym + 1, xm, yb, xm, ym + 1); // 2
		}
		else
		// pozitia goala este in subpatratul dreapta sus
			if(lg <= xm && cg >= ym){
				
				if(piesa % 10 == 0)
					piesa++;
				
				m[xm][ym] = m[xm + 1][ym] = m[xm + 1][ym + 1] = piesa % 10;
				piesa++;
				
				acopera(m, xa, ym + 1, xm, yb, lg, cg); // 2
				acopera(m, xa, ya, xm, ym, xm, ym); // 1
				acopera(m, xm + 1, ya, xb, ym, xm + 1, ym); // 4
				acopera(m, xm + 1, ym + 1, xb, yb, xm + 1, ym + 1); // 3
			}
			else
			// pozitia goala este in subpatratul stanga jos
			if(lg >= xm && cg <= ym){
				
				if(piesa % 10 == 0)
					piesa++;
				
				m[xm][ym] = m[xm][ym + 1] = m[xm + 1][ym + 1] = piesa % 10;
				piesa++;
				
				acopera(m, xm + 1, ya, xb, ym, lg, cg); // 4
				acopera(m, xa, ya, xm, ym, xm, ym); // 1
				acopera(m, xa, ym + 1, xm, yb, xm, ym + 1); // 2
				acopera(m, xm + 1, ym + 1, xb, yb, xm + 1, ym + 1); // 3
			}
			else
			// pozitia goala este in subpatratul dreapta jos
			if(lg >= xm && cg >= ym){
				
				if(piesa % 10 == 0)
					piesa++;
				
				m[xm][ym] = m[xm][ym + 1] = m[xm + 1][ym] = piesa % 10;
				piesa++;
				
				acopera(m, xm + 1, ym + 1, xb, yb, lg, cg); // 3  
				acopera(m, xa, ya, xm, ym, xm, ym); // 1
				acopera(m, xa, ym + 1, xm, yb, xm, ym + 1); // 2 
				acopera(m, xm + 1, ya, xb, ym, xm + 1, ym); // 4
			}
		
		}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		int n, lg, cg;
		piesa = 1;
		
		File file = new File("F:\\Java WorkSpace\\Tema 5 - Problema 2v2\\in.txt"); 
		Scanner sc = new Scanner(file);
		
		n = sc.nextInt();
		lg = sc.nextInt();
		cg = sc.nextInt();
		
		sc.close();
		
		n = (int) Math.pow(2, n);
		
		int [][]m = new int[n][n];
		
		m[lg][cg] = -1;
	
		acopera(m, 0, 0, n - 1, n - 1, lg, cg);
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				if(m[i][j] != -1)
					System.out.print(m[i][j] + " ");
				else
					System.out.print("x ");
			System.out.println();
		}

	}

}
