package Finalproject.src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate players
        List<Player> players = PlayerGenerator.generatePlayers(10, 20, 20, 10);
        System.out.println(players);
        // Create teams and set position priorities
        List<Team> teams = new ArrayList<>();
        System.out.print("Enter the number of teams: ");
        int numTeams = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= numTeams; i++) {
            System.out.print("Enter the name for Team " + i + ": ");
            String teamName = scanner.nextLine();
            Team team = new Team(teamName);

            System.out.println("Enter position priorities for " + teamName + " (between 0 and 1):");
            System.out.print("QB priority: ");
            double qbPriority = scanner.nextDouble();
            team.setPositionPriority("QB", qbPriority);

            System.out.print("WR priority: ");
            double wrPriority = scanner.nextDouble();
            team.setPositionPriority("WR", wrPriority);

            System.out.print("RB priority: ");
            double rbPriority = scanner.nextDouble();
            team.setPositionPriority("RB", rbPriority);

            System.out.print("TE priority: ");
            double tePriority = scanner.nextDouble();
            team.setPositionPriority("TE", tePriority);

            scanner.nextLine(); // Consume the newline character

            teams.add(team);
        }

        // Draft process
        int numRounds = 10; // Number of rounds in the draft

        for (int round = 1; round <= numRounds; round++) {
            System.out.println("Round " + round);

            for (Team team : teams) {
                PriorityQueue<Player> draftPool = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getRankForTeam(team), p1.getRankForTeam(team)));
                draftPool.addAll(players);

                Player pickedPlayer = draftPool.poll();
                if (pickedPlayer != null) {
                    team.addPlayer(pickedPlayer);
                    System.out.println(team.getName() + " picked " + pickedPlayer);
                    players.remove(pickedPlayer);
                } else {
                    System.out.println("No more players available for draft");
                    break;
                }
            }
        }

        // Print team rosters
        for (Team team : teams) {
            System.out.println("\n" + team.getName() + " Roster:");
            team.printRoster();
        }

        scanner.close();
    }
}