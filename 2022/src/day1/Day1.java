package day1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Measure time
        long startTime = System.nanoTime();
        // Read input
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/2022/src/day1/day1input.txt"))) {
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

        long endTime = System.nanoTime();
        double totalTime = (endTime - startTime)/(double)1000000;
        System.out.println("Time taken: " + totalTime + "ms");

    }
}
