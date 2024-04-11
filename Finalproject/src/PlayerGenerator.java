package Finalproject.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class PlayerGenerator {
    private static final String[] First_names = {"John", "Michael", "David", "Christopher", "James", "Daniel", "Matthew", "Andrew", "Joseph", "Joshua"};
    private static final String[] Last_names = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
    private static final Random Random = new Random();

    public static List<Player> generatePlayers(int numQBs, int numWRs, int numRBs, int numTEs) {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < numQBs; i++) {
            players.add(new QB(getRandomFirstName(), getRandomLastName(), getRandomRating()));
        }

        for (int i = 0; i < numWRs; i++) {
            players.add(new WR(getRandomFirstName(), getRandomLastName(), getRandomRating()));
        }

        for (int i = 0; i < numRBs; i++) {
            players.add(new RB(getRandomFirstName(), getRandomLastName(), getRandomRating()));
        }

        for (int i = 0; i < numTEs; i++) {
            players.add(new TE(getRandomFirstName(), getRandomLastName(), getRandomRating()));
        }

        return players;
    }

    private static String getRandomFirstName() {
        return First_names[Random.nextInt(First_names.length)];
    }

    private static String getRandomLastName() {
        return Last_names[Random.nextInt(Last_names.length)];
    }

    private static int getRandomRating() {
        return Random.nextInt(100); // Random rating between 70 and 99
    }
}
