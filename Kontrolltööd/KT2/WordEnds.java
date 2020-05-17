import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.*;

class Basic {
    public static void main(String args[]) {
        Book book = new Book();
        book.readBook("LoremIpsum.txt asukoht");
        book.printWordEndings();
        book.saveWords("Kausta asukoht, kuhu sõnade failid pannakse");
    }
}

class Book {
    public ArrayList<String> Words;
    public HashMap<String, Integer> WordEndings;
    public HashMap<String, ArrayList<String>> WordGrouping;
    public HashMap<String, String> WordsFiles;

    public Book() {
        Words = new ArrayList<String>();
        WordEndings = new HashMap<String, Integer>();
        WordGrouping = new HashMap<String, ArrayList<String>>();
        WordsFiles = new HashMap<String, String>();
    }

    public void readBook(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] words = getOnlyAlphabet(line).split(" ");

                for (String word : words) {
                    Words.add(word);

                    String c = null;
                    if (word.length() > 1)
                        c = word.substring(word.length() - 1);
                    else if (word.length() == 1)
                        c = word;
                    else
                        continue;

                    System.out.print(c + " ");

                    Integer i = WordEndings.get(c);
                    if (i == null)
                        WordEndings.put(c, 1);
                    else
                        WordEndings.put(c, i + 1);

                    ArrayList<String> a = WordGrouping.get(c);
                    if (a == null) {
                        ArrayList<String> list = new ArrayList<String>();
                        list.add(word);
                        WordGrouping.put(c, list);
                    } else
                        a.add(word);
                }
            }
            System.out.println();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void printWordEndings() {
        WordEndings = sort(WordEndings);

        for (Map.Entry m : WordEndings.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }

    public void saveWords(String dicPath) {
        for (Entry<String, ArrayList<String>> m : WordGrouping.entrySet()) {
            writeToFile(m.getValue(), dicPath + "\\" + m.getKey() + ".txt");
            WordsFiles.put(m.getKey(), dicPath + "\\" + m.getKey() + ".txt");
        }
    }

    public static void writeToFile(ArrayList<String> lines, String destPath) {
        FileWriter fw;
        try {
            fw = new FileWriter(destPath);
            for (String str : lines) {
                fw.write(str + "\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("ERROR: exception was: " + ex.toString());
        }
        File f = new File(destPath);
        f.setExecutable(true);
    }

    public static String getOnlyAlphabet(String s) {
        return removeFromString(s, new String[] { "!", ".", ",", ":", ";", "?", "(", ")", "=", "\"" });
    }

    public static String removeFromString(String s, String[] a) {
        String ss = s;
        for (String c : a) {
            ss = ss.replace(c, "");
        }
        return ss;
    }

    public static HashMap<String, Integer> sort(HashMap<String, Integer> map) {
        HashMap<String, Integer> sortedMap = map.entrySet().stream().sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }
}
