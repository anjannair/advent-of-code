package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import reusable.RepeatedCode;

public class Day1_2021 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Measure time
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		// Read input
		try (BufferedReader br = obj.getInput(1,2021)) {
			String line = br.readLine();
			int prev = Integer.parseInt(line);
			line = br.readLine();
			int count = 0;
			while (line != null) {
				if (line.equals(""))
					break;
				if (Integer.parseInt(line) > prev) {
					count++;
				}
				prev = Integer.parseInt(line);
				line = br.readLine();
			}
			System.out.println(count);
		}
		System.out.println("Time taken: " + obj.endTime(startTime) + "ms");

	}
}
