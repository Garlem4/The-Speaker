package com.example.speaker;


import android.graphics.BitmapFactory;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class InitializeNPC {
    private List<NPC> AllNPC;

    public List<NPC> getListNPC(){
        return AllNPC;
    }

    public InitializeNPC(String map, Context context){
        if(map == "map1") {
            this.AllNPC = new ArrayList<NPC>();
            AllNPC.add(new NPC(3100,1900,BitmapFactory.decodeResource(context.getResources(), R.drawable.king)));
            AllNPC.add(new NPC(3100,2100,BitmapFactory.decodeResource(context.getResources(), R.drawable.guard)));


        }
    }
}
