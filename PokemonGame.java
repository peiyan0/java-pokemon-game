import java.util.Scanner;

public class PokemonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create trainers and Pokémon
        Trainer ash = new Trainer("Ash");
        Trainer brock = new Trainer("Brock");

        FirePokemon charmander = new FirePokemon("Charmander", 5);
        WaterPokemon squirtle = new WaterPokemon("Squirtle", 5);

        // Ash catches Pokémon
        ash.catchPokemon(charmander);
        brock.catchPokemon(squirtle);

        // Display trainer's Pokémon
        ash.listPokemons();
        brock.listPokemons();

        // Start a battle
        PokemonBattle battle = new PokemonBattle(charmander, squirtle);
        battle.startBattle();

        scanner.close();
    }
}