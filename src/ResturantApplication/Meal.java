package ResturantApplication;



public class Meal {
	
	private int numM;
	private String nameM;
	private String typeM;
	private float costM;
	
	public Meal() {
		this.numM = 0;
		this.nameM = "";
		this.typeM = "";
		this.costM = 0;
		
	}
	
    public Meal(int numM , String nameM , String typeM , float costM) {
    	this.numM = numM;
    	this.nameM = nameM;
    	this.typeM = typeM;
    	this.costM = costM;
    }

	public int getNumM() {
		return numM;
	}

	public void setNumM(int numM) {
		this.numM = numM;
	}

	public String getNameM() {
		return nameM;
	}

	public void setNameM(String nameM) {
		this.nameM = nameM;
	}

	public String getTypeM() {
		return typeM;
	}

	public void setTypeM(String typeM) {
		this.typeM = typeM;
	}

	public float getCostM() {
		return costM;
	}

	public void setCostM(int costM) {
		this.costM = costM;
	}

	@Override
	public String toString() {
		return "Meal [numM=" + numM + ", nameM=" + nameM + ", typeM=" + typeM + ", costM=" + costM + "]";
	}


}
