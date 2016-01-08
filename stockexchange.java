/*
TODO: 
Add info at the beginning of each round, maybe with a time delay.

change everything from float to double goddamit.

graphics.
*/

/*
What if time is running until player pauses and then they can
buy/sell.
		
*/


import java.util.*;

public class stockexchange{

	//args has name, start cash, and # of companies.	
	public static void main(String[] args){
		float time = (float) 0.0;
		int comp = Integer.parseInt(args[2]);
		Company[] comps = new Company[comp];
		int cash = Integer.parseInt(args[1]);
		
		Player p = new Player(args[0], (float) cash, comp);

		String[] names = {"Google", "Apple", "Microsoft", "Tesla", "IBM",
				"Samsung", "GE", "Disney", "Wells Fargo", "Facebook"};
		
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
			float div = (float) ((0.8) + ((0.4)*(gen.nextFloat())));
			div /= (float) period;
			float x = (float)(1.0 + (9.0 * gen.nextFloat()));
			float y = (float)(0.1 + (4.9 * gen.nextFloat()));

			comps[i] = new Company(names[i], stock, period, div, x, y, i);
		}

		//SETUP done.

		String response = ask(time);
		while(response != "q"){
			for(Company c : comps){
				c.calcVal(time);
				c.giveDiv(p, time);
			}
			companyAnnouncements(comps);
			if(response == "p"){
				time += 1.0;
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
			p.calcNetworth(comps);
			personalAnnouncements(p);
			response = ask(time);
		}
		endgame(p);
	}



	public static String ask(float time){
		Scanner sc = new Scanner(System.in);
		System.out.println("Round " + time + ": What do you want to do:");
		String r = "p";
		do{
			System.out.println("B: buy \nS: sell \nP: pass\nQ: quit");
			System.out.println("I want to: ");
			r = sc.next().toLowerCase();
			System.out.println(r);
		}while(!r.equals("b") && !r.equals("s") && !r.equals("p") &&
			   !r.equals("q"));
		sc.close();
		return r;

	}
	public static Company whichComp(Company[] comps){
		Scanner sca = new Scanner(System.in);
		System.out.println("What company would you like to conduct "+
			"this transaction with?");
		for(Company a : comps){
			System.out.println(a.getName());
		}
		String r;
		while(true){
			System.out.println("Choice: ");
			//issue right here. not allowing for input. check scanner
			//documentation
			r = sca.next();
			for(Company b : comps){
				if(b.getName() == r){
					sca.close();
					return b;
				}
			}
			System.out.println("That's an invalid name. Choose again.");
		}
	}

	public static void personalAnnouncements(Player p){
		System.out.println(p.getNetworth());
	}

	public static void companyAnnouncements(Company[] comps){
		for(Company a : comps){
			System.out.println(a.getName() + " -:- " + a.getVal());
		}
	}

	public static void endgame(Player a){
		System.out.println(a.getName() + " ended the game with a total value"
			+ " of $" + a.getNetworth() + ", thanks for playing!");
		System.exit(0);
	}
}