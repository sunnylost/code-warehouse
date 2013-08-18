/*
You are dealing cards to a group of players. In this game, 
the cards are numbered 0-9 and have no distinguishing characteristics other than their numbers. 
A given deck may have many cards that share the same number. 
You are given an int numPlayers that represents the number of people playing. 
You are also given a String deck which contains the cards to be used (0th character is the top of the deck, 
and the last character is the bottom). You will deal the cards starting with player 0, then player 1, 
until you reach player numPlayers-1, dealing one card at a time. 
Then you repeat this process until the cards are exhausted. Cards are always dealt from the top of the deck. 

You will return a String[] that shows each of the players' cards in the order they were dealt 
(cards dealt earlier show up earlier in the particular String).
Player k's hand corresponds to element k of the returned String[]. 
One added constraint is that each player must be dealt the same number of cards. 
To enforce this constraint you will not deal extra cards that will unbalance the players' hands (cards held). 
In other words, if you have dealt to the last player, and don't have enough cards to deal another to every player, 
stop dealing. The returned String[] must contain exactly numPlayers elements, 
each element containing exactly the same number of characters.
*/
import java.util.Arrays;

public class CardCount {
	String[] dealHands(int numPlayers, String deck) throws Exception {
		int len = deck == null ? 0 : deck.length(),
			nums = 0,
			i = 0,
			j = 0;
		if(numPlayers < 1 || numPlayers > 50) {
			 throw new Exception("player's number must between 1 and 50.");
		}
		
		if(len > 50) {
			throw new Exception("deck's number must between 0 and 50.");
		}
		String[] cards = new String[numPlayers];
		for(; i < numPlayers; i++) {
			cards[i] = "";
		}
		i = 0;
		if(len == 0) {
			return cards;
		} else {
			nums = (int)Math.floor(len / numPlayers);
			len = numPlayers * nums;
			for(; i < nums; i++) {
				for(j = 0; j < numPlayers; j++) {
					cards[j] += String.valueOf(deck.charAt(i * numPlayers + j));
				}
			}
		}
		return cards;
	}
	
	public static void main(String[] args) {
		int numPlayers = 4;
		String deck = "111122223333";
		try {
			System.out.println(Arrays.toString(new CardCount().dealHands(numPlayers, deck)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
