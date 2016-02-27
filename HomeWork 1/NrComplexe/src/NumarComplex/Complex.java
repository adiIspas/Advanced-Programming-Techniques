package NumarComplex;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Complex {
	
	double real, imaginar;
	
	Complex(){
		real = 0;
		imaginar = 0;
	}
	
	Complex(double real){
		this.real = real;
		imaginar = 0;
	}
	
	Complex(double real, double imaginar){
		this.real = real;
		this.imaginar = imaginar;
	}
	
	double modul(){
		
		return sqrt(pow(real,2) + pow(imaginar,2));
	}
	
	Complex conjucat(){
		
		return new Complex(real, imaginar * (-1));
	}
	
	void aduna(Complex numar){
		real += numar.real;
		imaginar += numar.imaginar;
	}
	
	void imparte(Complex numar){
		real = (real * numar.real + imaginar * numar.imaginar) / (pow(numar.real,2) + pow(numar.imaginar,2));
		imaginar = (imaginar * numar.real - real * numar.imaginar) / (pow(numar.real,2) + pow(numar.imaginar,2));
	}
	
	static Complex aduna(Complex numar1, Complex numar2){
		
		numar1.aduna(numar2);
		
		return numar1;
	}
	
	public String toString(){
		if(imaginar >= 0)
			return real + " + " + imaginar + "i";
		else
			return real + " " + imaginar + "i";
	}

}
