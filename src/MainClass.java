import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainClass {
    static final int FetchLimit = 3;

    public static List<String> top3Strings(String string) {
        Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z']*");
        Matcher stringMatcher = pattern.matcher(string.toLowerCase());
        final Map<String, Integer> wordsCountMap = new HashMap<>();

        while (stringMatcher.find()) {
            String s = stringMatcher.group();
            wordsCountMap.put(s, wordsCountMap.getOrDefault(s, 1) + 1);
        }

        //Print Number of Occurrence
        System.out.println(wordsCountMap);

        return wordsCountMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(FetchLimit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

            public static void main (String[]args){

                String inputString = "e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e";
                System.out.println(top3Strings(inputString));
            }
        }
