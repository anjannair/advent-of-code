package day3;

import reusable.RepeatedCode;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		try (BufferedReader br = obj.getInput(3)) {
			String line = br.readLine();
			int sum = 0;

			while (line != null) {
				// Checking for blank space
				if (!line.equals("")) {
					String first = line.substring(0, line.length() / 2);
					String second = line.substring(line.length() / 2, line.length());
					int count = 0;
					char store = '0';
					for (int i = 0; i < first.length(); i++) {
						for (int j = 0; j < first.length(); j++) {
							if (first.charAt(i) == second.charAt(j)) {
								count++;
								store = first.charAt(i);
								break;
							}
						}
						if (count > 0) {
							if (Integer.valueOf((char) store) >= 97 && Integer.valueOf((char) store) <= 122) {
								sum += (store - 96);
							} else {
								sum += (store - 38);
							}
							break;
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
