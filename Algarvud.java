import java.util.Scanner;
/**
 * Algarvud
 */
public class Algarvud {

    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sisesta arv: ");
        number = scanner.nextInt();        
        if (number % 2 == 0){
            System.out.println("Sisestatud number jagub kahega(2)");
        } else if (number % 3 == 0){
            System.out.println("Sisestatud number jagub kolmega(3)");
        } else if (number % 5 == 0){
            System.out.println("Sisestatud number jagub viiega(5)");
        } else if (number % 7 == 0){
            System.out.println("Sisestatud number jagub seitsmega(7)");
        } else {
            System.out.println("Arv ei jagu ühegi ette antud arvuga");
        }

        boolean prime = true; 
        for (int i = 2; i <= number/2; ++i){
            if (number % i == 0){
                prime = false;
                break;
            }
        }

        if (prime == false){
             System.out.println("Tegemist ei ole algarvuga");
        } else {
            System.out.println("Tegemist on algarvuga");
        }
        
    }
}