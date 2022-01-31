package test;

import java.util.HashMap;

public class PassByValue {

	public static void main(String[] args) {

		HashMap<String, String> myMap = new HashMap<>();
		myMap.put("k1", "v1");
		myMap.put("k2", "v2");

		addMoreKeysAndValues(myMap);
		
		System.out.println(myMap);
	}

	private static void addMoreKeysAndValues(HashMap<String, String> map) {

		map.put("k3", "v3");
		map = null;
		
	}

}
