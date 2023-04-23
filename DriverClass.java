package knapsack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) throws IOException {
        List<Item> items = new ArrayList<>();
        int capacity = 0;
        File inputFile = new File("/Users/shashankpal/Downloads/knapsack.rtf");
        File outputFile = new File("/Users/shashankpal/Downloads/output.txt");
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            String[] tokens = scanner.nextLine().split("\n");
            for (String token : tokens) {
                if (token.length() >= 1) {
                    int compare1 = Character.compare(token.charAt(0), '0');
                    int compare2 = Character.compare(token.charAt(0), '9');
                    int compare3 = Character.compare(token.charAt(0), 'M');

                    if (compare1 >= 0 && compare2 <= 0) {
                        String[] row = token.split(" ");
                        String weight = row[2];
                        int w = 0;
                        for (int i = 0; i < weight.length(); i++) {
                            if (weight.charAt(i) >= '0' && weight.charAt(i) <= '9') {
                                w *= 10;
                                w += weight.charAt(i) - '0';
                            }
                        }
                        items.add(new Item(w, Integer.parseInt(row[1])));
                    }
                    if (compare3 == 0) {
                        String[] row = token.split(":");
                        String cap = row[1];
                        for (int i = 0; i < cap.length(); i++) {
                            if (cap.charAt(i) >= '0' && cap.charAt(i) <= '9') {
                                capacity *= 10;
                                capacity += cap.charAt(i) - '0';
                            }
                        }
                    }
                }
            }
        }
        Knapsack knapsack = new Knapsack(items, capacity);
        long start1 = System.currentTimeMillis();
        int answer1 = knapsack.MaxProfitUsingQueue();
        long finish1 = System.currentTimeMillis();
        double timeElapsed1 = (finish1 - start1) / 1000.0;

        long start2 = System.currentTimeMillis();
        int answer2 = knapsack.MaxProfitUsingStack();
        long finish2 = System.currentTimeMillis();
        double timeElapsed2 = (finish2 - start2) / 1000.0;

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write("Solution using Queue " + answer1 + "\n");
        fileWriter.write("Solution using Stack " + answer2 + "\n");
        fileWriter.write("Time taken for solution using queue " + timeElapsed1 + "\n");
        fileWriter.write("Time taken for solution using stack " + timeElapsed2 + "\n");
        fileWriter.close();
        System.out.println(answer1);
        System.out.println(answer2);
    }
}
