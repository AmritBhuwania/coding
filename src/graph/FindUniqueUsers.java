package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author amrit
 * Find the unique number of users present.
 * If either the user name or user email id is same, its a same user
 */

public class FindUniqueUsers {

	public static void main(String[] args) {

		String [] input = //{"abc,abc@gmail", "stu,xyz@gmail", "pqr,xyz@gmail", "pqr,pqr@gmail"}; 
			{"abc,abc@gmail", "stu,xyz@gmail", "pqr,xyz@gmail", "pqr,pqr@gmail", "stu,abc@gmail"};

		Map<String, List<String>> mailAdjList = new HashMap<>();
		Map<String, List<String>> nameAdjList = new HashMap<>();

		for (String str : input) {
			String[] ar = str.split(",");

			List<String> tempList = new ArrayList<String>();

			if (mailAdjList.containsKey(ar[0])) {
				tempList = mailAdjList.get(ar[0]);
			}

			tempList.add(ar[1].trim());
			mailAdjList.put(ar[0], tempList);

			tempList = new ArrayList<String>();

			if (nameAdjList.containsKey(ar[1])) {
				tempList = nameAdjList.get(ar[1]);
			}

			tempList.add(ar[0].trim());
			nameAdjList.put(ar[1], tempList);

		}

		System.out.println("mailAdjList: " + mailAdjList);
		System.out.println("nameAdjList: " + nameAdjList);

		// Keep a visited array set for the emails and names. If the email/name is already visited using some user,
		// its a duplicate
		Set<String> emailVis = new HashSet<String>();
		Set<String> nameVis = new HashSet<String>();

		List<String> emailList = new ArrayList<String>();

		// answer
		Set<String> uniqueNames = new HashSet<String>();

		Queue<String> q = new LinkedList<String>();

		Set<String> nameSet = mailAdjList.keySet();

		for (String name : nameSet) {

			if (!nameVis.contains(name)) {
				nameVis.add(name);
				uniqueNames.add(name);

				emailList = mailAdjList.get(name);

				for (String e : emailList) {
					if (!emailVis.contains(e))
						q.add(e);
				}

				while (!q.isEmpty()) {

					String mail = q.poll();
					emailVis.add(mail);

					List<String> names = nameAdjList.get(mail);
					for (String tempName : names) {
						if (!nameVis.contains(tempName)) {
							nameVis.add(tempName);
							emailList = mailAdjList.get(tempName);
	
							for (String e : emailList) {
								if (!emailVis.contains(e))
									q.add(e);
							}
						}
					}
				}
			}
		}
		
		System.out.println(uniqueNames);
		System.out.println(uniqueNames.size()); //answer
	}
}
