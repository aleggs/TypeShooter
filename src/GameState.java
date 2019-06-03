import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.*;

public class GameState extends State{

    private Player player;

    public GameState(GameEngine gameIn){
        super(gameIn);
        player = new Player(gameIn,380,500,100,100);
    }
    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {

        g.clearRect(0,0,800,600);
        g.drawImage(Assets.getBackground(), 0,0,null);
        g.setFont(new Font("MONOSPACED", Font.BOLD, 18));
        g.setColor(Color.white);
        g.drawString("Score: " + game.getEnemiesKilled(), 0,20);
        g.drawString("Difficulty: " + game.getDifficultyLevel(), 350,20);
        player.render(g);
        NPCManager.render(g);

    }

    public static void music()
    {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            BGM = new AudioStream(new FileInputStream("/res/music.wav"));
            MD = BGM.getData();
            loop = new ContinuousAudioDataStream(MD);
        }
        catch(IOException e)
        {
            System.out.println("cant find the file");
        }

        MGP.start(loop);
    }

    public GameEngine getGameEngine(){
        return game;
    }
//    public static GameState getGameState(){
////        return game.getClass();
//    }
}
