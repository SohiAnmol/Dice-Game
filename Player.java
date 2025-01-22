public class Player {
    String name;
    int score;

    Player(String playerName) {
        this.name = playerName;
        this.score = 0;
    }

    public void addScore(int score) {
        this.score += score;
        if (this.score < 0) {
            this.score = 0;
        }
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }


    public String toString() {
        return this.name + ": " + this.score;
    }
}
