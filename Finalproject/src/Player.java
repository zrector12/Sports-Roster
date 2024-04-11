package Finalproject.src;

abstract class Player implements Comparable<Player> {
    protected String firstName;
    protected String lastName;
    protected String position;
    protected int overallRating;

    public Player(String firstName, String lastName, String position, int overallRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.overallRating = overallRating;
    }

    public int getOverallRating() {
        return overallRating;
    }

    public abstract int getRankForTeam(Team team);

    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.overallRating, this.overallRating);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + position + ") - Overall Rating: " + overallRating;
    }
}
