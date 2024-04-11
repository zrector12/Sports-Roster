package Finalproject.src;

class RB extends Player {
    public RB(String firstName, String lastName, int overallRating) {
        super(firstName, lastName, "RB", overallRating);
    }

    @Override
    public int getRankForTeam(Team team) {
        return (int) (overallRating * team.getPositionPriority("RB"));
    }
}
