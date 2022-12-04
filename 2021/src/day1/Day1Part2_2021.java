package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import reusable.RepeatedCode;

public class Day1Part2_2021 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Measure time
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		// Read input
		try (BufferedReader br = obj.getInput(1, 2021)) {
			String line = br.readLine();
			int prev = 0;
			int res = 0;
			int count = 0;
			// Sync list
			List<Integer> list = new ArrayList<>();

			// Feeding 3 values
			for (int i = 0; i < 3; i++) {
				list.add(Integer.parseInt(line));
				line = br.readLine();
			}

			// Summing them up
			for (int i = 0; i < list.size(); i++) {
				res += list.get(i);
			}

			prev = res;

			// Sliding Windows
			while (line != null) {
				res = res - list.get(0) + Integer.parseInt(line);
				list.remove(0);
				list.add(Integer.parseInt(line));
				if (res > prev)
					count++;
				prev = res;
				line = br.readLine();
			}
			System.out.println(count);
		}
		System.out.println("Time taken: " + obj.endTime(startTime) + "ms");

	}
}
