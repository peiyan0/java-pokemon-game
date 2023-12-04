import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Class representing a Pokémon Catching Game
class PokemonCatchingGame {
    private static final int MAX_POKEMON_TO_CATCH = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a trainer for the catching game
        Trainer catchingTrainer = new Trainer("Catcher");

        // Start the catching game
        for (int i = 0; i < MAX_POKEMON_TO_CATCH; i++) {
            System.out.println("\nCatch Pokemon #" + (i + 1));
            Pokemon wildPokemon = getRandomWildPokemon();
            System.out.println("A wild " + wildPokemon.name + " appeared!");

            // Give the player an option to catch or skip the Pokémon
            System.out.print("Do you want to catch it? (yes/no): ");
            String catchChoice = scanner.nextLine().toLowerCase();

            if (catchChoice.equals("yes")) {
                catchingTrainer.catchPokemon(wildPokemon);
            } else {
                System.out.println("You decided not to catch the wild " + wildPokemon.name + ".");
            }
        }

        // Display the caught Pokémon
        System.out.println("\nCaught Pokémons:");
        catchingTrainer.listPokemons();

        // Choose a Pokémon for battle
        if (!catchingTrainer.pokemons.isEmpty()) {
            System.out.println("\nChoose a Pokémon for battle:");
            Pokemon chosenPokemon = catchingTrainer.choosePokemon();
            System.out.println("You chose " + chosenPokemon.name + " for battle!");
            // Now you can proceed to the battle with the chosen Pokémon
        } else {
            System.out.println("You didn't catch any Pokémon for battle.");
        }

        scanner.close();
    }

    private static Pokemon getRandomWildPokemon() {
        Random random = new Random();
        int randomLevel = random.nextInt(5) + 1; // Random level between 1 and 5

        // Randomly choose between Fire and Water type Pokémon
        if (random.nextBoolean()) {
            return new FirePokemon("Wild Charmander", randomLevel);
        } else {
            return new WaterPokemon("Wild Squirtle", randomLevel);
        }
    }
}

// ... (rest of the code remains unchanged)
