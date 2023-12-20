public class MedalTest {
    public static void main(String[] args) {
        Medal game = new Medal();
        game.convertDropsToMedals(5, 5); // Random example values
        Medal.MiracleItem miracleItem = game.miracleItemChance();

        if (miracleItem != null) {
            System.out.println("Miracle Item Chance activated! You got a " + miracleItem.getName());
        }
    }
}
