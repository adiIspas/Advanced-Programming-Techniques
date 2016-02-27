import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Punct> puncte, puncte2;
	
	static double divide(int in, int sf){
		int n, m;
		double minim = Double.MAX_VALUE, minimSt = Double.MAX_VALUE, minimDr = Double.MAX_VALUE;
		n = sf - in;
		
		if(n == 1){
			return puncte.get(in).distanta(puncte.get(sf));
		}
		else
			if(n == 2){
				minim = puncte.get(in).distanta(puncte.get(in + 1));
				
				if(minim > puncte.get(in).distanta(puncte.get(sf)))
					minim = puncte.get(in).distanta(puncte.get(sf));
				else
					if(minim > puncte.get(in + 1).distanta(puncte.get(sf)))
						minim = puncte.get(in + 1).distanta(puncte.get(sf));				
				return minim;
			}
		
		m = (in + sf)/2;
		
		minimSt = divide(in,m);
		minimDr = divide(m + 1,sf);
		
		if(minimSt <= minimDr)
			minim = minimSt;
		else
			minim = minimDr;
		
		return Math.min(combina(minim,m), minim);
		
	}
	
	static double combina(double minim, int m){
		puncte2 = new ArrayList<Punct>();
		
		puncte2.add(puncte.get(m));
		
		for(int i = m + 1; i < puncte.size(); i++)
			if(puncte.get(m).x - puncte.get(i).x <= minim)
				puncte2.add(puncte.get(i));
		
		for(int i = m - 1; i >= 0; i--)
			if(puncte.get(m).x - puncte.get(i).x <= minim)
				puncte2.add(puncte.get(i));
		
		Collections.sort(puncte2,Punct.Y);
		
		if(puncte2.size() <= 7){
			for(int i = 0; i < puncte2.size(); i++){
				for(int j = i + 1; j < puncte2.size(); j++)
					if(puncte2.get(i).distanta(puncte2.get(j)) < minim)
						minim = puncte2.get(i).distanta(puncte2.get(j));
			}
		}
		else{
			for(int i = 0; i <= puncte2.size(); i++){
				for(int j = i + 1; j <= i + 7 && j < puncte2.size(); j++)
					if(puncte2.get(i).distanta(puncte2.get(j)) < minim)
						minim = puncte2.get(i).distanta(puncte2.get(j));
			}
		}
		
		return minim;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		double x, y;
		int n;
		
		puncte = new ArrayList<Punct>();
		
		File file = new File("F:\\Java WorkSpace\\Tema 5 - Problema 5\\in.txt");
		Scanner sc = new Scanner(file);
		
		n = sc.nextInt();
		for(int i = 0; i < n; i++){
			x = sc.nextDouble();
			y = sc.nextDouble();
			
			puncte.add(new Punct(x,y));
		}
		sc.close();
		
		Collections.sort(puncte);
		
		System.out.println(divide(0,puncte.size() - 1));

	}

}
