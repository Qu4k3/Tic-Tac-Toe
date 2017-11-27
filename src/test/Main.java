package test;

import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeString;
import model.Board;
import model.Player;
public class Main {
    
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        int x, y;
        String p1_name, p2_name;
        char p1_ficha, p2_ficha;
        
        System.out.println("\nJugador 1, introdueix nom: ");
        p1_name = user_input.nextLine();
        
        System.out.println("\nAmb quina ficha vols jugar ? (O , X) ");
        p1_ficha = user_input.nextLine().toUpperCase().charAt(0);
        
        Player p1 = new Player(p1_name, p1_ficha);

        if(p1_ficha == 'O') {
            p2_ficha = 'X';
        } else {
            p2_ficha = 'O';
        }        
        
        System.out.println("\nIntrodueix jugador 2: ");
        p2_name = user_input.next();
        Player p2 = new Player(p2_name, p2_ficha);
        
        System.out.println("\n" + p1.getName() + " comença: ");
        
        Board board = new Board();
        while (true){
            do {
                System.out.println("Introdueix x");
                x = user_input.nextInt();
                System.out.println("Introdueix y");
                y = user_input.nextInt();
            } while (!board.input(x, y));
            board.print();
        }
    }
}
