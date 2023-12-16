import java.util.*;

enum PokeballType {
    POKEBALL, GREATBALL, ULTRABALL, MASTERBALL
}

public class Catch {
    private static final int CATCH_GAUGE_FULL = 100;
    private static final int POKEBALL_SUCCESS_RATE = 20;
    private static final int GREATBALL_SUCCESS_RATE = 40;
    private static final int ULTRABALL_SUCCESS_RATE = 60;
    private static final int MASTERBALL_SUCCESS_RATE = 80;

    private ArrayList<Pokemon> pokemons; 
    private int catchGauge;

    public Catch() {
        this.pokemons = new ArrayList<>();
        this.catchGauge = 0;
    }

    public int getCatchGauge() {
        return catchGauge;
    }

    public boolean canCatch() {
        return catchGauge < CATCH_GAUGE_FULL; 
    }

    public boolean throwPokeball(Pokemon pokemon, PokeballType pokeballType) {
        int successRate = getSuccessRate(pokeballType);

        // Check if the catch gauge allows catching the Pokemon
        if (canCatch()) {
            // Generate a random number to determine if the catch is successful
            Random random = new Random();
            int randomValue = random.nextInt(100) + 1; // 1 to 100

            if (randomValue <= successRate) {
                System.out.println("\nCaught " + pokemon.getName() + " with a " + pokeballType + "!");
                return true;
            } else {
                System.out.println("\nFailed to catch " + pokemon.getName() + " with a " + pokeballType + ".");
            }
        } else {
            System.out.println("The catch gauge is full. Can't catch more Pokemon.");
        }

        return false;
    }

    public PokeballType choosePokeballType() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nChoose a Pokeball type:");
        System.out.println("1. Pokeball");
        System.out.println("2. Greatball");
        System.out.println("3. Ultraball");
        System.out.println("4. Masterball");

        int choice;
        do {
            System.out.print("\nEnter your choice (1-4): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 4);

        switch (choice) {
            case 1:
                return PokeballType.POKEBALL;
            case 2:
                return PokeballType.GREATBALL;
            case 3:
                return PokeballType.ULTRABALL;
            case 4:
                return PokeballType.MASTERBALL;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    public void catchPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    private int getSuccessRate(PokeballType pokeballType) {
        switch (pokeballType) {
            case POKEBALL:
                return POKEBALL_SUCCESS_RATE;
            case GREATBALL:
                return GREATBALL_SUCCESS_RATE;
            case ULTRABALL:
                return ULTRABALL_SUCCESS_RATE;
            case MASTERBALL:
                return MASTERBALL_SUCCESS_RATE;
            default:
                return 0; // Handle unknown Pokeball types
        }
    }
}