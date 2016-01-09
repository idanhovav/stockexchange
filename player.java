import java.util.*;


public class Player{
	String name;
	float networth;
	float cash;
	int[] stocks;

	public Player(String name, float cash, int comp){
		this.name = name;
		this.cash = cash;
		stocks = new int[comp];
		for(int stock : stocks){
			stock = 0;
		}
		this.networth = this.cash;
	}

	public void calcNetworth(Company[] comps){
		float x = this.getCash();
		for(int i = 0; i < stocks.length; i++){
			x += (float)(getStock(i)) * comps[i].getVal();
		}
		this.networth = x;

	}
	public float getNetworth(){
		return this.networth;
	}
	public void buyStock(Company a, Scanner sc){
		int amt = getAmt(a, sc);
		if(amt > a.getStock()){
			System.out.println(amt + " stocks of " + a.getName() 
							   + " is not available.");
		}
		else if(( amt * a.getVal() ) > this.getCash()){
			System.out.println(this.getName() + " does not have enough cash" 
							   + " for this purchase.");
		}
		else{
			transaction(a, amt);
		}
	}
	public void sellStock(Company a, Scanner sc){
		int amt = getAmt(a, sc);
		if(amt > this.getStock(a.getPosn())){
			System.out.println(this.getName() + " does not have "
							   + amt + " stocks of " + a.getName() 
							   + ".");
		}
		else{
			transaction(a, -amt);
		}	
	}
	private void transaction(Company a, int amt){
			a.setStock(a.getStock() - amt);
			this.setCash(this.getCash() - ( amt * a.getVal() ));
			this.setStock(a.getPosn(), this.getStock(a.getPosn()) + amt);
	}
	public int getAmt(Company a, Scanner sc){
		System.out.println("How much of " + a.getName() + "'s stock? Their " 
			+ "value is " + a.getVal() +" per stock and " + this.getName()
			+ " owns " + getStock(a.getPosn()) + " stocks.");
		System.out.print("Amount: ");
		return Integer.parseInt(sc.next());
	}

	public int getStock(int i){
		return stocks[i];
	}

	public void setStock(int i, int j){
		stocks[i] = j;
	}

	public float getCash(){
		return cash;
	}

	public void setCash(float cash){
		this.cash = cash;
	}

	public String getName(){
		return this.name;
	}

	
}