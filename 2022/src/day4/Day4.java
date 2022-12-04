package day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import reusable.RepeatedCode;

public class Day4 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		try (BufferedReader br = obj.getInput(4)) {
			String line = br.readLine();
			int res = 0;
			while (line != null) {
				String[] arr = line.split(",");
				// Keeping count
				int firstCount = 0;
				int secondCount = 0;
				int finCount = 0;

				// Defining start and end
				int start1 = Integer.parseInt(arr[0].split("-")[0]);
				int end1 = Integer.parseInt(arr[0].split("-")[1]);
				int start2 = Integer.parseInt(arr[1].split("-")[0]);
				int end2 = Integer.parseInt(arr[1].split("-")[1]);

				for (int i = start1; i <= end1; i++) {
					firstCount++;
					for (int j = start2; j <= end2; j++) {
						secondCount++;
						if (i == j)
							finCount++;
					}
				}
				
				secondCount /= firstCount;
				int smallest = firstCount < secondCount ? firstCount : secondCount;
				if (smallest == finCount) {
					res++;
				}
				line = br.readLine();
			}
			System.out.println(res);
			System.out.println("Time taken: " + obj.endTime(startTime) + "ms");
		}
	}
}
