package test;

public enum OzWitch {
    WEST("Miss west"),
    NORTH("North"),
    EAST("WAST"),
    SOUTH("south");

    private String description;

    private OzWitch(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args){
        for(OzWitch witch : OzWitch.values()){
            System.out.println(witch + ": "+ witch.getDescription());
        }
    }
}
