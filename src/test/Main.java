 package test;

import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeString;
import model.Board;
import model.Player;
import static utils.Colors.*;

public class Main {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        int x, y;
        String p1_name, p2_name;
        char p1_ficha, p2_ficha;

        System.out.println(ANSI_CYAN + "// Jugador 1, introdueix nom:" + ANSI_RESET);
        p1_name = user_input.nextLine();

        do {
            System.out.println("\n" + ANSI_CYAN + "// Amb quina ficha vols jugar ?"
                    + ANSI_RESET + " (" + ANSI_RED + "O" + ANSI_RESET + " , " + ANSI_GREEN + "X" + ANSI_RESET + ")");
            p1_ficha = user_input.nextLine().toUpperCase().charAt(0);

            if (p1_ficha != 'O' && p1_ficha != 'X') {
                System.out.println("\n" + ANSI_BLUE_BACKGROUND + " Només pots introduir O , X " + ANSI_RESET);
            }

        } while (p1_ficha != 'O' && p1_ficha != 'X');

        Player p1 = new Player(p1_name, p1_ficha);

        if (p1_ficha == 'O') {
            p2_ficha = 'X';
        } else {
            p2_ficha = 'O';
        }

        System.out.println("\n" + ANSI_CYAN + "// Jugador 2, introdueix nom:" + ANSI_RESET);
        p2_name = user_input.next();
        Player p2 = new Player(p2_name, p2_ficha);

        System.out.println("\n" + p1.getName() + " comença: ");

        System.out.println("\n" + ANSI_YELLOW + p1.getName() + ANSI_RESET + " comença:\n");

        Board board = new Board(p1,p2);
        while (true) {
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
