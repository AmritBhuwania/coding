package geekTrust;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Geektrust {

	static Map<String, Map<Character, Integer>> kingdom = new HashMap<>();
	static Map<String, String> kingDomEmblemMap = kingdomEmblem();

	private static int minAlliesSupport = 3;

	public static void main(String[] args) {

		Geektrust geekTrust = new Geektrust();

		List<String []> input = geekTrust.parseInputFile(args);

		geekTrust.populateKingdomEmblem();

		Set<String> answers = new LinkedHashSet<>();
		answers.add("SPACE");

		for (int i = 0; i < input.size(); i++) {
			boolean isAlly = geekTrust.isAlly(input.get(i)[1], input.get(i)[0]);
			if (isAlly) {
				answers.add(input.get(i)[0]);
			}
		}

		geekTrust.displayOutput(answers);
	}

	private void displayOutput(Set<String> answers) {

		List<String> finalAnswer = new ArrayList<String>(answers);
		if (answers.size() > minAlliesSupport) {
			for (int i = 0; i < answers.size(); i++) {

				System.out.print(finalAnswer.get(i));
				if (i != answers.size()-1) {
					System.out.print(" ");
				}
			}

		} else {
			System.out.println("NONE");
		}

	}

	private List<String []> parseInputFile(String[] args) {

		List<String []> list = new ArrayList<>();


		if (args.length < 1) {
			System.out.println("No input file passed. Please pass an input file.");
			System.out.println("Usage: java GeekTrust 'input.txt'");
			return list;
		}

		File file = new File(args[0]);
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

			String inputLine;

			while ((inputLine = bufferedReader.readLine()) != null) {

				String [] lineArr = inputLine.split(" ", 2);
				list.add(lineArr);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	private void populateKingdomEmblem() {

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

		//System.out.println("Kingdom: " + kingdomName + ", emblem: " + emblem + ", decodedMsg: " + decodedMsg);

		boolean doMsgContainEmblem = false;

		Map<Character, Integer> charMap = kingdom.get(kingdomName);

		for (char ch : decodedMsg.toCharArray()) {

			if (charMap.containsKey(ch)) {
				charMap.compute(ch, (k, v) -> v == 1 ? 0 : --v);

				if (charMap.get(ch) == 0) {
					charMap.remove(ch);
				}
			}

			if (charMap.isEmpty()) {
				doMsgContainEmblem = true;
				break;
			}
		}

		return doMsgContainEmblem;

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
