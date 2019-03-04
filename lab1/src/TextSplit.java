import java.util.Scanner;

public class TextSplit {
    private String consonant[] = new String[55];
    private String vowel[] = new String[55];
    private String notALetter[] = new String[55];
    private int c = 0, v = 0, n = 0;

    TextSplit () {
    }

    public void split(Scanner scanner) {
        while (scanner.hasNextLine())
        {

            String temp = scanner.nextLine();
            char firstChar = temp.charAt(0);

            if((firstChar >= 65 && firstChar <= 90) || (firstChar >= 97 && firstChar <= 122))
            {
                if(firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u' || firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U'){
                    vowel[v] = temp;
                    System.out.println("[d]Added to vowels\n" + vowel[v]);
                    System.out.println();
                    v++;
                } else {
                    consonant[c] = temp;
                    System.out.println("[d]Added to consonants\n" + consonant[c]);
                    System.out.println();
                    c++;
                }
            } else {
                notALetter[n] = temp;
                System.out.println("[d]Added to notAletters\n" + notALetter[n]);
                System.out.println();
                n++;
            }
        }
    }

    public void print(){
        System.out.println("\n1) Lines that begin with a vowel:\n");
        for (int i = 0; i < v; i++) {
            System.out.println(vowel[i]);
        }
        System.out.println("\n2) Lines that begin with a consonant:\n");
        for (int i = 0; i < c; i++) {
            System.out.println(consonant[i]);
        }
        System.out.println("\n3) Lines that do not begin with a letter:\n");
        for (int i = 0; i < n; i++) {
            System.out.println(notALetter[i]);
        }
    }

    public void findShortest()
    {
        String shortestL = " ";
        int shortest = 999;
        for (int i = 0; i < v; i++) {
            if(vowel[i].length() < shortest){
                shortest = vowel[i].length();
                shortestL = vowel[i];
            }
        }
        System.out.println("The shortest line which begins with a vowel and has a length of " + shortest + " is:\n" + shortestL );
        System.out.println();

        shortestL = " ";
        shortest = 999;
        for (int i = 0; i < c; i++) {
            if(consonant[i].length() < shortest){
                shortest = consonant[i].length();
                shortestL = consonant[i];
            }
        }
        System.out.println("The shortest line which begins with a consonant and has a length a length of " + shortest + " is:\n" + shortestL);
        System.out.println();

        shortestL = " ";
        shortest = 999;
        for (int i = 0; i < n; i++) {
            if(notALetter[i].length() < shortest){
                shortest = notALetter[i].length();
                shortestL = notALetter[i];
            }
        }
        System.out.println("The shortest line which doesn't begin with a letter and has a length of " + shortest + " is:\n" + shortestL );
    }
}





