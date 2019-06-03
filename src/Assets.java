import javax.swing.*;
import java.awt.*;

public class Assets {

    public static ImageIcon background, mainMenu, player, redship1, redship2, redship3, redship4, redship5, redship6;
    public static void init(){
        background = new ImageIcon("res/textures/Background1.jpg");
        mainMenu = new ImageIcon("res/textures/Background2.jpg");
        player = new ImageIcon("res/textures/Blue Ship 6.png");
        redship1 = new ImageIcon("res/textures/Red Ship 1.png");
        redship2 = new ImageIcon("res/textures/Red Ship 2.png");
        redship3 = new ImageIcon("res/textures/Red Ship 3.png");
        redship4 = new ImageIcon("res/textures/Red Ship 4.png");
        redship5 = new ImageIcon("res/textures/Red Ship 5.png");
        redship6 = new ImageIcon("res/textures/Red Ship 6.png");

    }

    public static Image getRedShip1(){
        return redship1.getImage();
    }
    public static Image getRedShip2(){
        return redship2.getImage();
    }
    public static Image getRedShip3(){
        return redship3.getImage();
    }
    public static Image getRedShip4(){
        return redship4.getImage();
    }
    public static Image getRedShip5(){
        return redship5.getImage();
    }
    public static Image getRedShip6(){
        return redship6.getImage();
    }


    public static Image getPlayer(){
        return player.getImage();
    }
    public static Image getBackground(){
        return background.getImage();
    }
    public static Image getMenu(){ return mainMenu.getImage(); }
}
