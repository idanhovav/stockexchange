public class stockexchange{
	public float time = 0;
	public int comp;
	public Company[] comps;
	public static void main(String[] args){
		Player p = new Player(args[0], (float) Integer.parseInt(args[1]));
		comp = Integer.parseInt(args[2]);
		
		//args has name, start cash, and # of companies.
		
		/*
		Gameplan: stock exchange has the main method, a setup method.
		Setup sets up the game with a player instance, company instances, and 
		starting round 0.
		Main method plays a round in a while loop. Buying/selling, 
		updating stock values, quit, pay dividends. Takes in user input.
		What if time is running until player pauses and then they can
		buy/sell.

		*/
	}
}