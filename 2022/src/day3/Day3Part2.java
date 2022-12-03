package day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3Part2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		long startTime = System.nanoTime();
		try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/2022/src/day3/day3input.txt"))) {
			String line = br.readLine();
			ArrayList<String> list = new ArrayList<>();
			ArrayList<Character> commons = new ArrayList<>();
			int count = 0;
			int sum = 0;

			do {
				if (count > 0) {
					line = br.readLine();
				}
				if (count % 3 == 0 && count > 0) {
					for (int i = 0; i < list.get(0).length(); i++) {
						for (int j = 0; j < list.get(1).length(); j++) {
							if (list.get(0).charAt(i) == list.get(1).charAt(j)) {
								commons.add(list.get(0).charAt(i));
							}
						}
					}
					int dob_count = 0;
					for (int i = 0; i < list.get(2).length(); i++) {
						for (int j = 0; j < commons.size(); j++) {
							if (list.get(2).charAt(i) == commons.get(j)) {
								char store = list.get(2).charAt(i);
								dob_count++;
								if (Integer.valueOf((char) store) >= 97 && Integer.valueOf((char) store) <= 122) {
									sum += (store - 96);
								} else {
									sum += (store - 38);
								}
								break;
							}
						}
						if (dob_count > 0) {
							break;
						}
					}
					list.clear();
					commons.clear();
				}
				list.add(line);
				count++;
			} while (line != null);
			System.out.println(sum);
			long endTime = System.nanoTime();
			double totalTime = (endTime - startTime) / (double) 1000000;
			System.out.println("Time taken: " + totalTime + "ms");
		}
	}
}