import java.util.*;

public class Test {
/*     private List<PokemonList> userPokemon;
    private List<PokemonList> wildPokemon;
    private List<PokemonList> opponentPokemon; 
    //private static Catch pokeCatcher;  // Add an instance of the Catch class

    public Test() {
        this.userPokemon = new ArrayList<>();
        this.wildPokemon = new ArrayList<>();
        this.opponentPokemon = new ArrayList<>();
        //this.pokeCatcher = pokeCatcher;
    }
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String welcomeMessage = "";

        while (true) {
            // Display available scenarios
            System.out.println("Choose a scenario:");
            System.out.println("A. Alien Invasion");
            System.out.println("B. Treasure Hunt");
            System.out.println("C. Time Travel Dilemma");

            // Get user input
            System.out.print("Enter your choice (A, B, or C): ");
            String scenarioChoice = scanner.nextLine().toUpperCase();
            System.out.println("");

            // Modify welcome message based on the scenario choice
            switch (scenarioChoice) {
                case "A":
                    welcomeMessage = "Welcome to the Alien Invasion battle stage!";
                    break;
                case "B":
                    welcomeMessage = "Welcome to the Treasure Hunt battle stage!";
                    break;
                case "C":
                    welcomeMessage = "Welcome to the Time Travel Dilemma battle stage!";
                    break;
                default:
                    System.out.println("Invalid scenario choice. Please choose A, B, or C.");
                    continue; // Continue the loop to ask for input again
            }

            break; // Break the loop if a valid scenario choice is entered
        }
        System.out.println(welcomeMessage);

        // POKEMON & POKEMONLIST & CATCH

        // Create an instance of Catch
        Catch pokeCatcher = new Catch();

        // Display available Pokemon for catching
        ArrayList<Pokemon> availablePokemon = PokemonList.getPokemonList();

        pokeCatcher.catchPokemon(availablePokemon, pokeCatcher);

        // Display the user's caught Pokemon
        System.out.println("\nYour caught Pokemons:");
        ArrayList<Pokemon> userPokemons = pokeCatcher.getPokemons();
        for (Pokemon userPokemon : userPokemons) {
            System.out.println(userPokemon.getName());
        }

        // Display the user's caught Pokemon info
        System.out.println("\nThis will be your Pokemon choice during battle: \b");
        for (Pokemon userPokemon : userPokemons) {
            System.out.println(userPokemon);
        }

        
        // BATTLE
        Battle battle = new Battle(userPokemons, availablePokemon);

        ArrayList<Pokemon> enemyPokemons = battle.getEnemyPokemons();

        // Prepare for battle
        System.out.println("\nNow...\nTwo wild Pokemons have appeared: " + enemyPokemons.get(0).getName() + " and " + enemyPokemons.get(1).getName() + "\n");


        battle.displayBattleDetails();
        battle.startBattle();

    }

}
