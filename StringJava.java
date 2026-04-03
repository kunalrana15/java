import java.util.*;

public class StringJava {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

                    // Input
                            System.out.print("Enter a string: ");
                                    String str = sc.nextLine();

                                            // 1. Length of string
                                                    System.out.println("Length: " + str.length());

                                                            // 2. Convert to uppercase & lowercase
                                                                    System.out.println("Uppercase: " + str.toUpperCase());
                                                                            System.out.println("Lowercase: " + str.toLowerCase());

                                                                                    // 3. Reverse string
                                                                                            String reversed = "";
                                                                                                    for (int i = str.length() - 1; i >= 0; i--) {
                                                                                                                reversed += str.charAt(i);
                                                                                                                        }
                                                                                                                                System.out.println("Reversed: " + reversed);

                                                                                                                                        // 4. Check palindrome
                                                                                                                                                if (str.equalsIgnoreCase(reversed)) {
                                                                                                                                                            System.out.println("Palindrome: Yes");
                                                                                                                                                                    } else {
                                                                                                                                                                                System.out.println("Palindrome: No");
                                                                                                                                                                                        }

                                                                                                                                                                                                // 5. Count vowels
                                                                                                                                                                                                        int vowels = 0;
                                                                                                                                                                                                                for (char c : str.toLowerCase().toCharArray()) {
                                                                                                                                                                                                                            if ("aeiou".indexOf(c) != -1) {
                                                                                                                                                                                                                                            vowels++;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                        System.out.println("Vowel count: " + vowels);

                                                                                                                                                                                                                                                                                // 6. Count words
                                                                                                                                                                                                                                                                                        String[] words = str.trim().split("\\s+");
                                                                                                                                                                                                                                                                                                System.out.println("Word count: " + words.length);

                                                                                                                                                                                                                                                                                                        // 7. Remove spaces
                                                                                                                                                                                                                                                                                                                String noSpaces = str.replaceAll(" ", "");
                                                                                                                                                                                                                                                                                                                        System.out.println("Without spaces: " + noSpaces);

                                                                                                                                                                                                                                                                                                                                // 8. Check substring
                                                                                                                                                                                                                                                                                                                                        System.out.print("Enter substring to search: ");
                                                                                                                                                                                                                                                                                                                                                String sub = sc.nextLine();

                                                                                                                                                                                                                                                                                                                                                        if (str.contains(sub)) {
                                                                                                                                                                                                                                                                                                                                                                    System.out.println("Substring found!");
                                                                                                                                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                                                                                                                                        System.out.println("Substring not found!");
                                                                                                                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                                                                                                                        sc.close();
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                            }