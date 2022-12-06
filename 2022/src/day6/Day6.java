package day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import reusable.RepeatedCode;

public class Day6 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		try (BufferedReader br = obj.getInput(6)) {
			HashMap<Character, Integer> map = new HashMap<>();
			String line = br.readLine();
			String temp = "";
			int res = 0;
			
			for (int i = 0; i < line.length() - 4; i++) {
				// Adding the 4 characters to the string
				temp = line.charAt(i) + "" + line.charAt(i + 1) + "" + line.charAt(i + 2) + "" + line.charAt(i + 3);
				
				for (int j = 0; j < 4; j++) {
					if (map.containsKey(temp.charAt(j))) {
						map.put(temp.charAt(j), map.get(temp.charAt(j)) + 1);
					} else {
						map.put(temp.charAt(j), 1);
					}
				}
				
				// Checking for similar values
				if (!map.containsValue(2) && !map.containsValue(3)) {
					res = i + 4;
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
