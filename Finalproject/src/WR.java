package Finalproject.src;

class WR extends Player {
    public WR(String firstName, String lastName, int overallRating) {
        super(firstName, lastName, "WR", overallRating);
    }

    @Override
    public int getRankForTeam(Team team) {
        return (int) (overallRating * team.getPositionPriority("WR"));
    }
}