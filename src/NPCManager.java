import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NPCManager {
    private static String text = "knowing that millions of people around the world would be watching in person and on television and expecting great things from him, at least one more gold medal for America, if not another world record — during this, his fourth and surely his last appearance in the World Olympics, and realizing that his legs could no longer carry him down the runway with the same blazing speed and confidence in making a huge, eye-popping leap that they were capable of a few years ago when he set world records in the 100-meter dash and in the 400-meter relay and won a silver medal in the long jump, the renowned sprinter and track-and-field personality Carl Lewis, who had known pressure from fans and media before but never, even as a professional runner, this kind of pressure, made only a few appearances in races during the few months before the Summer Olympics in Atlanta, Georgia, partly because he was afraid of raising expectations even higher and he did not want to be distracted by interviews and adoring fans who would follow him into stores and restaurants demanding autographs and photo-opportunities, but mostly because he wanted to conserve his energies and concentrate, like a martial arts expert, on the job at hand: winning his favorite competition, the long jump, and bringing home another Gold Medal for the United States, the most fitting conclusion to his brilliant career in track and field.";

    private static int[] locations;
    private static List<String> wordList = new ArrayList<String>();
    private static List<NPC> NPCList = new ArrayList<NPC>();
    private static List<NPC> secondList = new ArrayList<NPC>();

    private static float modY = (float) 1/3;
    public NPCManager(){
//        int style = (int) (Math.random() * 3 + 1);
//        System.out.println("Style selected: " + style);
//        if (style == 1){
//            text = new String("");
//        }
//        if (style == 2){
//            text = new String("");
//
//        }
//        if (style == 3){
//            text = new String("");
//
//        }

    }
    public static void createNPC(){
        NPC newSpawn = new NPC(State.getCurrentState().game, genX(), genY(), 0,0,getString());
//        System.out.println(newSpawn.getString());
        NPCList.add(newSpawn);
    }

    public static int genX(){
        //from 0-750
        int x = (int) (Math.random()*750);
        return x;
    }
    public static int genY(){
        int y = (int) (Math.random()*50);
        return y;
    }
    public static String getString(){
        int wordEnds = text.indexOf(" ");
        String newString = text.substring(0,wordEnds);
        wordList.add(newString);
        text = text.substring(wordEnds + 1);
        return newString;
    }
    public static void smallTick(Graphics g){

        //this shit is causing concurrent modification errors
        secondList.clear();
        secondList.addAll(NPCList);

        for(NPC npc: secondList){
            npc.addY(modY);
            npc.tick();
        }
//        for(NPC npc: NPCList){
//            npc.tick();
//        }

        render(g);

    }
    public static void tick(Graphics g){
        createNPC();
//        for(NPC npc: NPCList){
//            npc.addY(1);
//            npc.tick();
//        }
        render(g);
    }
    public static void render(Graphics g){
        for (NPC npc : NPCList){
            npc.render(g);
        }
    }
    public static List<String> getWordList(){
        return wordList;
    }
    public static List<NPC> getNPCList(){
        return NPCList;
    }
    public static void setModY(float f){
        modY = f;
    }
    public static float getModY(){
        return modY;
    }
    public static int getIndex(NPC npc){
        for (int i = 0; i < NPCList.size(); i++){
            if(NPCList.get(i).equals(npc)){
                return i;
            }
        }
        return -1;
    }
}

