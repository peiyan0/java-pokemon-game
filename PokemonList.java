import java.util.ArrayList;
import java.util.List;

public class PokemonList {
    // Attributes of a Pokemon
    private String name;
    private String type;
    private int hp;
    private String attackName;
    private int attackDamage;

    // Static list to store Pokemon instances
    private static List<PokemonList> pokemonList = new ArrayList<>();

    // Constructor to initialize a Pokemon
    public PokemonList(String name, String type, int hp, String attackName, int attackDamage) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attackName = attackName;
        this.attackDamage = attackDamage;
        
        // Add the newly created Pokemon to the list
        pokemonList.add(this);
    }

    // Getters and Setters for each attribute
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public String getAttackName() {
        return attackName;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    // Getter for the Pokemon list
    public static List<PokemonList> getPokemonList() {
        return pokemonList;
    }

    // Initialize the Pokemon list with all the Pokemon
    static {
        new PokemonList("Charmander", "Fire", 39, "Flame Burst", 70);
        new PokemonList("Bulbasaur", "Grass", 45, "Vine Whip", 45);
        new PokemonList("Squirtle", "Water", 44, "Water Gun", 40);
        new PokemonList("Pikachu", "Electric", 35, "Thunder Shock", 40);
        new PokemonList("Eevee", "Normal", 55, "Tackle", 40);
        new PokemonList("Rattata", "Normal", 30, "Quick Attack", 40);
        new PokemonList("Snorlax", "Normal", 160, "Body Slam", 85);
        new PokemonList("Flareon", "Fire", 65, "Flame Thrower", 90);
        new PokemonList("Vaporeon", "Water", 130, "Water Pulse", 60);
        new PokemonList("Jolteon", "Electric", 65, "Thunder", 110);
        new PokemonList("Leafeon", "Grass", 65, "Leaf Blade", 90);
        new PokemonList("Zapdos", "Electric", 90, "Thunderbolt", 90);
        new PokemonList("Moltres", "Fire", 90, "Fire Blast", 110);
        new PokemonList("Arcanine", "Fire", 90, "Fire Fang", 65);
        new PokemonList("Gloom", "Grass", 60, "Acid", 40);
    }

    public static void main(String[] args) {
        // Access the Pokemon list using the getter method
        List<PokemonList> pokemons = getPokemonList();

        // Displaying the details of each Pokemon
        for (PokemonList pokemon : pokemons) {
            System.out.println("Name: " + pokemon.getName() + ", Type: " + pokemon.getType() +
                               ", HP: " + pokemon.getHp() + ", Attack: " + pokemon.getAttackName() +
                               ", Damage: " + pokemon.getAttackDamage());
        }
    }
}
