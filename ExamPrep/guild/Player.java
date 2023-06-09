package ExamPrep.guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz){
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }
    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        //"Player {name}: {clazz}
        //Rank: {rank}
        //Description: {description}"
        StringBuilder fill = new StringBuilder();

        fill.append(String.format("Player %s: %s", getName(), getClazz())).append(System.lineSeparator());
        fill.append(String.format("Rank: %s", getRank())).append(System.lineSeparator());
        fill.append(String.format("Description: %s", getDescription()));
        return fill.toString();
    }

}
