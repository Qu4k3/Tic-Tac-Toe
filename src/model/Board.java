package model;

public class Board {
    private Cell[][] table;
    private int turnCount;
    private Player[] players;
    private char winner;
    
    public Board(Player player1, Player player2){
        turnCount = 0;
        winner = ' ';
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
        char c = ' ';
        for (int i = 0; i < table.length && winner == ' '; i++){
            c = eval(table[i][0].getState(),table[i][1].getState(),table[i][2].getState());
            c = eval(table[0][i].getState(),table[1][i].getState(),table[2][i].getState());
        }
        if (winner == ' ') c  = eval(table[0][0].getState(),table[1][1].getState(),table[2][2].getState());
        if (winner == ' ') c  = eval(table[2][0].getState(),table[1][1].getState(),table[0][2].getState());
        return c;
    }
    
    boolean victory(char a, char b, char c){
        return ((a!=' ') && ((a == b) && (b == c)));
    }
    
    boolean canWin(char a, char b, char c){
        char t = ' ';
        if (a!= ' ') t = a;
        if (b!= ' '){
            if (t==' ') t = b;
            else if (b != t) return false;
        }
        if (c!= ' '){
            if (t!=' ' && c != t) return false;
        }
         return true;
    }
    
    public char eval(char a, char b, char c){
        if (winner!=' ') return winner;
        if (victory(a,b,c)){
            winner = a;
            return a;
        }
        if (canWin(a,b,c)) return ' ';
        return 'E';
    }
    
    public char getWinner(){
        return winner;
    }
    
    
}
