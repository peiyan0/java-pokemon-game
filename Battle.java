import java.util.*;

public class Battle {
    private ArrayList<Pokemon> userPokemons;
    private ArrayList<Pokemon> enemyPokemons;
    private ArrayList<Pokemon> availablePokemons; 
    private ArrayList<Pokemon> faintedPokemons;

    public Battle(ArrayList<Pokemon> userPokemons, ArrayList<Pokemon> availablePokemons) {
        this.userPokemons = userPokemons;
        this.availablePokemons = availablePokemons;
        this.faintedPokemons = new ArrayList<>();
        initializeEnemyPokemons(availablePokemons);
    }
    
    public ArrayList<Pokemon> getUserPokemons() {
        return userPokemons;
    }
    public ArrayList<Pokemon> getEnemyPokemons() {
        return enemyPokemons;
    }
    public ArrayList<Pokemon> getAvailablePokemons() {
        return availablePokemons;
    }
    public ArrayList<Pokemon> getFaintedPokemons() {
        return faintedPokemons;
    }


    public void initializeEnemyPokemons(ArrayList<Pokemon> availablePokemons) {
        enemyPokemons = new ArrayList<>(availablePokemons);
        enemyPokemons.removeAll(userPokemons);

        // Ensure there are at least 2 remaining Pokemon to choose from
        if (enemyPokemons.size() >= 2) {
            // Randomly choose 2 enemy Pokemon
            Collections.shuffle(enemyPokemons);
            enemyPokemons = new ArrayList<>(enemyPokemons.subList(0, 2));
        } else {
            System.out.println("Not enough remaining Pokemon for enemies.");
            // Handle this situation according to your game logic
            enemyPokemons = new ArrayList<>(); // or handle it differently
        }
    }

    public void displayBattleDetails() {
        System.out.println("The battle is about to start. Here are the details of the upcoming encounter:");

        // Displaying the details of Allied Pokemons
        System.out.println("\nAllied Pokemons:\n");
        for (Pokemon userPokemon : userPokemons) {
            System.out.println(userPokemon);
        }

        // Displaying the details of Enemy Pokemons
        System.out.println("\nEnemy Pokemons:\n");
        for (Pokemon enemyPokemon : enemyPokemons) {
            System.out.println(enemyPokemon);
        }
    }

    private Pokemon chooseUserPokemonForBattle(int round) {
        Scanner scanner = new Scanner(System.in);
    
        // Display user's Pokémon
        System.out.println("\nYour Pokemons:");
        for (int i = 0; i < userPokemons.size(); i++) {
            char choice = (char) ('a' + i);
            System.out.printf("%c. %s\n", choice, userPokemons.get(i));
        }
        System.out.println("\nRound " + round + ": Choose 1 Pokemon for the battle (a-c):");

        char choice = scanner.nextLine().toLowerCase().charAt(0);

        if (choice < 'a' || choice > 'c') {
            System.out.println("Invalid input. Please choose a valid Pokemon (a-c).");
            return null; // Return null in case of invalid input
        }

        int index = choice - 'a';
        Pokemon chosenPokemon = userPokemons.get(index);
        
        // Display a message indicating the chosen Pokemon
        System.out.println(chosenPokemon.getName() + " is chosen for the battle.");
    
        return chosenPokemon;
    }

    public void startBattle() {
        Catch pokeCatcher = new Catch();
        int userTotalScore = 0;
        int computerTotalScore = 0;
    
        for (int round = 1; round <= 2; round++) {
            Pokemon userPokemon = chooseUserPokemonForBattle(round);
            Pokemon computerPokemon = enemyPokemons.get(round - 1);
    
            System.out.println("\nBattle Start!\n");
    
            while (userPokemon.getHp() > 0 && computerPokemon.getHp() > 0) {
                playerTurn(userPokemon, computerPokemon);
                if (computerPokemon.getHp() > 0) {
                    enemyTurn(userPokemon, computerPokemon);
                }
            }
    
            // Display battle results after each battle
            displayBattleResults(userPokemon, computerPokemon);
    
            // Update total scores based on remaining HP
            userTotalScore += userPokemon.getHp();
            computerTotalScore += computerPokemon.getHp();
    
            // Display round information
            System.out.println("Round " + round + ": Total Scores - User: " + userTotalScore + ", Computer: " + computerTotalScore);
        }
    
        // Check if the wild Pokémon has fainted after both battles
        if (enemyPokemons.get(0).getHp() <= 0 || enemyPokemons.get(1).getHp() <= 0) {
            // Add the fainted Pokemons to the list
            if (enemyPokemons.get(0).getHp() <= 0) {
                faintedPokemons.add(enemyPokemons.get(0));
            }
            if (enemyPokemons.get(1).getHp() <= 0) {
                faintedPokemons.add(enemyPokemons.get(1));
            }

            // Call the catchFaintedPokemon function for the fainted Pokemons
            Catch.catchFaintedPokemon(faintedPokemons, pokeCatcher);

            // Calculate remaining HP as the total score
            int remainingHp1 = Math.max(0, enemyPokemons.get(0).getHp());
            int remainingHp2 = Math.max(0, enemyPokemons.get(1).getHp());
            userTotalScore += remainingHp1 + remainingHp2;
            computerTotalScore -= remainingHp1 + remainingHp2;
    
            System.out.println("Total Scores - User: " + userTotalScore + ", Computer: " + computerTotalScore);
        }
    
        // Display overall battle end message
        System.out.println("\nBattle ended! Total Scores - User: " + userTotalScore + ", Computer: " + computerTotalScore);
    }
    
    
    

    private void playerTurn(Pokemon playerPokemon, Pokemon enemyPokemon) {
        playerPokemon.attack();
        enemyPokemon.takeDamage((int) (Math.random() * 50) + 1);
    }

    private void enemyTurn(Pokemon playerPokemon, Pokemon enemyPokemon) {
        enemyPokemon.attack();
        playerPokemon.takeDamage((int) (Math.random() * 50) + 1);
    }

    private void displayBattleResults(Pokemon playerPokemon, Pokemon enemyPokemon) {
        System.out.println("\nBattle results:\n");
        System.out.println("Player's Pokemon: " + playerPokemon);
        System.out.println("Enemy's Pokemon: " + enemyPokemon);

        // Determine effectiveness
        double effectiveness = PokemonTypeInteractions.getEffectiveness(playerPokemon, enemyPokemon);

        if (effectiveness > 1) {
            System.out.println(playerPokemon.getName() + " is super effective against " + enemyPokemon.getName());
        } else if (effectiveness < 1) {
            System.out.println(playerPokemon.getName() + " is not very effective against " + enemyPokemon.getName());
        } else {
            System.out.println(playerPokemon.getName() + " has a normal effectiveness against " + enemyPokemon.getName());
        }

        System.out.println();
    }
}