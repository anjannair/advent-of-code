package day1;

import reusable.RepeatedCode;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1Part2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		// Read input
		try (BufferedReader br = obj.getInput(1)) {
			String line = br.readLine();
			ArrayList<Integer> list = new ArrayList<>();
			int sum = 0;

			while (line != null) {
				// Checking for blank space
				if (line.equals("")) {
					// Check max
					list.add(sum);
					sum = 0;
					line = br.readLine();
					continue;
				} else {
					// summation
					sum += Integer.parseInt(line);
				}

				line = br.readLine();
			}
			Collections.sort(list);
			System.out.println(list.get(list.size() - 1) + list.get(list.size() - 2) + list.get(list.size() - 3));
			System.out.println("Time taken: " + obj.endTime(startTime) + "ms");
		}

	}
}
