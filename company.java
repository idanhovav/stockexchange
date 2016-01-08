/*
Companies have a stock value that is based on their company value divided
by the number of stocks they have.
Companies can pay dividends.
Company value can go up or down randomly (sin).

Variables x,y,z used for describing sin functions.

*/

public class Company{
	String name;
	int stock;
	float val;
	int period; //period of dividend payments
	float div;
	float x,y;
	int posn;

	public Company(String name, int stock, int period, float div,
				   float a, float b, int posn){
		this.name = name;
		this.stock = stock;
		this.period = period;
		this.div = div;
		x = a;
		y = b;
		this.posn = posn;
		this.val = 0; //calcVal(0.0);
	}

	public void calcVal(float t){
		this.val = x * (float) (Math.sin(y*t));
	
	}
	public float getVal(){
		return this.val;
	}
	
	public void giveDiv(Player a, float time){
		if(time % this.period == 0 && time != 0.0){
			float total = (this.div) * (float) (a.getStock(this.posn));
			System.out.println(this.name + " is giving out dividends of " 
							   + this.div + " for each stock." + a.getName()
							   + " receives $" + total + ".");
			a.setCash(a.getCash() + total);
		}
	
	}

	public String getName(){
		return this.name;
	}
	public int getStock(){
		return this.stock;
	}
	public void setStock(int a){
		this.stock = a;
	}
	public float getDiv(){
		return this.div;
	}
	public void setDiv(float a){
		this.div = a;
	}
	public int getPosn(){
		return this.posn;
	}
	public void setPosn(int a){
		this.posn = a;
	}
}