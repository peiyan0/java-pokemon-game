import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Medal {
    private int medals;
    private List<MiracleItem> items;
    private Random random;

    class MiracleItem {
        private String name;

        public MiracleItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Medal() {
        this.medals = 0;
        this.items = new ArrayList<>();
        this.random = new Random();

        // Initialize the miracle items
        items.add(new MiracleItem("Attack Capsule"));
        items.add(new MiracleItem("Defense Capsule"));
        items.add(new MiracleItem("Quick Move Drink"));
        items.add(new MiracleItem("Spirit Drink"));
        items.add(new MiracleItem("Target Scope"));
        items.add(new MiracleItem("Poké Ball Power"));
    }

    public void convertDropsToMedals(int goldenChips, int goldenSands) {
        this.medals += goldenChips + goldenSands;
        System.out.println("Converted " + goldenChips + " Golden Chips and " + goldenSands + " Golden Sands into medals. Total medals: " + this.medals);
    }

    public MiracleItem miracleItemChance() {
        if (this.medals >= 10) { // Assuming 10 medals are needed for a Miracle Item Chance
            this.medals -= 10;
            return items.get(random.nextInt(items.size()));
        } else {
            System.out.println("Not enough Ga-Olé medals for a Miracle Item Chance.");
            return null;
        }
    }

    public static void main(String[] args) {
        Medal game = new Medal();
        game.convertDropsToMedals(5, 5); // Random example values
        Medal.MiracleItem miracleItem = game.miracleItemChance();

        if (miracleItem != null) {
            System.out.println("Miracle Item Chance activated! You got a " + miracleItem.getName());
        }
    }
}


