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
	float div; //percentage of stock value to give as div.
	float x,y,z;
	int posn;

	public Company(String name, int stock, float val, float div,
				   float a, float b, float c, int posn){
		this.name = name;
		this.stock = stock;
		this.val = val;
		this.div = div;
		x = a;
		y = b;
		z = c;
		this.posn = posn;

	}

	public void calcVal(){
		float t = stockexchange.time;
		System.out.println(t);
		this.val = x*(Math.sin((y*t)/z));
	
	}
	
	public void giveDiv(int amount, float price){
		//IDK bruh
	
	}
}