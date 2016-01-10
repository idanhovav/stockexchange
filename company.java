import java.util.*;


public class Company{
	String name;
	int stock;
	float val;
	int period; //period of dividend payments
	float div;
	float w,x,y,z;
	int posn;
	float delta;

	public Company(String name, int stock, int period, float div,
				   float a, float b, float c, float d, int posn){
		this.name = name;
		this.stock = stock;
		this.period = period;
		this.div = div;
		w = a;
		x = b;
		y = c;
		z = d;
		this.posn = posn;
		Random gen = new Random();
		this.val = 0;
		this.delta = 0;
	}

	public void calcVal(float t){
		this.val = x * (float) (z + (Math.sin(w + (y*t))));
	
	}
	public float getVal(){
		return this.val;
	}
	public void calcDelta(float t){
		this.delta = y * (float) Math.cos(w + (y*t));
	}
	public float getDelta(){
		return this.delta;
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