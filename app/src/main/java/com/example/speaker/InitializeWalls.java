package com.example.speaker;

import java.util.ArrayList;
import java.util.List;

public class InitializeWalls {
    private List<Wall> AllWalls;

    public InitializeWalls(String map){
        if(map == "map1"){
            this.AllWalls = new ArrayList<Wall>();

            // 0.378

            //outer
            AllWalls.add(new Wall(84*3-30,84*3-30,1848*3-700,28*3));
            AllWalls.add(new Wall(84*3-30,1456*3-540,1848*3-700,28*3));
            AllWalls.add(new Wall(84*3-30,84*3-30,28*3,1370*3-440));
            AllWalls.add(new Wall(84*2-30+1848*3-700,84*3-30,28*3,1370*3-440));

            //inner
            AllWalls.add(new Wall(450*3-170+84,225*3-90,1120*3-430-84*2,28*3));
            AllWalls.add(new Wall(450*3-170+84,225*3-80+950*3,1120*3-430-84*2,28*3));
            AllWalls.add(new Wall(225*3-90,225*3-90,28*3,530*3-200-84));
            AllWalls.add(new Wall(225*3-90,860*3-300,28*3,530*3-180-84*2));
            AllWalls.add(new Wall(1770*3-680,225*3-90,28*3,530*3-200-84));
            AllWalls.add(new Wall(1770*3-680,860*3-300,28*3,530*3-180-84*2));
            AllWalls.add(new Wall(225*3-90,225*3-90,110*3-45,28*3));
            AllWalls.add(new Wall(1680*3-635,225*3-90,110*3-45,28*3));
            AllWalls.add(new Wall(225*3-90,225*3-80+950*3,110*3-45,28*3));
            AllWalls.add(new Wall(1680*3-635,225*3-80+950*3,110*3-45,28*3));

            //mainbuild
            AllWalls.add(new Wall(730*3-275,590*3-225,225*3-90,28*3));
            AllWalls.add(new Wall(1100*3-415,590*3-225,225*3-90,28*3));
            AllWalls.add(new Wall(730*3-275,980*3-370,225*3-90,28*3));
            AllWalls.add(new Wall(1100*3-415,980*3-370,225*3-90,28*3));
            AllWalls.add(new Wall(730*3-275,590*3-225,28*3,140*3-50));
            AllWalls.add(new Wall(730*3-275,870*3-330,28*3,140*3-50));
            AllWalls.add(new Wall(1290*3-490,590*3-225,28*3,140*3-50));
            AllWalls.add(new Wall(1290*3-490,870*3-330,28*3,140*3-50));

            //upbuild
            AllWalls.add(new Wall(810*3-300,280*3-110,420*3-160,28*3));
            AllWalls.add(new Wall(810*3-300,440*3-160,140*3-50,28*3));
            AllWalls.add(new Wall(1060*3-310,440*3-160,140*3-50,28*3));
            AllWalls.add(new Wall(810*3-300,280*3-110,28*3,200*3-80));
            AllWalls.add(new Wall(1200*3-450,280*3-110,28*3,200*3-80));

            //downbuild
            AllWalls.add(new Wall(810*3-300,1260*3-475,420*3-160,28*3));
            AllWalls.add(new Wall(810*3-300,1100*3-440,140*3-50,28*3));
            AllWalls.add(new Wall(1060*3-310,1100*3-440,140*3-50,28*3));
            AllWalls.add(new Wall(810*3-300,1100*3-440,28*3,200*3-80));
            AllWalls.add(new Wall(1200*3-450,1100*3-440,28*3,200*3-80));

            //smallhouse one
            AllWalls.add(new Wall(480*3-190,335*3-125,200*3-85,28*3));
            AllWalls.add(new Wall(480*3-190,560*3-210,200*3-85,28*3));
            AllWalls.add(new Wall(640*3-240,335*3-125,28*3,250*3-95));
            AllWalls.add(new Wall(480*3-190,335*3-125,28*3,54*3-20));
            AllWalls.add(new Wall(480*3-190,500*3-190,28*3,84*3-30));

            //smallhouse two
            AllWalls.add(new Wall(480*3-190,(335+650)*3-125-260,200*3-85,28*3));
            AllWalls.add(new Wall(480*3-190,(560+650)*3-210-260,200*3-85,28*3));
            AllWalls.add(new Wall(640*3-240,(335+650)*3-125-260,28*3,250*3-95));
            AllWalls.add(new Wall(480*3-190,(335+650)*3-125-260,28*3,84*3-20));
            AllWalls.add(new Wall(480*3-190,(500+650)*3-190-210,28*3,54*3-30));

            //smallhouse three
            AllWalls.add(new Wall((480+870)*3-190-320,335*3-125,200*3-95,28*3));
            AllWalls.add(new Wall((480+870)*3-190-320,560*3-210,200*3-95,28*3));
            AllWalls.add(new Wall((640+670)*3-400,335*3-125,28*3,250*3-95));
            AllWalls.add(new Wall((480+1040)*3-190-415,335*3-125,28*3,54*3-20));
            AllWalls.add(new Wall((480+1040)*3-190-415,500*3-190,28*3,84*3-30));

            //smallhouse four
            AllWalls.add(new Wall((480+870)*3-190-320,(335+650)*3-125-260,200*3-95,28*3));
            AllWalls.add(new Wall((480+870)*3-190-320,(560+650)*3-210-260,200*3-95,28*3));
            AllWalls.add(new Wall((640+670)*3-400,(335+650)*3-125-260,28*3,250*3-95));
            AllWalls.add(new Wall((480+1040)*3-190-415,(335+650)*3-125-260,28*3,84*3-20));
            AllWalls.add(new Wall((480+1040)*3-190-415,(500+650)*3-140-210,28*3,54*3-30));

        }

    }

    public List<Wall> getListWall(){
        return AllWalls;
    }
}
