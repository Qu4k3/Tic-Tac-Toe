package model;

public class Board {
    private Cell[][] table;
    private int turnCount;
    
    public Board(){
        turnCount = 0;
        table = new Cell[3][3];
        for (int i = 0;  i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                table[i][j] = new Cell();
            }
        }
    }
    
    public boolean input(int x, int y){
        if (table[y][x].getState()=='-'){
            if (turnCount%2==0) table[y][x].setState('X');
            else table[y][x].setState('O');
            ++turnCount;
            return true;
        }
        return false;
    }
    
    public void print(){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                if (j==0) System.out.print("|");
                System.out.print(table[i][j].getState());
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }
    
}
