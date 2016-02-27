/**
 * Input: O multime de numere si un numar x;
 * Output: 3 numere care au suma x;
 * 
 * a, b, c: Cele 3 numere cautate;
 * found: O variabila care ne spune daca am gasit numerele cu propietatea ceruta;
 * start, end: Variabile in care retinem inceputul si sfarsitul unei submultimi din vector pe care operam la un moment anume;
 * Functia algorithm() primeste ca parametru vectorul de numere si suma pe care trebuie sa o realizeze cele 3 numere
 */

package suma;

import java.util.Arrays;

public class Alg3Sum {
	static void algorithm(int []numbers, int sum){
		int a, b, c;
		int start, end;
		boolean found = false;
		
		// sortam vectorul
		Arrays.sort(numbers);
		
		// pentru fiecare numar din vector scadem sum/3 pentru a cauta numere ce dau suma 0
		for(int i = 0; i < numbers.length; i++)
			numbers[i] -= sum/3;
		
		// parcurgem vectorul mai putin pana la ultimele 3 elemente deoarece la ultimul pas vom ajunge ca a sa fie antepenultimul element
		// b penultimul element, iar c ultimul element
		for(int i = 0; i < numbers.length - 3; i++){
			
			// setam a primul element, start este indicele pentru urmatorul element care va merge in b, iar end indicele pentru ultimul
			// element care va merge in c
			a = numbers[i];
			start = i + 1;
			end = numbers.length - 1;
			
			// atata timp cat start nu trece de end si invers cautam numere, incremetand sau decremetand start si end
			// dupa cum urmeaza
			while(start < end){
				
				// cum am mentionat anterior b pleaca ca urmatorul element lui a, iar c primeste valoarea ultimului element
				b = numbers[start];
				c = numbers[end];
				
				// in cazul in care aceasta este o combinatie buna (egala cu restul impartirii sum la 3) o afisam
				if((a + b + c) == sum%3){
					
					// afisam cu sum/3 deoarece am scazut la inceput sum/3 din fiecare element pentru a putea cauta numere
					// care ne dau adunate valoarea 0
					System.out.println((a + sum/3) + " " + (b + sum/3) + " " + (c + sum/3));
					
					
					// found primeste valoarea true ca urmare a faptului ca am gasit cel putin o pereche
					found = true;
					
					// continuam sa parcurgem vectorul
					start++;
					end--;
				}
				else
					// in cazul in care suma lor este prea mare incercam cu un element mai mic, astfel scadeam indicele end
					if((a + b + c) > 0)
						end--;
					else
						// in cazul in care suma lor este prea mica incercam cu un element mai mare, astfel crestem indicele start
						start++;
			}
		}
		
		// in cazul in care nu s-a gasit nicio pereche care sa indeplineasca conditia ceruta, afisam un mesaj corespunzator
		if(!found)
			System.out.println("Nu exista!");
	}
}
