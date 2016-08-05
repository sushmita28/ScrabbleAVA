import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vedsharma on 05-Aug-16.
 */
public class Scrabble {
    //get all words from sowpods.txt
    public static String[] getAllWords() throws java.io.FileNotFoundException {
        return new Scanner(new File("C:\\Users\\vedsharma\\Downloads\\Bootcamp\\Day 4\\sowpods.txt")).useDelimiter("\\Z").next().split("\\r?\\n");
    }
    //prints all permutation of given word
    //can be extended to store all permutations
    public static void permutation(String str) {
        permutation("", str);
    }
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
    //input
    public static void main(String[] args) {
        System.out.print("Enter rack : ");
        Scanner sc = new Scanner(System.in);
        Rack rack = new Rack(sc.nextLine().toUpperCase());
        System.out.println(rack);
        //permutation(sc.nextLine().toUpperCase());
    }
}

class Rack {
    private ArrayList<Letter> rack;

    public Rack() {
        rack=new ArrayList<>();
    }

    public Rack(String rackCharacters) {
        rack=new ArrayList<>();
        char[] characters = rackCharacters.toCharArray();
        for (char ch: characters) {
            Letter newLetter = new Letter(ch,(ch-'A'+1));
            rack.add(newLetter);
        }
    }

    public ArrayList<Letter> getRack() {
        return rack;
    }

    public void setRack(ArrayList<Letter> rack) {
        this.rack = rack;
    }

    public int getRackSize() {
        return rack.size();
    }

    public String toString() {
        String str="Rack :\n";
        for (Letter letter: rack) {
            str+=letter.toString()+"\n";
        }
        return str;
    }

}

class Letter {
    private char character;
    private int point;
    public Letter(char character) {
        this.character = character;
        point=0;
    }
    public Letter(char character, int point) {
        this.character=character;
        this.point=point;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    public String toString() {
        return "character : "+character+" point : "+point;
    }
}