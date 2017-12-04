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
        if (turnCount == 3*3) return 'E';
        char c;
        for (int i = 0; i < table.length; i++){
            c = equals3(table[i][0].getState(),table[i][1].getState(),table[i][2].getState());
            if (winner(c)) return c;
            c = equals3(table[0][i].getState(),table[1][i].getState(),table[2][i].getState());
            if (winner(c)) return c;
        }
        c  = equals3(table[0][0].getState(),table[1][1].getState(),table[2][2].getState());
        if (winner(c))return c;
        c  = equals3(table[2][0].getState(),table[1][1].getState(),table[0][2].getState());
        return c;
    }
    
    public char equals3(char a, char b, char c){
        if ((a!=' ') && ((a == b) && (b == c))) return a;
        if ((a!=' ') && ((a != b) && b !=' ') || (b != c && c != ' ')) return 'E'; 
        return ' ';
    }
    
    public boolean winner(char c){
        return (c!=' ' && c!= 'E');
    }
}
