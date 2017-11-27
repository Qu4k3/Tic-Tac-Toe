package test;

import java.util.Scanner;
import model.Board;
public class Main {
    
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        int x, y;
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
