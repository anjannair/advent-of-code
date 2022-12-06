package day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import reusable.RepeatedCode;

public class Day6Part2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		try (BufferedReader br = obj.getInput(6)) {
			HashMap<Character, Integer> map = new HashMap<>();
			String line = br.readLine();
			int res = 0;
			for (int i = 0; i < line.length() - 14; i++) {
				int count = 0;
				String temp = "";
				// Adding chars to the string
				for (int k = 0; k < 14; k++) {
					temp += "" + line.charAt(i + k);

				}
				// Running it through a HashMap
				for (int j = 0; j < 14; j++) {
					if (map.containsKey(temp.charAt(j))) {
						map.put(temp.charAt(j), map.get(temp.charAt(j)) + 1);
					} else {
						map.put(temp.charAt(j), 1);
					}
				}
				
				// Checking if values are greater than 1 (there could be a better method in doing so)
				for (int l = 2; l <= 14; l++) {
					if (map.containsValue(l)) {
						count++;
					}
				}
				
				// If all are unique
				if (count == 0) {
					res = i + 14;
					break;
				} else {
					map.clear();
				}
			}
			System.out.println(res);
			System.out.println("Time taken: " + obj.endTime(startTime) + "ms");
		}
	}
}
