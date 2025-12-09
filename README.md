# Pokémon Ga-Olé Battle Simulator (Java)

> A classic, terminal-based Pokémon Battle Game implemented entirely in **Java**. This project simulates core game mechanics—catching, battling, and a performance-based ranking system—to demonstrate object-oriented design principles.

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-fc3003?style=for-the-badge&logo=java&logoColor=white" alt="Language: Java" />
  <img src="https://img.shields.io/badge/Platform-Console%20|%20Terminal-2b2524?style=for-the-badge" alt="Platform: Console | Terminal" />
</p>

## ✨ Game Mechanics & Features

| Icon | Feature | Description |
| :---: | :--- | :--- |
| 🥊 | **Core Battle System** | Logic implemented in the `Battle` class to handle turns, damage calculation, and determining winners based on Pokémon attributes (HP, Attack). |
| 🎣 | **Catch System** | Allows players to **catch** different types of Pokémon, expanding their in-game roster. |
| 🏅 | **Medal System** | Players earn **medals** based on their battle performance and achievements, tracked by the `Medal` class. |
| 📈 | **Score Ranking** | A dedicated system to manage, calculate, and display player rankings based on accumulated battle scores. |
| 📚 | **Model Integrity** | Comprehensive `Pokemon` objects define attributes (Name, Type, HP, Damage) to drive battle outcomes. |

## 📐 Object-Oriented Project Structure

The project utilizes a clean package structure to separate the game mechanics from the data models:

| Package | Key Classes | Responsibility |
| :--- | :--- | :--- |
| `Game` | `MainGame`, `Battle`, `Catch`, `Scenario`, `Score` | Handles the overall flow, user interaction, and game processes. |
| `Model` | `Pokemon`, `PokemonList`, `Medal` | Defines the core data entities and their properties. |

## 🚀 Usage

To start the game, simply run the `MainGame` class. Follow the on-screen instructions to access the various features:

* **Start the Game**: Begin a new scenario and an engagement sequence.
* **View All Pokémon**: See a comprehensive list of all available Pokémon and their stats.
* **See Battle Scores**: Check the ranking of all players based on their battle performance.
* **Exit**: Terminate the application.
