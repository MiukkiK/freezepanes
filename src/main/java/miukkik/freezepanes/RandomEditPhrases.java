package miukkik.freezepanes;

import java.util.Random;

public class RandomEditPhrases {
	private static String[] phraseBank = new String[] {
			"Test edit phrase",
			"Kilroy was here",
			"Lorem ipsum dolor sit amet",
			"Test",
			"This is a long test phrase to fill up the table cell more"};
	private static Random randoms = new Random();
	static String get() {
		return phraseBank[randoms.nextInt(phraseBank.length)];
	}
}
