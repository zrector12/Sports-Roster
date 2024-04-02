public class Player {
    private String fName;
    private String lName;
    private String position;
    private int OverallRating;
    private String playStyle;
    private int adaptability;
    public int getOverallRating() {
        return OverallRating;
    }
    public String getPlayStyle() {
        return playStyle;
    }
    public int getAdaptability() {
        return adaptability;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPosition() {
        return position;
    }

    public Player(String fName, String lName, String position, int overallRating, String playStyle, int adaptability) {
        this.fName = fName;
        this.lName = lName;
        this.position = position;
        OverallRating = overallRating;
        this.playStyle = playStyle;
        this.adaptability = adaptability;
    }
}
