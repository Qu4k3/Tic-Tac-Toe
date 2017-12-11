package test;

import java.util.Scanner;
import model.Board;
import model.Player;
import static utils.Colors.*;

public class Main {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);

        boolean running;
        boolean game = true;
        int x, y, auxTurn = 0;
        String p1_name, p2_name;
        char p1_ficha, p2_ficha;

        System.out.println(ANSI_BLUE_BACKGROUND + " Tic-Tac-Toe " + ANSI_RESET);

        System.out.println("\n" + ANSI_CYAN + "// Jugador 1, introdueix nom:" + ANSI_RESET);
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

        while (game) {
            running = true;
            Board board = new Board(p1, p2);
            while (running) {
                do {

                    if ((auxTurn % 2) == 0) {
                        System.out.println("\nÉs el torn de " + ANSI_YELLOW + p1.getName() + ANSI_RESET);
                    } else {
                        System.out.println("\nÉs el torn de " + ANSI_YELLOW + p2.getName() + ANSI_RESET);
                    }

                    System.out.println("\n" + ANSI_CYAN + "// Introdueix posició x" + ANSI_RESET);
                    System.out.println("\n"
                            + ANSI_YELLOW + "|0|1|2|\n"
                            + ANSI_YELLOW + "|0|1|2|\n"
                            + ANSI_YELLOW + "|0|1|2|\n" + ANSI_RESET);
                    System.out.print("> ");
                    x = user_input.nextInt();

                    System.out.println("\n" + ANSI_CYAN + "// Introdueix posició y" + ANSI_RESET);
                    System.out.println("\n"
                            + ANSI_YELLOW + "|0|0|0|\n"
                            + ANSI_YELLOW + "|1|1|1|\n"
                            + ANSI_YELLOW + "|2|2|2|\n" + ANSI_RESET);
                    System.out.print("> ");
                    y = user_input.nextInt();

                } while (!board.input(x, y));

                auxTurn++;

                System.out.println("\n" + ANSI_GREEN + "Estat del taulell" + ANSI_RESET + "\n");
                board.print();

                running = (board.victoryCondition() == ' ');

            }
            if (board.getWinner() == p1.getFicha()) {
                System.out.println("\n" + ANSI_PURPLE_BACKGROUND + ANSI_WHITE + " El jugador " + p1.getName() + " guanya " + ANSI_RESET);
            } else if (board.getWinner() == p2.getFicha()) {
                System.out.println("\n" + ANSI_PURPLE_BACKGROUND + ANSI_WHITE + " El jugador " + p2.getName() + " guanya " + ANSI_RESET);
            } else {
                System.out.println("\n" + ANSI_PURPLE_BACKGROUND + ANSI_WHITE + " Empat " + ANSI_RESET);
            }
            user_input.nextLine();
            System.out.println("\n" + ANSI_CYAN + "// Vols tornar a jugar? (s/n)" + ANSI_RESET);
            System.out.print("\n> ");
            try {
                game = (user_input.nextLine().toLowerCase().charAt(0) == 's');
            } catch (ArrayIndexOutOfBoundsException e) {
                game = false;
            }
        }
        System.out.println("\n" + ANSI_BLUE_BACKGROUND + " Fi del joc, gràcies per jugar " + ANSI_RESET);

    }
}
