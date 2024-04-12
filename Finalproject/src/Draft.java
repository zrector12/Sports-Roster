package Finalproject.src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Draft {
    private List<Team> teams;
    private List<Player> players;
    private Scanner scanner;

    public Draft() {
        scanner = new Scanner(System.in);
        players = PlayerGenerator.generatePlayers(10, 20, 20, 10);
        teams = new ArrayList<>();
        createTeams();
    }

    private void createTeams() {
        System.out.print("Enter the number of teams: ");
        int numTeams = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= numTeams; i++) {
            System.out.print("Enter the name for Team " + i + ": ");
            String teamName = scanner.nextLine();

            if (teamName.isEmpty()) {
                System.out.println("Error: Team name cannot be empty.");
                i--;
                continue;
            }

            Team team = new Team(teamName);

            System.out.println("Enter position priorities for " + teamName + " (between 0 and 1):");

            double qbPriority = getValidPriority(scanner, "QB priority: ");
            team.setPositionPriority("QB", qbPriority);

            double wrPriority = getValidPriority(scanner, "WR priority: ");
            team.setPositionPriority("WR", wrPriority);

            double rbPriority = getValidPriority(scanner, "RB priority: ");
            team.setPositionPriority("RB", rbPriority);

            double tePriority = getValidPriority(scanner, "TE priority: ");
            team.setPositionPriority("TE", tePriority);

            teams.add(team);
        }
    }

    private static double getValidPriority(Scanner scanner, String prompt) {
        double priority;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                priority = scanner.nextDouble();
                if (priority >= 0 && priority <= 1) {
                    scanner.nextLine(); // Consume the newline character
                    return priority;
                } else {
                    System.out.println("Error: Priority must be between 0 and 1.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a number between 0 and 1.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    public void runDraft() {
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

        printTeamRosters();
        scanner.close();
    }

    private void printTeamRosters() {
        for (Team team : teams) {
            System.out.println("\n" + team.getName() + " Roster:");
            team.printRoster();
        }
    }
}
