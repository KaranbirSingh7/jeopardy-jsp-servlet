package Beans;

public class Player implements java.io.Serializable {

    private String name;
    private int winnings;

    public Player() {
        this.name = "";
        this.winnings = 0;
    }

    public Player(String name, int winnings) {
        this.name = name;
        this.winnings = winnings;
    }

    public String getName() {
        return name;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

}
