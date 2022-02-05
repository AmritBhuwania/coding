package geekTrust;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TameOfTrust {

	static Map<String, Map<Character, Integer>> kingdom = new HashMap<>();
	static Map<String, String> kingDomEmblemMap = kingdomEmblem();
	public static void main(String[] args) {

		System.out.println(-2%26);
		TameOfTrust tameOfTrust = new TameOfTrust();
		tameOfTrust.populateKingDomEmblem(kingdom);

		System.out.println((kingdom));

		String[][] input = {
				{"AIR", "OWLAOWLBOWLC"},
				{"LAND", "FDIXXSOKKOFBBMU"},
				{"ICE", "MOMAMVTMTMHTM"},
				{"WATER", "SUMMER IS COMING"},
				{"FIRE", "AJXGAMUTA"}
		};

		int count = 0;
		List<String> answers = new ArrayList<String>();
		answers.add("SPACE");

		for (int i = 0; i < input.length; i++) {
			boolean isAlly = tameOfTrust.isAlly(input[i][1], input[i][0]);
			if (isAlly) {
				count++;
				answers.add(input[i][0]);
			}
		}

		if (count >= 3) {

			System.out.println(answers);
		} else {
			System.out.println("NONE");
		}
	}

	private void populateKingDomEmblem(final Map<String, Map<Character, Integer>> kingdom) {

		Set<String> keySet = kingDomEmblemMap.keySet();

		Map<Character, Integer> characterCountMap;
		for (String key : keySet) {
			characterCountMap = new HashMap<Character, Integer>();
			String value = kingDomEmblemMap.get(key);

			for (char ch : value.toCharArray()) {
				characterCountMap.compute(ch, (k, v) -> v == null ? 1 : ++v);
			}

			kingdom.put(key, characterCountMap);
		}
	}

	private static Map<String, String> kingdomEmblem() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("SPACE", "Gorilla".toUpperCase());
		map.put("LAND", "Panda".toUpperCase());
		map.put("WATER", "Octopus".toUpperCase());
		map.put("ICE", "Mammoth".toUpperCase());
		map.put("AIR", "Owl".toUpperCase());
		map.put("FIRE", "Dragon".toUpperCase());
		return map;
	}

	private boolean isAlly(final String encodedMsg, final String kingdomName) {

		String emblem = kingDomEmblemMap.get(kingdomName);
		String decodedMsg = decipher(encodedMsg, emblem.length());

		System.out.println("Kingdom: " + kingdomName + ", emblem: " + emblem + ", decodedMsg: " + decodedMsg);

		boolean hasMsgContainEmblem = false;

		Map<Character, Integer> charMap = kingdom.get(kingdomName);

		for (char ch : decodedMsg.toCharArray()) {

			if (charMap.containsKey(ch)) {
				charMap.compute(ch, (k, v) -> v == 1 ? 0 : --v);

				if (charMap.get(ch) == 0) {
					charMap.remove(ch);
				}
			}

			if (charMap.isEmpty()) {
				hasMsgContainEmblem = true;
				break;
			}
		}

		return hasMsgContainEmblem;

	}

	private String decipher(final String encodedMsg, final int cipherLength) {
		return cipher(encodedMsg, 26 - (cipherLength % 26));
	}

	/*
	 * Function to cipher string given the cipher length
	 */
	private String cipher(final String encodedMsg, final int cipherLength) {

		char newChar;
		StringBuilder decodedString = new StringBuilder(encodedMsg.length());
		for (char ch : encodedMsg.toCharArray()) {

			newChar = (char)(((int)ch + cipherLength - 65) % 26 + 65);
			decodedString.append(newChar);
		}
		return decodedString.toString();
	}
}
