package Finalproject.src;

class QB extends Player {
    public QB(String firstName, String lastName, int overallRating) {super(firstName, lastName, "QB", overallRating);
    }

    @Override
    public int getRankForTeam(Team team) {return (int) (overallRating * team.getPositionPriority("QB"));
    }
}
