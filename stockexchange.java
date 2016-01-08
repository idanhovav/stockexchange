import java.util.*;

public class stockexchange{
	public float time = 0.0;
	public int comp;
	public Company[] comps;

	//args has name, start cash, and # of companies.	
	public static void main(String[] args){
		Player p = new Player(args[0], (float) Integer.parseInt(args[1]));
		comp = Integer.parseInt(args[2]);
		comps = new Company[comp];
		String[] names = {"Google", "Apple", "Microsoft", "Tesla", "IBM",
				"Samsung", "GE", "Disney", "Wells Fargo", "Facebook"}
		Random gen = new Random();

		for(int i = 0; i < comps.length; i++){
			/*
			Initialization:
				- stock 1000 * (1-100)
				- div: .80 - 1.2 divided by period
				- period between 5 and 20
				- x between 1.0 and 10.0
				- y between 0.1 and 4.0
			*/
			int stock = (1000) * (1 + gen.nextInt(100));
			int period = 5 + gen.nextInt(16);
			float div = (0.8) + ((0.4)*(gen.nextFloat()));
			div /= (float) period;
			float x = 1.0 + (9.0 * gen.nextFloat());
			float y = 0.1 + (4.9 * gen.nextFloat());

			comps[i] = Company(names[i], stock, period, div, x, y, i);
		}

		//SETUP done.

		response = ask();
		while(response != "q"){
			for(Company c : comps){
				c.calcVal(time);
				c.giveDiv(p, time);
			}
			if(response == "p"){
				stockexchange.time += 1.0;
			}
			else{
				Company co = whichComp(comps);
				if(response == "b"){
					p.buyStock(co);
				}
				if(response == "s"){
					p.sellStock(co);
				}
			}

		}
		endgame(p);

		/*
		What if time is running until player pauses and then they can
		buy/sell.
		
		*/
	}
	public static String ask(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Round " + time + ": What do you want to do:");
		do{
			System.out.println("B: buy \nS: sell \nP: pass\nQ: quit");
			System.out.println("I want to: ");
			String r = sc.next().toLowerCase();
		}while(r != "b" && r != "s" && r != "p" && r != "q");
		sc.close()
		return r;


	}
	public static String whichComp(Company[] comps){
		Scanner sc = new Scanner(System.in);
		System.out.println("What company would you like to conduct "+
			"this transaction with?");
		for(Company a : comps){
			System.out.println(a.getName());
		}
		String r;
		while(True){
			System.out.println("Choice: ");
			r = sc.next();
			for(Company b : comps){
				if(b.getName() == r){
					return b;
				}
			}
			System.out.println("That's an invalid name. Choose again.");
		}


	}
	public static endgame(Player a){
		a.calcNetworth();
		System.out.println(a.getName() + " ended the game with a total value"
			+ " of $" + a.getNetworth() ", thanks for playing!");
		System.exit(0);
	}
}