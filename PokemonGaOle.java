import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum PokemonType {
    FIRE, WATER, GRASS, ELECTRIC
}

enum PokeballType {
    POKEBALL, GREATBALL, ULTRABALL, MASTERBALL
}
// defender type, moving type, z-move, grade, 
class Pokemon {
    String name;
    int hp;
    PokemonType type;

    public Pokemon(String name, int hp, PokemonType type) {
        this.name = name;
        this.hp = hp;
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("Name: %s\nHP: %d\nType: %s\n\n",name,hp,type);
    }
}

class PlayerPokemon extends Pokemon {
    public PlayerPokemon(String name, int hp, PokemonType type) {
        super(name, hp, type);
    }
}

class WildPokemon extends Pokemon {
    public WildPokemon(String name, int hp, PokemonType type) {
        super(name, hp, type);
    }
}

class Pokeball {
    PokeballType type;

    public Pokeball(PokeballType type) {
        this.type = type;
    }
}

class Battle {
    PlayerPokemon playerPokemon;
    WildPokemon wildPokemon1;
    WildPokemon wildPokemon2;

    public Battle(PlayerPokemon playerPokemon, WildPokemon wildPokemon1, WildPokemon wildPokemon2) {
        this.playerPokemon = playerPokemon;
        this.wildPokemon1 = wildPokemon1;
        this.wildPokemon2 = wildPokemon2;
    }
    
}

class PokemonGaOleGame {
    List<PlayerPokemon> playerPokemons;
    List<WildPokemon> wildPokemons;

    public PokemonGaOleGame() {
        playerPokemons = new ArrayList<>();
        wildPokemons = new ArrayList<>();
        // Initialize Pokemon and Pokeballs
        // ...
    }
}

public class PokemonGaOle {
    public static void main(String[] args) {
        PokemonGaOleGame game = new PokemonGaOleGame();

        PlayerPokemon playerPokemon = new PlayerPokemon("Charmander", 100, PokemonType.FIRE);
        WildPokemon wildPokemon1 = new WildPokemon("Squirtle", 80, PokemonType.WATER);
        WildPokemon wildPokemon2 = new WildPokemon("Bulbasaur", 90, PokemonType.GRASS);

        Battle battle = new Battle(playerPokemon, wildPokemon1, wildPokemon2);

        System.out.println(playerPokemon);
        System.out.println(wildPokemon1);        
        System.out.println(wildPokemon2);
        // Perform game actions
        // ...

        // Check results
        // ...
    }
}
