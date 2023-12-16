import java.util.ArrayList;

public class PokemonList {
    // List to store Pokemon instances
    private static ArrayList<Pokemon> pokemonList = new ArrayList<>();

    // Initialize the Pokemon list with all the Pokemon
    static {
        pokemonList.add(new Pokemon("Charmander", "Fire", 78, "Flame Burst", 10));
        pokemonList.add(new Pokemon("Bulbasaur", "Grass", 90, "Vine Whip", 9));
        pokemonList.add(new Pokemon("Squirtle", "Water", 88, "Water Gun", 8));
        pokemonList.add(new Pokemon("Pikachu", "Electric", 70, "Thunder Shock", 8));
        pokemonList.add(new Pokemon("Eevee", "Normal", 110, "Tackle", 8));
        pokemonList.add(new Pokemon("Rattata", "Normal", 60, "Quick Attack", 8));
        pokemonList.add(new Pokemon("Snorlax", "Normal", 250, "Body Slam", 9));
        pokemonList.add(new Pokemon("Gloom", "Grass", 120, "Vine Whip", 8));
        pokemonList.add(new Pokemon("Flareon", "Fire", 130, "Flame Thrower", 15));
        pokemonList.add(new Pokemon("Vaporeon", "Water", 180, "Water Pulse", 13));
        pokemonList.add(new Pokemon("Jolteon", "Electric", 130, "Thunder", 14));
        pokemonList.add(new Pokemon("Leafeon", "Grass", 130, "Leaf Blade", 11));
        pokemonList.add(new Pokemon("Raikou", "Electric", 800, "Discharge", 25));
        pokemonList.add(new Pokemon("Entei", "Fire", 800, "Fire Fang", 25));
        pokemonList.add(new Pokemon("Suicune", "Water", 800, "Hydro Pump", 25));
    }

    // Getter for the Pokemon list
    public static ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
