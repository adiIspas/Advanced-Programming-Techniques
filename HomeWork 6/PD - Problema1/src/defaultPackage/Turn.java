package defaultPackage;
import java.util.ArrayList;
import java.util.Collections;

public class Turn {
	
	static int[] inaltimeMaxima = new int[100];
	static int[] urmatorulCub = new int[100];
	
	static void algoritm(ArrayList<Cub> cuburi){
		// Sortam cuburile descrescator pentru a incepe constructia turnului din varf
		Collections.sort(cuburi);
		
		int _inaltimeMaxima = 0, _urmatorulCub = 0, turnuriMaxime = 0;
		
		// Initial toate turnurile contin cubul de la pozitia respectiva
		for(int i = 0; i < cuburi.size(); i++){
			inaltimeMaxima[i] = cuburi.get(i).latura;
		}
		
		// Ultimul cub nu mai poate fii cuplat cu niciun alt cub, deoarece ele sunt sortate descrescator
		urmatorulCub[cuburi.size() - 1] = -1;
		
		// Incepem parcurgerea vectorului de la sfarsit catre inceput. Incepem de la n - 2 deoarece avem nevoie 
		// de cel putin 2 cuburi pentru a construi un turn mai mare decat cele de pana acum.
		for(int i = cuburi.size() - 2; i >= 0; i--){
			_inaltimeMaxima = 0;
			_urmatorulCub = -1;
			
			// Pentru fiecare cub incepand de la cel selectat pana la ultimul cautam cea mai mare inaltime care o putem realiza.
			// Pana la cubul respectiv toate celelalte inaltimi au fost deja calculate, deci daca se va gasi un cub convenabil
			// se va adauga tot ce se poate construi cu el.
			for(int j = i + 1; j < cuburi.size(); j++){
				if(cuburi.get(i).latura > cuburi.get(j).latura && cuburi.get(i).culoare != cuburi.get(j).culoare && inaltimeMaxima[j] > _inaltimeMaxima){
					_inaltimeMaxima = inaltimeMaxima[j];
					_urmatorulCub = j;
				}
			}
			
			// Dupa verificarea tuturor cuburilor actualiza inaltimea maxima curenta si urmatorul cub de care legam cubul curent
			inaltimeMaxima[i] = _inaltimeMaxima + cuburi.get(i).latura;
			urmatorulCub[i] = _urmatorulCub;
			
		}
		
		// Cautam inaltimea maxima dupa terminarea procesului de actualizare si cubul de inceput al turnului
		_inaltimeMaxima = 0;
		_urmatorulCub = 0;
		for(int i = 0; i < cuburi.size(); i++){
			if(_inaltimeMaxima < inaltimeMaxima[i]){
				_inaltimeMaxima = inaltimeMaxima[i];
				_urmatorulCub = i;
			}
		}
		
		// Verificam cate turnuri cu inaltime maxima exista
		for(int i = 0; i < cuburi.size(); i++)
			if(inaltimeMaxima[i] == _inaltimeMaxima)
				turnuriMaxime++;
		
		System.out.println("Sunt " + turnuriMaxime + " turnuri cu inaltimea maxima " + _inaltimeMaxima);
		
		// Pentru fiecare cub cu inaltime maxima afisam constructia sa
		int index = 1;
		for(int i = 0; i < cuburi.size(); i++){
			if(inaltimeMaxima[i] == _inaltimeMaxima){
				_urmatorulCub = i;
				
				System.out.println("Turnul " + index);
				index++;
				do{
					System.out.println(cuburi.get(_urmatorulCub));
					_urmatorulCub = urmatorulCub[_urmatorulCub];
				}while(_urmatorulCub != -1);
				
			}
		}
	}
	
}
