import java.util.Random;
import java.util.Scanner;

public class ScenarioGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Display available scenarios
        System.out.println("Choose a scenario:");
        System.out.println("A. Alien Invasion");
        System.out.println("B. Treasure Hunt");
        System.out.println("C. Time Travel Dilemma");

        // Get user input
        System.out.print("Enter your choice (A, B, or C): ");
        String userChoice = scanner.nextLine().toUpperCase();

        // Validate user input
        if (userChoice.equals("A") || userChoice.equals("B") || userChoice.equals("C")) {
            // Randomly choose one of the scenarios
            String chosenScenario = getRandomScenario(userChoice);

            // Display the result
            System.out.println("\nResult:");
            System.out.println(chosenScenario);
        } else {
            System.out.println("Invalid choice. Please choose A, B, or C.");
        }

        scanner.close();
    }

    private static String getRandomScenario(String userChoice) {
        String[] scenarios = {"Alien Invasion", "Treasure Hunt", "Time Travel Dilemma"};
        Random random = new Random();

        // Shuffle the scenarios to make the selection random
        for (int i = scenarios.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap scenarios[index] and scenarios[i]
            String temp = scenarios[index];
            scenarios[index] = scenarios[i];
            scenarios[i] = temp;
        }

        // If the user's choice is in the shuffled array, return it; otherwise, return a random scenario
        for (String scenario : scenarios) {
            if (scenario.toLowerCase().contains(userChoice.toLowerCase())) {
                return scenario;
            }
        }

        return scenarios[random.nextInt(scenarios.length)];
    }
    
}
