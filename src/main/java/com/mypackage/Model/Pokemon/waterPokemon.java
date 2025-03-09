package Model.Pokemon;

public class waterPokemon extends Pokemon {
    public waterPokemon(String name, int hp, String attackName, int attackDamage) {
        super(name, "Water", hp, attackName, attackDamage);
    }
    @Override
    public String toString() {
        return String.format("%s (Water) \t\t- HP: %d, Move: %s (%d)", getName(), getHp(), getAttackName(), getAttackDamage());
    }
}
