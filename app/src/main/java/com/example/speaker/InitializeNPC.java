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
            AllNPC.add(new NPC(1000*2.6,760*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.king)));
            AllNPC.add(new NPC(1230*2.6,670*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.guardleft)));
            AllNPC.add(new NPC(1230*2.6,840*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.guardleft)));
            AllNPC.add(new NPC(760*2.6,670*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.guardright)));
            AllNPC.add(new NPC(760*2.6,840*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.guardright)));
            AllNPC.add(new NPC(280*2.6,260*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.spearmanright)));
            AllNPC.add(new NPC(280*2.6,1240*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.spearmanright)));
            AllNPC.add(new NPC(1670*2.6,260*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.spearmanleft)));
            AllNPC.add(new NPC(1670*2.6,1240*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.spearmanleft)));
            AllNPC.add(new NPC(570*2.6,420*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.peasantleft)));
            AllNPC.add(new NPC(570*2.6,1080*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.peasantleft)));
            AllNPC.add(new NPC(1380*2.6,420*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.peasantright)));
            AllNPC.add(new NPC(1380*2.6,1080*2.6,BitmapFactory.decodeResource(context.getResources(), R.drawable.peasantright)));


        }
    }
}
