package ExamPrep.guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity){
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addPlayer(Player player){
        if(this.roster.size() < capacity){
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        for (Player player : this.roster) {
            if(player.getName().equals(name)){
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name){
        for (Player player : this.roster) {
            if(player.getName().equals(name)){
                if(!player.getRank().equals("Member")){
                    player.setRank("Member");
                }
                break;
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : this.roster) {
            if(player.getName().equals(name)){
                if(!player.getRank().equals("Trial")){
                    player.setRank("Trial");
                }
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        Player[] kickedOnes = this.roster.stream()
                .filter(player -> player.getClazz().equals(clazz))
                .toArray(Player[]::new);
        this.roster = this.roster.stream().filter(player -> !player.getClazz().equals(clazz))
                .collect(Collectors.toList());
        return kickedOnes;
    }

    public int count(){
        return this.roster.size();
    }

    public String report(){
        StringBuilder fill = new StringBuilder();
        fill.append(String.format("Players in the ExamPrep.guild: %s:", this.name))
                .append(System.lineSeparator());
        for (Player player : this.roster) {
            fill.append(player.toString()).append(System.lineSeparator());
        }
        return fill.toString().trim();
    }

}
