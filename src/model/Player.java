package model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by oztiryakimeric on 9.12.2017.
 */
public class Player {
    private int id;
    private Color color;
    private ArrayList<Pirate> pirateList;
    private ArrayList<Symbol> deck;

    public Player(int id) {
        this.id = id;
        setColor();
        createPawns(6);
        deck = new ArrayList<>();
    }

    private void setColor(){
        switch(id){
            case 0: color = Color.blue;
                break;
            case 1: color = Color.yellow;
                break;
            case 2: color = Color.red;
                break;
            case 3: color = Color.green;
                break;
            case 4: color = Color.pink;
                break;
        }
    }

    private void createPawns(int count){
        pirateList = new ArrayList<>(count);

        for(int i=0; i<count; i++)
            pirateList.add(new Pirate());
    }

    public boolean isWinner(){
        int pawnInBoatCount = 0;
        for(Pirate p: pirateList)
            if(p.getCell().equals(BoatCell.getInstance()))
                pawnInBoatCount++;
        return pawnInBoatCount == 6;
    }

    public void addCard(Symbol card){
        deck.add(card);
    }

    public Color getColor(){
        return color;
    }

    public ArrayList<Symbol> getDeck() {
        return deck;
    }

    public ArrayList<Pirate> getPirateList() {
        return pirateList;
    }

    public int getId() {
        return id;
    }
}
