import java.io.*;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Read input
        try (BufferedReader br = new BufferedReader(new FileReader("advent-of-code/2022/day1/day1input.txt"))) {
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

    }
}
