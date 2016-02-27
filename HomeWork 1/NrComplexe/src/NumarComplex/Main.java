package NumarComplex;

public class Main {

	public static void main(String[] args) {
		double realNr1 = 0, imaginarNr1 = 0, realNr2 = 0;
		int optiune = 0;
		
		realNr1 = Double.parseDouble(args[0]);
		imaginarNr1 = Double.parseDouble(args[1]);
		realNr2 = Double.parseDouble(args[2]);
		
		Complex x, y, z;
		x = new Complex(realNr1, imaginarNr1);
		y = new Complex(realNr2);
		z = new Complex();
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		optiune = Integer.parseInt(args[3]);
		
		switch(optiune){
		case 1:{
			System.out.print("Modului numarului " + x);
			System.out.println(" este " + x.modul());
		}break;
		
		case 2:{
			System.out.print("Conjucatul numarului " + x);
			System.out.print(" este " + x.conjucat());
		}break;
		
		case 3:{
			System.out.print("(" + x);
			System.out.print(") + (");
			System.out.print(y + ") = ");
			x.aduna(y);
			System.out.print(x);
		}break;
		
		case 4:{
			System.out.print("(" + x);
			System.out.print(") / (");
			System.out.print(y + ") = ");
			x.imparte(y);
			System.out.print(x);
		}break;
		
		case 5:{
			System.out.print("(" + x);
			System.out.print(") + (");
			System.out.print(y + ") = " + Complex.aduna(x, y));
		}break;
		
		}
		
	}

}
