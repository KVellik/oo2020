import java.util.ArrayList;
import java.util.List;
/**
 * PrimeArray
 */
public class PrimeArray {

    public static void main(String[] args) {
        
        List<Integer> prime = new ArrayList<Integer>();
        int number = 2;
        int count = 0;
        while(count < 1000){
            if (PrimeNumber(number)) {
                prime.add(number);
                count++;
            }
            number++;
        }

    
        //Võtab viimase algarvu
        int lastPrime = prime.get(prime.size() - 1);
        int lastPrimeRoot = (int)Math.pow(lastPrime, 2);
        int number2 = lastPrimeRoot - 1;
        int count2 = 0;
        List<Integer> TenPrime = new ArrayList<Integer>();
        //laseb läbi kuni on 10 prime arvu olemas alla viimase prime numbri
        while(count2 < 10){
            if (PrimeNumber(number2)){
                TenPrime.add(number2);
                count2++;
            }
            number2--;
        }
    }


    public static boolean PrimeNumber(int number) {
        
        for (int i=2; i <= number/2; i++){
            if (number % i == 0){
                return false;
            } 
        }

        return true;

    }
}