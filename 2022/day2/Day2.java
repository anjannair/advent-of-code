import java.io.*;
import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("advent-of-code/2022/day2/day2input.txt"))) {
            String line = br.readLine();
            String[] elves = {"A","B","C"};
            String[] person = {"X", "Y", "Z"};
            int sum = 0;


            while (line != null) {
                // Checking for blank space
                if (!line.equals("")) {
                    line.trim();
                    String[] splitter = line.split(" ");
                    int pos = Arrays.asList(elves).indexOf(splitter[0]);
                    int pos2 = Arrays.asList(person).indexOf(splitter[1]);
                    // Losing
                    if((pos==0 && pos2==2)||(pos==1 && pos2==0)||(pos==2 && pos2==1)){
                        sum += pos2+1; 
                    }else if(pos==pos2){
                        sum += 3+pos2+1;
                    }else{
                        sum += 6+pos2+1;
                    }
                }

                line = br.readLine();
            }
            System.out.println(sum);
        }
    }
}
