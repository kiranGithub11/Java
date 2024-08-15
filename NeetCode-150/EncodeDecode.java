// https://neetcode.io/problems/string-encode-and-decode

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EncodeDecode {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // Find the position of the delimiter '#'
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            // Extract the length of the next string
            int length = Integer.valueOf(str.substring(i, j));
            // Extract the string based on the length
            strs.add(str.substring(j + 1, j + 1 + length));
            // Move the index past the current string and its delimiter
            i = j + 1 + length;
        }
        return strs;
    }

    public static void main(String[] args) {
        EncodeDecode encodeDecode = new EncodeDecode();
        Scanner scanner = new Scanner(System.in);

        // Input from the user
        // System.out.println("Enter space-separated strings:");
        String input = scanner.nextLine();

        // Split the input into a list of strings
        List<String> inputList = new ArrayList<>(List.of(input.split("\\s+")));
        // List<String> inputList = new ArrayList<>(List.of(input.split(" ")));

        // Encode the list of strings
        String encodedString = encodeDecode.encode(inputList);
        System.out.println("Encoded String: " + encodedString);

        // Decode the encoded string
        List<String> decodedList = encodeDecode.decode(encodedString);
        System.out.println("Decoded List: " + decodedList);
        
        scanner.close();
    }
}
