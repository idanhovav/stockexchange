/*
TODO: 
Add info at the beginning of each round, maybe with a time delay.

change everything from float to double goddamit.

graphics.

Play against computer?
*/

/*
What if time is running until player pauses and then they can
buy/sell.
		
*/


import java.util.*;

public class stockexchange{

	//args has name, start cash, and # of companies.	
	public static void main(String[] args){
		float time = (float) 1.0;
		int comp = Integer.parseInt(args[2]);
		Company[] comps = new Company[comp];
		int cash = Integer.parseInt(args[1]);
		Scanner sc = new Scanner(System.in);
		Turtle yertle = new Turtle(2.0, 2.0, 2.0);
		
		Player p = new Player(args[0], (float) cash, comp);

		String[] names = {"Google", "Apple", "Microsoft", "Tesla", "IBM",
				"Samsung", "HP", "Disney", "Wells Fargo", "Facebook"};
		
		Random gen = new Random();

		for(int i = 0; i < comps.length; i++){
			/*
			Initialization:
				- stock 1000 * (1-100)
				- div: .80 - 1.2 divided by period
				- period between 5 and 20
				- x between 1.0 and 10.0
				- y between 0.1 and 4.0
				- z between 1.0 and 2.0
			*/
			int stock = (1000) * (1 + gen.nextInt(100));
			int period = 5 + gen.nextInt(16);
			float div = (float) ((0.8) + ((0.4)*(gen.nextFloat())));
			div /= (float) period;
			float w = (float)(3.0 * gen.nextFloat());
			float x = (float)(1.0 + (9.0 * gen.nextFloat()));
			float y = (float)(0.1 + (4.9 * gen.nextFloat()));
			float z = (float)(1.0 + (gen.nextFloat()));

			comps[i] = new Company(names[i], stock, period, div, w, x, y, z, i);
		}

		//SETUP done.

		String response;
		while(true){
			for(Company c : comps){
				c.calcVal(time);
				c.giveDiv(p, time);
			}
			p.calcNetworth(comps);
			response = "";
			do{
				roundAnnouncements(p, comps, time);
				response = ask(time, sc);
				if(response.equals("q")){
					p.calcNetworth(comps);
					endgame(p, sc);
				}
				else if(!response.equals("n")){
					Company co = whichComp(comps, sc);
					if(response.equals("b")){
						p.buyStock(co, sc);
					}
					if(response.equals("s")){
						p.sellStock(co, sc);
					}
				}
			}while(!response.equals("n"));
			yertle.goForward(0.3);
			yertle.turnLeft(0.7);
			time += 1.0;
			p.calcNetworth(comps);
			endingAnnouncements(p);
		}
	}



	public static String ask(float time, Scanner sc){
		System.out.println("Round " + time + ": What do you want to do:");
		String r;
		do{
			System.out.println("B: Buy \nS: Sell \nN: Next Round\nQ: Quit");
			System.out.print("I want to: ");
			r = sc.next().toLowerCase();
		}while(!r.equals("b") && !r.equals("s") && !r.equals("n") &&
			   !r.equals("q"));
		return r;

	}
	public static Company whichComp(Company[] comps, Scanner sc){
		System.out.println("What company would you like to conduct "+
			"this transaction with?");
		for(Company a : comps){
			System.out.println(a.getName());
		}
		String r;
		while(true){
			System.out.print("Enter the first letter of the company: ");
			//issue right here. not allowing for input. check scanner
			//documentation
			r = sc.next().toLowerCase();
			for(Company b : comps){
				if(b.getName().substring(0,1).toLowerCase().equals(r)){
					return b;
				}
			}
			System.out.println("That's an invalid name. Choose again.");
		}
	}

	public static void roundAnnouncements(Player p, Company[] comps, float t){
		System.out.println("\n\nThis is round " + (int) t + ".");
		personalAnnouncements(p, comps);
		System.out.println("\n");
		companyAnnouncements(comps);
		System.out.println("\n");
	}
	public static void personalAnnouncements(Player p, Company[] comps){
		System.out.println(p.getName() + " has a networth of $"
			+ p.getNetworth() + ".");
		System.out.println(p.getName() + "'s Portfolio:");
		for(int i = 0; i < comps.length; i++){
			System.out.println(comps[i].getName() + ": " + p.getStock(i) 
				+ " stock owned.");
		}
		System.out.println("Cash available: $" + p.getCash());

	}

	public static void companyAnnouncements(Company[] comps){
		System.out.println("Company | Stock Value | Stock Available");
		for(Company a : comps){
			System.out.println(a.getName() + " | " + a.getVal() + 
				" | " + a.getStock());
		}
	}

	public static void endingAnnouncements(Player p){
		System.out.println(p.getName() + " has finished this round.");
	}
	public static void endgame(Player a, Scanner sc){
		System.out.println(a.getName() + " ended the game with a total value"
			+ " of $" + a.getNetworth() + ", thanks for playing!");
		sc.close();
		System.exit(0);
	}
}