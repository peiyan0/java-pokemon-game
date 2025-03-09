package Model.Pokemon;// pokemon's basic details

public class Pokemon {
    private String name;
    private String type;
    private int hp;
    private String attackName;
    private int attackDamage;

    // Constructor to initialize a Model.Pokemon1.Pokemon
    public Pokemon(String name, String type, int hp, String attackName, int attackDamage) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attackName = attackName;
        this.attackDamage = attackDamage;
    }

    // Getters
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

    @Override
    public String toString() {
        return String.format("%s (%s) \t\t- HP: %d, Move: %s (%d)", name, type, hp, attackName, attackDamage);
    }

    // METHODS
    public void attack() {
        System.out.println(name + " used " + attackName + "!");
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            System.out.println(name + " fainted!");
        } else {
            System.out.println(name + " took " + damage + " damage. Remaining hp: " + hp);
        }
    }
}
