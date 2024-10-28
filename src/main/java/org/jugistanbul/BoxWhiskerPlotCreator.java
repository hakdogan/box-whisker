package org.jugistanbul;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author hakdogan (huseyin.akdogan@patikaglobal.com)
 * Created on 27.10.2024
 ***/
public class BoxWhiskerPlotCreator {

    public static void main(String[] args) {

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Press enter without entering a number to exit the application!");
            System.out.println("Please enter the number string with spaces between them:");
            String input = scanner.nextLine();

            if(input.isBlank()){
                System.exit(-1);
            }

            String[] parts = input.split(" ");
            if(parts.length < 5){
                System.out.println("The size of the number array cannot be less than 5\n");
                continue;
            }

            double[] numbers = new double[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Double.parseDouble(parts[i]);
            }

            Arrays.sort(numbers);
            var sortedArray = Arrays.stream(numbers).mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.print(String.format("Sorted array: %s%n", sortedArray));

            double q1 = calculatePercentile(numbers, 25);
            double q2 = calculatePercentile(numbers, 50); // Medyan
            double q3 = calculatePercentile(numbers, 75);
            double min = numbers[0];
            double max = numbers[numbers.length - 1];

            var result = String.format("%nMin value: %s%nQ1: %s%nQ2 (Median): %s%nQ3: %s%nMax value: %s%n",
                    min, q1, q2, q3, max);

            System.out.println(result);
        }
    }

    private static double calculatePercentile(final double[] sortedNumbers,
                                              final double percentile) {
        int n = sortedNumbers.length;
        double index = percentile / 100 * (n - 1);
        int lower = (int) Math.floor(index);
        int upper = (int) Math.ceil(index);

        return (sortedNumbers[lower] + sortedNumbers[upper]) / 2;
    }
}
