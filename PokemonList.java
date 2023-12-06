import java.util.ArrayList;
import java.util.List;

public class PokemonList {
    // Attributes of a Pokemon
    private String name;
    private String type;
    private int hp;
    private String attackName;
    private int attackDamage;


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
        new PokemonList("Charmander", "Fire", 78, "Flame Burst", 10);
        new PokemonList("Bulbasaur", "Grass", 90, "Vine Whip", 9);
        new PokemonList("Squirtle", "Water", 88, "Water Gun", 8);
        new PokemonList("Pikachu", "Electric", 70, "Thunder Shock", 8);
        new PokemonList("Eevee", "Normal", 110, "Tackle", 8);
        new PokemonList("Rattata", "Normal", 60, "Quick Attack", 8);
        new PokemonList("Snorlax", "Normal", 250, "Body Slam", 9);
        new PokemonList("Gloom", "Grass", 120, "Vine Whip", 8);
        new PokemonList("Flareon", "Fire", 130, "Flame Thrower", 15);
        new PokemonList("Vaporeon", "Water",180, "Water Pulse", 13);
        new PokemonList("Jolteon", "Electric", 130, "Thunder", 14);
        new PokemonList("Leafeon", "Grass", 130, "Leaf Blade", 11);
        new PokemonList("Raikou", "Electric", 800, "Discharge", 25);
        new PokemonList("Entei", "Fire", 800, "Fire Fang", 25);
        new PokemonList("Suicune", "Water", 800, "Hydro Pump", 25);
        
    }

    // Determine if the Pokemon is Allied or Enemy and add it to the respective list
    if (name.equals("Charmander") || name.equals("Squirtle") || name.equals("Bulbasaur") || name.equals("Pikachu") || name.equals("Eevee")) {
        alliedPokemonList.add(this);
    } else {
        enemyPokemonList.add(this);
    }

    // Getter for the Allied Pokemon list
    public static List<PokemonList> getAlliedPokemonList() {
        return alliedPokemonList;
    }

    // Getter for the Enemy Pokemon list
    public static List<PokemonList> getEnemyPokemonList() {
        return enemyPokemonList;
    }

    public static void main(String[] args) {
        // Displaying the details of Allied Pokemons
        System.out.println("Allied Pokemons:");
        for (PokemonList pokemon : alliedPokemonList) {
            System.out.println("Name: " + pokemon.getName() + ", Type: " + pokemon.getType() +
                               ", HP: " + pokemon.getHp() + ", Attack: " + pokemon.getAttackName() +
                               ", Damage: " + pokemon.getAttackDamage());
        }

        // Displaying the details of Enemy Pokemons
        System.out.println("\nEnemy Pokemons:");
        for (PokemonList pokemon : enemyPokemonList) {
            System.out.println("Name: " + pokemon.getName() + ", Type: " + pokemon.getType() +
                               ", HP: " + pokemon.getHp() + ", Attack: " + pokemon.getAttackName() +
                               ", Damage: " + pokemon.getAttackDamage());
        }
    }
}
}
