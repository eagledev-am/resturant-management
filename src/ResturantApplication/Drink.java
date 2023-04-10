package ResturantApplication;


public class Drink  {

	private int numD;
	private String nameD;
	private String typeD;
	private float costD;

	
	public Drink() {
		this.numD = 0;
		this.nameD = "";
		this.typeD ="";
		this.costD = 0; 
	}
	
	public Drink(int numDrink, String nameD, String typeD, float costD) {
		super();
		this.numD = numDrink;
		this.nameD = nameD;
		this.typeD = typeD;
		this.costD = costD;
	}

	@Override
	public String toString() {
		return "Drink [numDrink=" + numD+ ", nameD=" + nameD + ", typeD=" + typeD + ", costD=" + costD + "]";
	}

	public void setNumD(int numD) {
		this.numD = numD;
	}
	
	public int getNumD() {
		return numD;
	}


	public String getNameD() {
		return nameD;
	}

	public void setNameD(String nameD) {
		this.nameD = nameD;
	}

	public String getTypeD() {
		return typeD;
	}

	public void setTypeD(String typeD) {
		this.typeD = typeD;
	}

	public float getCostD() {
		return costD;
	}

	public void setCostD(int costD) {
		this.costD = costD;
	}


}
