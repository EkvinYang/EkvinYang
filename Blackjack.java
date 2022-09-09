package blackjack;

import java.util.*;

public class Blackjack {
	static int win = 21;
	static int total = 0;
	static int bottotal = 0;
	static String hit = "hit";
	static String stand = "stand";

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> cards = new ArrayList<Integer>();
		for (int i = 0; i < 13; i++) {
			cards.add(i + 1);
		}
		Random rand = new Random();
		int firstcard = rand.nextInt(13) + 1;
		int secondcard = rand.nextInt(13) + 1;
		int botfirstcard = rand.nextInt(13) + 1;
		int botsecondcard = rand.nextInt(13) + 1;

		if (firstcard > 10) {
			firstcard = 10;
		}
		if (secondcard > 10) {
			secondcard = 10;
		}
		if (botfirstcard > 10) {
			botfirstcard = 10;
		}
		if (botsecondcard > 10) {
			botsecondcard = 10;
		}
		System.out.println("First card:" + firstcard);
		System.out.println("Second card:" + secondcard);
		
		boolean bot = false;
// figuring out the bot total
		total = firstcard + secondcard;
		System.out.println("Total:" + total);
		bottotal = botfirstcard + botsecondcard;
		while (bottotal < 16) {
			int nextcard = rand.nextInt(13) + 1;
			bottotal = bottotal + nextcard;
			if (bottotal > 21) {
				System.out.println("You won, cool");
				bot = true;
				break;
			}

		}
		String action = "";
		while (total < 21 && !bot) {
			action = s.next();
			if (action.toLowerCase().equals(hit)) {
				int nextcard2 = rand.nextInt(13) + 1;			
				if (nextcard2 > 10) {
					nextcard2 = 10;
				}
				System.out.println("Card:" + nextcard2);
				total = total + nextcard2;
				System.out.println("Total:" +total);
				if (total > 21) {
					System.out.println("You were higher than 21 you lost");
				} else if (total == 21) {
					System.out.println("You got 21 wow");
				}
				
			}
			if (action.toLowerCase().equals(stand)) {
				if (total > bottotal) {
					System.out.println("You won");
					System.out.println("The bot got " + bottotal);
					break;
				} else if (total < bottotal) {
					System.out.println("You lost");
					System.out.println("The bot got " + bottotal);
					break;
				} else {
					System.out.println("It's a tie :O");
					System.out.println("You both got " + bottotal);
					break;
				}
			}

		}
	}
}	
