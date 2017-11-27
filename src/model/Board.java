package model;

public class Board {
    private Cell[][] table;
    private int turnCount;
    private Player[] players;
    
    public Board(Player player1, Player player2){
        turnCount = 0;
        table = new Cell[3][3];
        for (int i = 0;  i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                table[i][j] = new Cell();
            }
        }
        players = new Player[2];
        players[0] = player1;
        players[1] = player2;
    }
    
    public boolean input(int x, int y){
        if (table[y][x].getState()==' '){
            table[y][x].setState(players[turnCount%2].getFicha());
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
    
    public char victoryCondition(){
        for (int i = 0; i < table.length; i++){
            if ((table[i][0].getState()!=' ') && (table[i][0].getState()==table[i][1].getState()) && (table[i][1].getState()==table[i][2].getState())) return table[i][0].getState();
            if ((table[0][i].getState()!=' ') && (table[0][i].getState()==table[1][i].getState()) && (table[1][i].getState()==table[2][i].getState())) return table[0][i].getState();
        }
        if ((table[0][0].getState()!=' ') && (table[0][0].getState()==table[1][1].getState()) && (table[1][1].getState()==table[2][2].getState())) return table[0][0].getState();
        if ((table[0][2].getState()!=' ') && (table[0][2].getState()==table[1][1].getState()) && (table[1][1].getState()==table[2][0].getState())) return table[1][1].getState();
        if (turnCount == 3*3) return 'E';
        return ' ';
    }
    
}
