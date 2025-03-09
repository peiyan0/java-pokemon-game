import Game.Battle;
import Game.Catch;
import Game.Scenario;
import Game.Score;
import Model.Medal;
import Model.Pokemon.Pokemon;
import Model.Pokemon.PokemonList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // POKEMON & POKEMONLIST & CATCH
        Catch pokeCatcher = new Catch();
        ArrayList<Pokemon> availablePokemon = PokemonList.getPokemonList();
        ArrayList<Pokemon> userPokemons = pokeCatcher.getPokemons();
        // BATTLE
        Battle battle = new Battle(userPokemons, availablePokemon);
        Score score = new Score();

        while (true) {
            System.out.println("\n------Choose An Option------\n");
            System.out.println("1. Start the game");
            System.out.println("2. View all Pokémon");
            System.out.println("3. See the ranking of battle scores");
            System.out.println("4. Exit");

            try {
                System.out.print("\nEnter your choice (1-4): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case 1:
                        // Start the game
                        System.out.println("\n------Starting The Game------\n");

                        // SCENARIO 
                        Scenario scenario = new Scenario();
                        scenario.chooseScenario();

                        // Display available Model.Pokemon1.Pokemon for catching
                        pokeCatcher.catchPokemon(availablePokemon, pokeCatcher);

                        // Prepare for battle
                        battle.displayBattleDetails();
                        battle.startBattle();

                        // After battle, check if Model.Pokemon1.Pokemon dropped golden chips and golden sands
                        Medal medals = new Medal();
                        medals.handleMedals();
                        System.out.println("\nCleaning The Game.Battle Stage.......\n");
                        break;
                    case 2:
                        // View all Pokémon
                        // implement pokemon figure
                        System.out.println("\n------All Pokémon------\n");
                        for (Pokemon pokemon : availablePokemon) {
                            System.out.println(pokemon);
                        }
                        break;
                    case 3:
                        // See the ranking of battle scores
                        score.displayTopScores();
                        break;
                    case 4:
                        // Exit the game
                        System.out.println("\n------Exiting the game------");
                        System.out.println("\nGoodbye!\n");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
