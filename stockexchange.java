public class stockexchange{
	public float time = 0.0;
	public int comp;
	public Company[] comps;
	public static void main(String[] args){
		Player p = new Player(args[0], (float) Integer.parseInt(args[1]));
		comp = Integer.parseInt(args[2]);
		comps = new Company[comp];
		String[] names = {"Google", "Apple", "Microsoft", "Tesla", "IBM",
				"Samsung", "GE", "Disney", "Wells Fargo", "Facebook"}
		for(int i = 0; i < comps.length; i++){
			/*
			Needed for initialization:
				- random int of stock
				- random float of stock value
				- random float of div value
				- random int of div period
				- 3 random float sinusoid variators
				- i
			*/
			comps[i] = Company(names[i], 100, 0.45, 0.25, 3, 0.5,0.4,0.8, i);
		}
		response = ask();
		while(response != "q"){
			for(Company c : comps){
				c.calcVal(time);
				c.giveDiv(p, time);
			}
			if(response == "p"){
				time += 1.0;
			}
			else{
				co = whichComp(comps);
			}
			/*	Gameplay options:
			- quit
			- buy stock
			- sell stock
			- pass
			Game TODO:
			- update stock values
			- pay dividends

			*/
		}
		endgame(p);
		//args has name, start cash, and # of companies.
		
		/*
		Gameplan: stock exchange has the main method, a setup method.
		Setup sets up the game with a player instance, company instances, and 
		starting round 0.
		Main method plays a round in a while loop. Buying/selling, 
		updating stock values, quit, pay dividends. Takes in user input.
		What if time is running until player pauses and then they can
		buy/sell.

		Create list of names for companies to be chosen from randomly at
		
		*/
	}
	public static String ask(){

	}
	public static String whichComp(Company[] comps){

	}
	public static endgame(Player a){
		a.calcNetworth();
		System.out.println(a.getName() + " ended the game with a total value"
			+ " of $" + a.getNetworth() ", thanks for playing!");
	}
}