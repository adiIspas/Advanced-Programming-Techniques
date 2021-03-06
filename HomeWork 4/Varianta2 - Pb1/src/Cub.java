
class Cub implements Comparable<Cub>{
	int latura;
	int culoare;
	
	Cub(int latura, int culoare){
		this.latura = latura;
		this.culoare = culoare;
	}

	@Override
	public int compareTo(Cub cub) {
		
		return this.latura < cub.latura ? 1 : -1;
	}
	
	public String toString(){
		return "" + latura + " / " + culoare;
	}
	
	public int getCuloare(){
		return culoare;
	}
	
	public int getLatura(){
		return latura;
	}
}
