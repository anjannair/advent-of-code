package day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import reusable.RepeatedCode;

// Learnt something new today about Stacking

public class Day5Part2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		RepeatedCode obj = new RepeatedCode();
		long startTime = obj.startTime();
		List<String> list = new ArrayList<>();
		Stack<Character>[] stacks = new Stack[9];
		for (int i = 0; i < stacks.length; i++) {
			stacks[i] = new Stack<>();
		}

		try (BufferedReader br = obj.getInput(5)) {
			String line = br.readLine();
			while (line != null) {
				if (line.equals(""))
					break;
				list.add(line);
				line = br.readLine();
			}

			for (int i = list.size() - 2; i >= 0; i--) {
				for (int k = 0; k < 9; k++) {
					// Capture elements 1, 5, 9... (addition of 4)
					char cap = list.get(i).charAt(k * 3 + (k) + 1);
					if (Character.isLetter(cap)) {
						stacks[k].push(cap);
					}
				}
			}

			line = br.readLine();
			while (line != null) {
				String[] arr = line.split(" ");
				int amt = Integer.parseInt(arr[1]);
				int from = Integer.parseInt(arr[3]) - 1;
				int to = Integer.parseInt(arr[5]) - 1;

				// We use a list to store the crates we pop out
				// After popping it we push the crates from the list in a reverse manner
				List<Character> crates = new ArrayList<>();
				for (int i = 0; i < amt; i++) {
					crates.add(stacks[from].pop());
				}
				for (int i = amt - 1; i >= 0; i--) {
					stacks[to].push(crates.get(i));
				}
				line = br.readLine();
			}
			for (int i = 0; i < stacks.length; i++) {
				System.out.print(stacks[i].peek());
			}
			System.out.println();
			System.out.println("Time taken: " + obj.endTime(startTime) + "ms");
		}
	}
}
