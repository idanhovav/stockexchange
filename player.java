public class Player{
	String name;
	float networth;
	float cash;
	int[] stocks;

	public Player(String name, float cash){
		this.name = name;
		this.cash = cash;
		this.val = cash;
		stocks = new int[stockexchange.comp];
		for(int stock : stocks){
			stock = 0;
		}
	}

	public void calcNetworth(){
		float x = this.getCash();
		for(int i = 0; i < stocks.length; i++){
			x += (float)(stocks[i]) * stockexchange.comp[i].getVal();
		}
		this.networth = x;

	}
	public float getNetworth(){
		return this.networth;
	}
	public void buyStock(Company a){

		//get amount of stock


		if(amt > a.getStock()){
			System.out.println(amt + " stocks of " + a.getName() 
							   + " is not available.");
		}
		else if(( amt * a.getVal() ) > this.getCash()){
			System.out.println(this.getName() + " does not have enough cash" 
							   + " for this purchase.");
		}
		else{
			a.setStock(a.getStock() - amt);
			this.setCash(this.getCash() - ( amt * a.getVal() ));
			this.setStock(a.getPosn(), this.getStock(a.getPosn()) + amt);
			this.calcNetworth();
		}
	}
	public void sellStock(Company a){

		
		//get amount of stock
		

		if(amt > this.getStock(a.getPosn())){
			System.out.println(this.getName() + " does not have "
							   + amt + " stocks of " + a.getName() 
							   + ".");
		}
		else{
			buyStock(a, -amt);
		}	
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