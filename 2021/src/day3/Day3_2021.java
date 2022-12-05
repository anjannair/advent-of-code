package day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import reusable.RepeatedCode;

public class Day3_2021 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Measure time
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		// Read input
		try (BufferedReader br = obj.getInput(3, 2021)) {
			String line = br.readLine();
			String gamma = "";
			String epsilon = "";
			List<String> list = new ArrayList<>();
			List<String> list_oxy = new ArrayList<>();
			List<String> list_carb = new ArrayList<>();
			// Adding the whole thing to a List
			while (line != null) {
				if (line.equals(""))
					break;
				list.add(line);
				line = br.readLine();
			}
			// Counting and storing values in a list
			int one_count = 0;
			int zero_count = 0;
			for (int j = 0; j < list.size(); j++) {
				int value = Integer.parseInt(String.valueOf(list.get(j).charAt(0)));
				if (value == 1) {
					one_count++;
				} else {
					zero_count++;
				}
			}
			if (one_count > zero_count) {
				for (int j = 0; j < list.size(); j++) {
					int value = Integer.parseInt(String.valueOf(list.get(j).charAt(0)));
					if (value == 1) {
						list_oxy.add(list.get(j));
					} else {
						list_carb.add(list.get(j));
					}
				}
			} else {
				for (int j = 0; j < list.size(); j++) {
					int value = Integer.parseInt(String.valueOf(list.get(j).charAt(0)));
					if (value == 0) {
						list_oxy.add(list.get(j));
					} else {
						list_carb.add(list.get(j));
					}
				}

			}

			// Oxygen list
			for (int i = 1; i < list_oxy.get(0).length(); i++) {
				one_count = 0;
				zero_count = 0;
				for (int j = 0; j < list_oxy.size(); j++) {
					int value = Integer.parseInt(String.valueOf(list_oxy.get(j).charAt(i)));
					if (value == 1) {
						one_count++;
					} else {
						zero_count++;
					}
				}

				if (one_count > zero_count || one_count == zero_count) {
					for (int j = 0; j < list_oxy.size(); j++) {
						int value = Integer.parseInt(String.valueOf(list_oxy.get(j).charAt(i)));
						if (value == 0) {
							list_oxy.remove(j);
						}
					}
				} else {
					for (int j = 0; j < list_oxy.size(); j++) {
						int value = Integer.parseInt(String.valueOf(list_oxy.get(j).charAt(i)));
						if (value == 1) {
							list_oxy.remove(j);
						}
					}
				}
				if (list_oxy.size() == 1)
					break;
			}

			// Carbon list
			for (int i = 1; i < list_carb.get(0).length(); i++) {
				one_count = 0;
				zero_count = 0;
				for (int j = 0; j < list_carb.size(); j++) {
					int value = Integer.parseInt(String.valueOf(list_carb.get(j).charAt(i)));
					if (value == 1) {
						one_count++;
					} else {
						zero_count++;
					}
				}

				if (one_count > zero_count || one_count == zero_count) {
					for (int j = 0; j < list_carb.size(); j++) {
						int value = Integer.parseInt(String.valueOf(list_carb.get(j).charAt(i)));
						if (value == 1) {
							list_carb.remove(j);
						}
					}
				} else {
					for (int j = 0; j < list_carb.size(); j++) {
						int value = Integer.parseInt(String.valueOf(list_carb.get(j).charAt(i)));
						if (value == 0) {
							list_carb.remove(j);
						}
					}
				}
				if (list_carb.size() == 1)
					break;
			}
			System.out.println(list_carb);
			System.out.println(Integer.parseInt(list_oxy.get(0), 2) * Integer.parseInt(list_carb.get(0), 2));

		}
		System.out.println("Time taken: " + obj.endTime(startTime) + "ms");

	}
}