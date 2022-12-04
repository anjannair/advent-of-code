package day2;

import reusable.RepeatedCode;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2Part2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		try (BufferedReader br = obj.getInput(2)) {
			String line = br.readLine();
			String[] elves = { "A", "B", "C" };
			String[] person = { "X", "Y", "Z" };
			int sum = 0;

			while (line != null) {
				// Checking for blank space
				if (!line.equals("")) {
					line.trim();
					String[] splitter = line.split(" ");
					int pos = Arrays.asList(elves).indexOf(splitter[0]);
					int pos2 = Arrays.asList(person).indexOf(splitter[1]);
					if (pos2 == 0) {
						if (pos == 0) {
							sum += 3;
						} else {
							sum += pos;
						}
					} else if (pos2 == 1) {
						sum += 3 + pos + 1;
					} else {
						if (pos == 2) {
							sum += 7;
						} else {
							sum += 6 + pos + 2;
						}
					}
				}

				line = br.readLine();
			}
			System.out.println(sum);
			System.out.println("Time taken: " + obj.endTime(startTime) + "ms");
		}
	}
}
