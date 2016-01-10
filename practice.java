import java.util.*;

public class practice{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random gen = new Random();
		double cheese = 0.0;
		Turtle yertle = new Turtle(0.05, 0.05, 0.0);
		yertle.goForward(0.94);
		yertle.x = 0.05;
		yertle.y = 0.05;
		yertle.turnLeft(90);
		yertle.goForward(0.94);
		yertle.x = 0.05;
		yertle.y = 0.05;
		for(int i = 0; i < 18; i ++){
			yertle.x += 0.05;
			yertle.y -= 0.01;
			yertle.goForward(0.02);
			yertle.y -= 0.01;
		}
		yertle.x = 0.05;
		yertle.y = 0.05;
		yertle.turnRight(90);
		for(int i = 0; i < 18; i ++){
			yertle.y += 0.05;
			yertle.x -= 0.01;
			yertle.goForward(0.02);
			yertle.x -= 0.01;
		}
		yertle.x = 0.06;
		yertle.y = 0.22;
		yertle.goForward(0.01);
		while(true){
			sc.next();
			yertle.turnLeft((double)(-30 + gen.nextInt(60)));
			if(yertle.angle > 85){
				yertle.angle = 85;
			}
			if(yertle.angle < -85){
				yertle.angle = -85;
			}
			yertle.goForward(0.01);
		}
	}
}