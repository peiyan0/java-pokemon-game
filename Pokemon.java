import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Abstract class representing a Pokémon
abstract class Pokemon {
    String name;
    int level;
    int health;

    Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
        this.health = level * 10;
    }

    abstract void attack();

    void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " fainted!");
        } else {
            System.out.println(name + " took " + damage + " damage. Remaining health: " + health);
        }
    }
}

// Concrete class representing a Fire type Pokémon
class FirePokemon extends Pokemon {
    FirePokemon(String name, int level) {
        super(name, level);
    }

    @Override
    void attack() {
        System.out.println(name + " used Ember!");
    }
}

// Concrete class representing a Water type Pokémon
class WaterPokemon extends Pokemon {
    WaterPokemon(String name, int level) {
        super(name, level);
    }

    @Override
    void attack() {
        System.out.println(name + " used Water Gun!");
    }
}

// Concrete class representing a Water type Pokémon
class GrassPokemon extends Pokemon {
    GrassPokemon(String name, int level) {
        super(name, level);
    }

    @Override
    void attack() {
        System.out.println(name + " used Vine Whip!");
    }
}

// Concrete class representing an Electric type Pokémon
class ElectricPokemon extends Pokemon {
    ElectricPokemon(String name, int level) {
        super(name, level);
    }

    @Override
    void attack() {
        System.out.println(name + " used Thunder Shock!");
    }
}

// Concrete class representing a Normal type Pokémon
class NormalPokemon extends Pokemon {
    NormalPokemon(String name, int level) {
        super(name, level);
    }

    @Override
    void attack() {
        System.out.println(name + " used Tackle!");
    }
}

// Class representing a Trainer
class Trainer {
    String name;
    ArrayList<Pokemon> pokemons = new ArrayList<>();

    Trainer(String name) {
        this.name = name;
    }

    void catchPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        System.out.println(name + " caught a " + pokemon.name + "!");
    }

    void listPokemons() {
        System.out.println(name + "'s Pokemons:");
        for (Pokemon pokemon : pokemons) {
            System.out.println("- " + pokemon.name + " (Level " + pokemon.level + ")");
        }
    }
}

// Class representing a Pokémon Battle
class PokemonBattle {
    private Pokemon playerPokemon;
    private Pokemon enemyPokemon;

    PokemonBattle(Pokemon playerPokemon, Pokemon enemyPokemon) {
        this.playerPokemon = playerPokemon;
        this.enemyPokemon = enemyPokemon;
    }

    void startBattle() {
        System.out.println("Battle started!");

        while (playerPokemon.health > 0 && enemyPokemon.health > 0) {
            playerTurn();
            if (enemyPokemon.health > 0) {
                enemyTurn();
            }
        }

        System.out.println("Battle ended!");
    }

    private void playerTurn() {
        playerPokemon.attack();
        enemyPokemon.takeDamage(new Random().nextInt(5) + 1);
    }

    private void enemyTurn() {
        enemyPokemon.attack();
        playerPokemon.takeDamage(new Random().nextInt(5) + 1);
    }
}

