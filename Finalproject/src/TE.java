package Finalproject.src;

class TE extends Player {
    public TE(String firstName, String lastName, int overallRating) {
        super(firstName, lastName, "TE", overallRating);
    }

    @Override
    public int getRankForTeam(Team team) {
        return (int) (overallRating * team.getPositionPriority("TE"));
    }
}