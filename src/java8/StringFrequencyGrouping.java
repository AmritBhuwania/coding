package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringFrequencyGrouping {

    public static void main(String[] args) {
        // Sample input strings
        String[] strings = {"apple", "banana", "apple", "orange", "banana", "apple"};
        List<String> stringList = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        // Group strings by their frequency
        Map<String, Long> frequencyMap = Arrays.stream(strings)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> frequencyMap1 = stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the frequency of each string
        frequencyMap.forEach((string, frequency) -> System.out.println(string + " : " + frequency));

        // Print the frequency of each string
        frequencyMap1.forEach((string, frequency) -> System.out.println(string + " : " + frequency));
    }
}
