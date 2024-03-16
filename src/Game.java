import java.util.Scanner;

public class Game {
    private Player player;
    private Location location;

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.print("Hello!, You must enter your name! What is your character name: ");
        String playerName = input.nextLine();
        player = new Player(playerName);
        System.out.println(player.getUserName() + " Welcome To Adventure Game, good luck in this difficult challenge");
        System.out.println("***************** Survivor Challenge *********************************");
        player.selectChar();

        player.selectLocation();


    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {

        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
