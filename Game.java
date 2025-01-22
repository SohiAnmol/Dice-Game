import java.util.ArrayList;

public class Game {
    private CircularDoublyLinkedList<Player> players;
    private Dice dice;
    private ArrayList<String> eleminates = new ArrayList<String>();

    public Game() {
        this.players = new CircularDoublyLinkedList<>();
        this.dice = new Dice();
    }

    public void addPlayer(Player player) {
        players.addLast(player);
    }

    public void simulateGame() {
        ArrayList<Integer> rolls;
        Node<Player> currentPlayer = players.first();
        Node<Player> highestScore = players.first();
        do {
            rolls = dice.roll();
            String console = currentPlayer.data.getName() + " rolled " + rolls.get(0) + " and  " + rolls.get(1) + ". ";

            // If a player’s roll includes a 2, increase their score by double the roll
            // amount.
            if (rolls.contains(2)) {
                int score = (rolls.get(0) + rolls.get(1)) * 2;
                currentPlayer.data.addScore(score);
                console += "Lucky 2, score is now " + currentPlayer.data.getScore() + ".";
            }
            // If a player’s roll results in a total of 7, their score is decreased by 7
            // points, unless the roll
            // included a 2 which is treated as above. Note that scores do not go below 0.
            else if (rolls.get(0) + rolls.get(1) == 7) {
                currentPlayer.data.addScore(-7);
                console += "Unlucky 7, score is now " + currentPlayer.data.getScore() + ".";

            }

            // - If a player rolls a pair of 6s, their score is resets to 0 and the turn
            // taking order is reversed.
            else if (rolls.get(0) == 6 && rolls.get(1) == 6) {
                currentPlayer.data.resetScore();
                console += "Double 6, score is now " + currentPlayer.data.getScore() + ". Reverse direction.";
                players.reverse();
            }
            // - If the player rolls a pair of 1s, they are eliminated from the game.
            else if (rolls.get(0) == 1 && rolls.get(1) == 1) {
                eleminates.add(currentPlayer.data.getName());
                players.remove(currentPlayer.data);
                console += "Snake eyes! Player eliminated :(";
            } else {
                currentPlayer.data.addScore(rolls.get(0) + rolls.get(1));
                console += "Score is now " + currentPlayer.data.getScore() + ".";
            }
            System.out.println(console);
            highestScore = currentPlayer.data.getScore() > highestScore.data.getScore() ? currentPlayer : highestScore;
            if (highestScore.data.getScore() >= 100) {
                break;
            }
            currentPlayer = currentPlayer.next;
        } while (players.size() > 1);
        System.out.println(currentPlayer.data.name + " won the game! :)\n");

        System.out.println("Final scores:");
        System.out.println(players.toString());
        System.out.println("Eliminated " + eleminates.toString());

    }

}
