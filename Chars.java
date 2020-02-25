

/**
 * Chars
 */
public class Chars {

    public static void main(String[] args) {
        /*char first = 88;
        System.out.println(first);

        String letter = "a";

        int second = letter.charAt(0);

        System.out.println(second);*/

        String paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi diam mauris, feugiat quis tellus ac, interdum tristique diam. Praesent scelerisque tellus dui, ut semper augue commodo aliquam. Vivamus vehicula porttitor luctus. In id orci at lectus auctor fringilla a quis mauris. Nam non rhoncus quam, molestie viverra lacus. Maecenas et nunc et tortor vehicula volutpat. Nunc dui mauris, rutrum in ante ut, lacinia laoreet urna. Duis venenatis ut sapien vitae maximus.";
        char letter = 'a';
        int count = 0;
        for(int i = 0; i < paragraph.length(); i++){
            if (paragraph.charAt(i) == letter){
                count++;
            }
        }
        System.out.println("'a' occured "+count+" times.");
    }
}