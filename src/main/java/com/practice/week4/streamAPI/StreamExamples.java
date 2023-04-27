package com.practice.week4.streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void printStream(List<Integer> marks){
        marks.forEach(i->System.out.print(i+" "));
        System.out.println();

    }
    public static void intermediateStream(List<Integer> marks){
        List<Integer> gracedMarks
                = marks.stream()
                .map(i -> i + 4)
                .collect(Collectors.toList());

        System.out.println(
                "Marks of students  after grace : ");
        printStream(gracedMarks);

        List<Integer> sortedMarks
                = gracedMarks.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(
                "Marks of students  after sorting : ");
        printStream(sortedMarks);

        List<Integer> passMarks
                = sortedMarks.stream()
                .filter(i -> i>=40)
                .collect(Collectors.toList());

        System.out.println(
                "Passed Marks: ");
        printStream(passMarks);
    }

    public static void terminalStream(List<Integer> marks)
    {
        System.out.println(
                "Is there odd marks : "+marks.stream()
                        .anyMatch(i->i%2!=0));

        System.out.println("No of subjects: "+marks.stream().count());

        System.out.println("Max marks: "+marks.stream().max(Comparator.comparingInt(i -> i)).get());

        System.out.println("Sum of marks: "+(marks.stream().reduce(Integer::sum).get()));
    }

    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(30, 78, 26, 96, 79);

        System.out.println(
                "Marks of students : " + marks);

        intermediateStream(marks);
        terminalStream(marks);



    }
}
