package model;

public class Board {
    private char[][] table;
    private int turnCount;
    
    public Board(){
        turnCount = 0;
        table = new char[3][3];
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                table[i][j] = '-';
            }
        }
    }
    
    public boolean input(int x, int y){
        if (table[y][x]=='-'){
            if (turnCount%2==0) table[y][x] = 'X';
            else table[y][x] = 'O';
            ++turnCount;
            return true;
        }
        return false;
    }
    
    public void print(){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                System.out.print(table[i][j]);
            }
            System.out.print("\n");
        }
    }
    
}
