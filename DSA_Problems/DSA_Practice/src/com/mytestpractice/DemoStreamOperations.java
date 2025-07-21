package com.mytestpractice;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStreamOperations {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "David", "Andrew");

        // 1. Filtering: Select elements that match a condition
        // Get names starting with 'A'
        List<String> aNames = names.stream()
                                  .filter(name -> name.startsWith("A")) // Intermediate operation
                                  .collect(Collectors.toList());      // Terminal operation
        System.out.println("Names starting with A: " + aNames); // Output: [Alice, Anna, Andrew]

        // 2. Mapping: Transform elements from one type to another
        // Get the length of each name
        List<Integer> nameLengths = names.stream()
                                        .map(String::length) // Intermediate operation (method reference)
                                        .collect(Collectors.toList());
        System.out.println("Name lengths: " + nameLengths); // Output: [5, 3, 4, 5, 6]

        // 3. Sorting: Sort elements
        List<String> sortedNames = names.stream()
                                       .sorted() // Intermediate operation (natural order)
                                       .collect(Collectors.toList());
        System.out.println("Sorted names: " + sortedNames); // Output: [Alice, Andrew, Anna, Bob, David]

        // 4. Limiting and Skipping: Get a subset of elements
        List<String> firstTwo = names.stream()
                                    .limit(2) // Intermediate operation
                                    .collect(Collectors.toList());
        System.out.println("First two names: " + firstTwo); // Output: [Alice, Bob]

        List<String> skipFirstTwo = names.stream()
                                        .skip(2) // Intermediate operation
                                        .collect(Collectors.toList());
        System.out.println("Names after skipping first two: " + skipFirstTwo); // Output: [Anna, David, Andrew]

        // 5. Distinct: Remove duplicate elements
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 1, 4, 5, 4);
        List<Integer> distinctNumbers = numbersWithDuplicates.stream()
                                                            .distinct() // Intermediate operation
                                                            .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers); // Output: [1, 2, 3, 4, 5]

        // 6. ForEach: Perform an action for each element (side effect)
        System.out.print("Names printed using forEach: ");
        names.stream()
             .forEach(name -> System.out.print(name + " ")); // Terminal operation (side effect)
        System.out.println(); // New line

        // 7. Reduce: Combine elements into a single result
        // Sum of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b); // Terminal operation (initial value, accumulator)
        System.out.println("Sum of numbers: " + sum); // Output: 15

        // Concatenate names
        String concatenatedNames = names.stream()
                                        .reduce("", (acc, name) -> acc + name + " ");
        System.out.println("Concatenated names: " + concatenatedNames.trim());

        // 8. Collect: Accumulate elements into a Collection or Map
        // Group names by first letter
        Map<Character, List<String>> namesByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0))); // Terminal operation
        System.out.println("Names by first letter: " + namesByFirstLetter);
        // Output: {A=[Alice, Anna, Andrew], B=[Bob], D=[David]}

        // Convert to a Set
        Set<String> nameSet = names.stream().collect(Collectors.toSet());
        System.out.println("Names in a Set: " + nameSet);

        // 9. Match operations: Check if any/all/none elements match a predicate
        boolean anyStartsWithA = names.stream().anyMatch(name -> name.startsWith("A"));
        System.out.println("Any name starts with A? " + anyStartsWithA); // true

        boolean allStartWithA = names.stream().allMatch(name -> name.startsWith("A"));
        System.out.println("All names start with A? " + allStartWithA); // false

        boolean noneStartWithZ = names.stream().noneMatch(name -> name.startsWith("Z"));
        System.out.println("None name starts with Z? " + noneStartWithZ); // true

        // 10. `flatMap`: Flatten a stream of collections into a single stream
        List<List<String>> nestedLists = Arrays.asList(
            Arrays.asList("apple", "banana"),
            Arrays.asList("orange", "grape")
        );

        List<String> flatList = nestedLists.stream()
                                           .flatMap(List::stream) // Intermediate operation
                                           .collect(Collectors.toList());
        System.out.println("Flat list: " + flatList); // Output: [apple, banana, orange, grape]

        // 11. Parallel Streams
        long count = names.parallelStream()
                          .filter(name -> name.length() > 3)
                          .count(); // Terminal operation
        System.out.println("Names with length > 3 (parallel): " + count);
    }
}
