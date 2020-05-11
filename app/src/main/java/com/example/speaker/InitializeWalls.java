package com.example.speaker;

import java.util.ArrayList;
import java.util.List;

public class InitializeWalls {
    private List<Wall> AllWalls;

    public InitializeWalls(String map){
        if(map == "map1"){
            this.AllWalls = new ArrayList<Wall>();
            AllWalls.add(new Wall(84*3-30,84*3-30,1848*3-700,28*3));
            AllWalls.add(new Wall(84*3-30,1456*3-540,1848*3-700,28*3));
            AllWalls.add(new Wall(84*3-30,84*3-30,28*3,1370*3-440));
            AllWalls.add(new Wall(84*2-30+1848*3-700,84*3-30,28*3,1370*3-440));
        }

    }

    public List<Wall> getListWall(){
        return AllWalls;
    }
}
