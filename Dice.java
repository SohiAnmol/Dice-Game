import java.util.ArrayList;

public class Dice {
    Die dice1;
    Die dice2;

    Dice() {
        this.dice1 = new Die();
        this.dice2 = new Die();
    }

    Dice(int face1, int face2) {
        this.dice1 = new Die(face1);
        this.dice2 = new Die(face2);
    }

    public ArrayList<Integer> roll() {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        rolls.add(this.dice1.roll());
        rolls.add(this.dice2.roll());
        return rolls;
    }

}
