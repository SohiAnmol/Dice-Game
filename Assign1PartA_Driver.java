public class Assign1PartA_Driver {
    public static void main(String[] args) {
        System.out.println("The Dice Game!");

        Player p1 = new Player("Alvin");
        Player p2 = new Player("Simon");
        Player p3 = new Player("Theodore");
        Player p4 = new Player("David");

        Game game = new Game();
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);
        game.addPlayer(p4);
        game.simulateGame();
    }
}
