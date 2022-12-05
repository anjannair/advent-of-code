package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import reusable.RepeatedCode;

public class Day2Part2_2021 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// Measure time
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		// Read input
		try (BufferedReader br = obj.getInput(2, 2021)) {
			String line = br.readLine();
			int hor = 0;
			int depth = 0;
			int aim = 0;
			while (line != null) {
				int value = Integer.parseInt(line.split(" ")[1]);
				if (line.startsWith("forward")) {
					hor += value;
					depth += aim * value;
				} else if (line.startsWith("down")) {
					aim += value;
				} else {
					aim -= value;
				}
				line = br.readLine();
			}
			System.out.println(Math.abs(hor * depth));
		}
		System.out.println("Time taken: " + obj.endTime(startTime) + "ms");

	}
}