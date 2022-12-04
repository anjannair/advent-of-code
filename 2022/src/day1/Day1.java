package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import reusable.RepeatedCode;

public class Day1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Measure time
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		// Read input
		try (BufferedReader br = obj.getInput(1)) {
			String line = br.readLine();
			int sum = 0;
			int res = 0;

			while (line != null) {
				// Checking for blank space
				if (line.equals("")) {
					// Check max
					res = Math.max(sum, res);
					sum = 0;
					line = br.readLine();
					continue;
				} else {
					// summation
					sum += Integer.parseInt(line);
				}

				line = br.readLine();
			}
			System.out.println(res);
		}
		System.out.println("Time taken: " + obj.endTime(startTime) + "ms");

	}
}
