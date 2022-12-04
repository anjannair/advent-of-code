package reusable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RepeatedCode {
	public BufferedReader getInput(int day) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(System.getProperty("user.dir") + "/2022/src/day" + day + "/day" + day + "input.txt"));
		return br;
	}

	public BufferedReader getInput(int day, int year) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(
				System.getProperty("user.dir") + "/" + year + "/src/day" + day + "/day" + day + "input.txt"));
		return br;
	}

	public long startTime() {
		return System.nanoTime();
	}

	public double endTime(long start) {
		long endTime = System.nanoTime();
		double totalTime = (endTime - start) / (double) 1000000;
		return totalTime;
	}
}
