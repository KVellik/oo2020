import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Character player = new Character("Karl", CharacterType.WARRIOR);
        Character enemy = new Character("Sipsik", CharacterType.GOBLIN);
        
        Scanner scanner = new Scanner(System.in);

        //String first = scanner.nextLine();       
        
        player.slogan = "Hey";

        System.out.println(player); //??????

        player.changeDirection(Direction.RIGHT);

        player.move();
        player.move();
        player.move();
        player.move();

        System.out.println(player);

        enemy.move();
        System.out.println(enemy);

        String input = "";

        while(!input.equals("end")){
            input = scanner.nextLine();


            if (input.equals("")){
                player.move();
            } else if (input.equals("u")){
                player.changeDirection(Direction.UP);
                player.move();
            } else if (input.equals("d")){
                player.changeDirection(Direction.DOWN);
                player.move();
            } else if (input.equals("l")){
                player.changeDirection(Direction.LEFT);
                player.move();
            } else if (input.equals("r")){
                player.changeDirection(Direction.RIGHT);
                player.move();
            }

            if(player.x == enemy.x && player.y == enemy.y){
                
            }
        }

    }      
   
}