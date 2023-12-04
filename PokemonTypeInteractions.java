// Define Pokemon types
enum PokemonType {
    NORMAL, FIRE, WATER, ELECTRIC, GRASS
}

// Create a class to manage type interactions
public class PokemonTypeInteractions {
    // Define effectiveness matrix
    private static double[][] effectiveness = {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 0, 1, 1, 0.5, 1}, // NORMAL
        {1, 0.5, 0.5, 1, 2, 2, 1, 1, 1, 1, 1, 2, 0.5, 1, 0.5, 1, 2, 1}, // FIRE
        {1, 2, 0.5, 1, 0.5, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0.5, 1, 1, 1}, // WATER
        {1, 1, 2, 0.5, 0, 1, 1, 1, 2, 2, 1, 1, 1, 1, 0.5, 1, 1, 1}, // ELECTRIC
        {1, 0.5, 2, 1, 0.5, 1, 1, 0.5, 0, 2, 1, 0.5, 2, 1, 0.5, 1, 0.5, 1}, // GRASS
    };

    // Method to get effectiveness of an attack from one type to another
    public static double getEffectiveness(PokemonType attackType, PokemonType defenseType) {
        return effectiveness[attackType.ordinal()][defenseType.ordinal()];
    }

    // Example usage
    public static void main(String[] args) {
        PokemonType attackType = PokemonType.GRASS;
        PokemonType defenseType = PokemonType.WATER;
        
        double effectiveness = getEffectiveness(attackType, defenseType);
        
        if (effectiveness > 1) {
            System.out.println(attackType + " is super effective against " + defenseType);
        } else if (effectiveness < 1) {
            System.out.println(attackType + " is not very effective against " + defenseType);
        } else {
            System.out.println(attackType + " has a normal effectiveness against " + defenseType);
        }
    }
}
