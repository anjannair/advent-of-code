package day7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import reusable.RepeatedCode;

public class Day7 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		HashMap<Character, Integer> sizeTrack = new HashMap<>();
		List<String> currentDir = new ArrayList<>();
		// Really vague hardcode because 26 alphabets
		
		try (BufferedReader br = obj.getInput(7)) {
			String line = br.readLine();
			while (line != null) {
				String[] arr = line.split(" ");
				// System.out.println(Arrays.toString(arr));
				if (arr[1].equals("cd") && !arr[2].equals("..")) {
					currentDir.add(arr[2]);
				} else if (arr[1].equals("cd") && arr[2].equals("/")) {
					currentDir.clear();
					currentDir.add("/");
				} else if (arr[1].equals("cd") && arr[2].equals("..")) {
					currentDir.remove(currentDir.size() - 1);
				}

				int count = 0;
				if (arr[1].equals("ls")) {
					List<String> values = new ArrayList<>();
					line = br.readLine();
					while (!line.startsWith("$")) {
						// System.out.println(line);
						values.add(line);
						line = br.readLine();
						count++;
						if (line == null)
							break;
					}
					// System.out.println(line);
					for (String data : values) {
						if (Character.isDigit(data.charAt(0))) {
							char curr = currentDir.get(currentDir.size() - 1).charAt(0);
							if (sizeTrack.containsKey(curr)) {
								sizeTrack.put(curr, sizeTrack.get(curr) + Integer.parseInt(data.split(" ")[0]));
							} else {
								sizeTrack.put(curr, Integer.parseInt(data.split(" ")[0]));
							}
						}
					}
				}
				System.out.println(sizeTrack);

				// System.out.println(dirStruc);
				if (count > 0)
					continue;
				line = br.readLine();
			}
			System.out.println("Time taken: " + obj.endTime(startTime) + "ms");
		}
	}
}
