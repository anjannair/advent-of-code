package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1Part2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        long startTime = System.nanoTime();
        // Read input
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/2022/src/day1/day1input.txt"))) {
            String line = br.readLine();
            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;

            while (line != null) {
                // Checking for blank space
                if (line.equals("")) {
                    // Check max
                    list.add(sum);
                    sum = 0;
                    line = br.readLine();
                    continue;
                } else {
                    // summation
                    sum += Integer.parseInt(line);
                }

                line = br.readLine();
            }
            Collections.sort(list);
            System.out.println(list.get(list.size() - 1) + list.get(list.size() - 2) + list.get(list.size() - 3));
            long endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / (double) 1000000;
            System.out.println("Time taken: " + totalTime + "ms");
        }

    }
}	
