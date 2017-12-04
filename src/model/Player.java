package model;

public class Player {
    
    String name;
    char ficha;

    public Player(String name, char ficha) {
        this.name = name;
        this.ficha = ficha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }
    
}
