import java.util.Random;

public class Die {
    int faces;

    Die() {
        faces = 6;
    }

    Die(int faces) {
        this.faces = faces;
    }

    public int roll() {
        Random rand = new Random();
        return rand.nextInt(faces) + 1;
    }

}
