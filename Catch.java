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
    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
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

    public void catchedPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
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

    public void catchPokemon(ArrayList<Pokemon> availablePokemon, Catch pokeCatcher) {
        Scanner scanner = new Scanner(System.in);
        int caughtPokemonCount = 0;

        // Allow the user to catch up to 3 Pokemon
        System.out.println("\nWild Pokemons have appear!");

        while (caughtPokemonCount < 3) {
            // Shuffle the list using a random seed
            Collections.shuffle(availablePokemon);

            // Display the first 6 Pokemon
            System.out.println("\nPokemon Name (Type) - HP, Move (Move damage)\n");

            for (int i = 0; i < 6; i++) {
                char choice1 = (char) ('a' + i);
                System.out.printf("%c. %s\n", 'a' + i, availablePokemon.get(i));
            }

            System.out.println("You can catch up to 3 Pokemons!");
            System.out.println("\nCatch Pokemon to make them yours (a-f) (eg. a):");

            char choice = scanner.nextLine().toLowerCase().charAt(0);

            // Validate user input
            if (choice < 'a' || choice > 'f') {
                System.out.println("Invalid input. Please choose a valid Pokemon (a-f).");
                continue;
            }

            int index = choice - 'a';

            Pokemon chosenPokemon = availablePokemon.get(index);

            // Display a message before catching the Pokemon
            System.out.println("Time to catch " + chosenPokemon.getName() + "!");

            // Check if the chosen Pokemon is already caught
            if (pokeCatcher.getPokemons().contains(chosenPokemon)) {
                System.out.println("\n"+chosenPokemon.getName() + " is already in your team. Choose a different one.");
                continue;
            }

            // Try to catch the chosen Pokemon
            PokeballType selectedPokeball = pokeCatcher.choosePokeballType();
            boolean catchSuccess = pokeCatcher.throwPokeball(chosenPokemon, selectedPokeball);

            if (catchSuccess) {
                pokeCatcher.catchedPokemon(chosenPokemon);
                caughtPokemonCount++;
            }
        }
    }

    public static void catchFaintedPokemon(ArrayList<Pokemon> faintedPokemons, Catch pokeCatcher) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("\nWild Pokemon has fainted!");
    
        // Display the fainted Pokemon
        System.out.println("Fainted Pokemon: ");
        for (Pokemon pokemon : faintedPokemons) {
            System.out.println(pokemon.getName());
        }
        System.out.println();
    
        // Ask the user if they want to catch the fainted Pokemon
        String catchChoice;
        boolean validChoice = false;
    
        do {
            System.out.println("Do you want to catch the fainted wild Pokemon? (y/n):");
            catchChoice = scanner.nextLine().toLowerCase();
    
            if ("y".equals(catchChoice) || "n".equals(catchChoice)) {
                validChoice = true;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
    
        } while (!validChoice);
    
        if ("y".equals(catchChoice)) {
            char choice;
    
            // Automatically choose the fainted Pokemon if only one has fainted
            if (faintedPokemons.size() == 1) {
                choice = 'a'; // Assuming the fainted Pokemon is the first one (index 0)
                System.out.println("Catching fainted Pokemon: " + faintedPokemons.get(0).getName());
            } else {
                // Allow the user to choose a Pokemon to catch
                System.out.println("Choose a Pokemon to catch (a-b):");
                choice = scanner.nextLine().toLowerCase().charAt(0);
    
                // Validate user input
                if (choice < 'a' || choice > 'b') {
                    System.out.println("Invalid input. You chose not to catch the fainted wild Pokemon.");
                    return;
                }
            }
    
            int index = choice - 'a';
            Pokemon chosenPokemon = faintedPokemons.get(index);
    
            // Try to catch the chosen Pokemon
            PokeballType selectedPokeball = pokeCatcher.choosePokeballType();
            boolean catchSuccess = pokeCatcher.throwPokeball(chosenPokemon, selectedPokeball);
    
            if (catchSuccess) {
                pokeCatcher.catchedPokemon(chosenPokemon);
                System.out.println("You caught the fainted wild Pokemon!");
            } else {
                System.out.println("You failed to catch the fainted wild Pokemon.");
            }
        } else {
            System.out.println("You chose not to catch the fainted wild Pokemon.");
        }
    }
}    