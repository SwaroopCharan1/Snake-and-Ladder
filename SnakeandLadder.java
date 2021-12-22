import java.util.HashMap;
 import java.util.Map;
 import java.util.Random;
 import java.util.Scanner;
/* SnakeNLadder class consists of keys and attributes of snakes and ladders positions and methods*/
 class SnakeNLadder{
     final static int WinPoint =100;
      static Map <Integer, Integer> snake = new HashMap<Integer , Integer>();
      static Map <Integer, Integer> ladder = new HashMap<Integer , Integer>();
    
    {
        
        snake.put(99,78);
        snake.put(96,75);
        snake.put(93,73);
        snake.put(87,24);
        snake.put(64,60);
        snake.put(62,19);
        snake.put(54,34);
        snake.put(17,7);



        ladder.put(71,91);
        ladder.put(63,81);
        ladder.put(28,84);
        ladder.put(40,59);
        ladder.put(51,67);
        ladder.put(20,38);
        ladder.put(9,31);
        ladder.put(4,14);
        
    }
    public int rollDice(){
        int n=0;
        Random r=new Random();
        n=r.nextInt(7);
        return (n==0?1:n);
    }
    public int PlayerValue(int player , int diceValue){
        player =player+diceValue;
        if(player > WinPoint){
            player=player-diceValue;
            return player;
        }
        if(null !=snake.get(player)){
            System.out.println("Snake  Swallowed" );
            player =snake.get(player);
        }
        if(null !=ladder.get(player)){
            System.out.println(" Climb the ladder" );
            player =ladder.get(player);
        }
         return player;
    }
    public boolean isWin( int player){
        return WinPoint ==player;
    }
    public void startGame(){
         int player1=0,player2=0;
         int currentPlayer=-1;
         Scanner input =new Scanner(System.in);
         String str;
         int diceValue=0;
          do{
              System.out.println(currentPlayer ==-1 ?"\n\n First Player Turn":"Second Player Turn");
              System.out.println("Press d to roll Dice");
              str=input.next();
              diceValue=rollDice();
              if(currentPlayer ==-1){
                   player1=PlayerValue(player1, diceValue);
                   System.out.println("First Player :" +player1);
                   System.out.println("SecondPlayer :" +player2);
                   System.out.println("----------------------------------");
                    if(isWin(player1)){
                        System.out.println("Player 1 Wins the Game");
                    return;
                    }
                }
                else{
                    player2=PlayerValue(player2, diceValue);
                    System.out.println("First Player :" +player1);
                    System.out.println("SecondPlayer :" +player2);
                    System.out.println("----------------------------------");
                     if(isWin(player2)){
                         System.out.println("Player 2 Wins the Game");
                     return;
                     }
                }

                currentPlayer=-currentPlayer;
          }while("d".equals(str));
    }
}
   

public class SnakeandLadder{
    public static void main(String[]args) {
        SnakeNLadder s=new SnakeNLadder();
        s.startGame();
    }
}
