package main;

import game.HangmanGUI;
import game.HangmanLogic;

/**
 * Classe principale che avvia il gioco dell'impiccato.
 */
public class HangmanApp {
    public static void main(String[] args) {
        // Inizializza la logica del gioco
        HangmanLogic gameLogic = new HangmanLogic();

        // Inizializza l'interfaccia grafica passando la logica del gioco
        HangmanGUI gameGUI = new HangmanGUI(gameLogic);

        // Avvia il gioco
        gameGUI.startGame();
    }
}