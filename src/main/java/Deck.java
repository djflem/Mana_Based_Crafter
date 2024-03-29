import java.util.HashMap;
import java.util.Map;

public class Deck {
    private final int DECK_SIZE = 100;
    private String name;
    private String colors;
    private Map<String,Integer> colorMap; //I need to put each color from colors into map and give it an amount equal to the color symbols
    private int landCount;

    public Deck(String name,String colors,int landCount){
        this.name = name;
        this.colors = colors;
        this.landCount = landCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public int getLandCount() {
        return landCount;
    }

    public void setLandCount(int landCount) {
        this.landCount = landCount;
    }

    public double getLandPercent(){
        return (double)landCount / DECK_SIZE * 100;
    }

    public int getNumberOfColors(){
        int numberOfColors = 0;

        for(int i = 0; i < colors.length(); i++) {
            numberOfColors++;
        }

        return numberOfColors;
    }

    public void addColor(String color,int amount){
        colorMap.put(color,amount);
    }




}
