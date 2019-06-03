import java.awt.*;

public class MenuState extends State{
    public MenuState(GameEngine gameIn){
        super(gameIn);

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        //render the menu
        g.clearRect(0,0,800,600);
        g.drawImage(Assets.getMenu(), 0, 0, null);
        g.setFont(new Font("PHOSPHATE", Font.BOLD, 160));
        g.setColor(Color.white);
        g.drawString("Z-Type",170,250);
        g.setFont(new Font("PHOSPHATE", Font.BOLD, 27));
        g.drawString("low budget knockoff", 320,290);
//        g.setFont(new Font("COURIER", Font.BOLD, 14));
//
//        g.drawString("MISSING ESSENTIAL FEATURES", 420, 310);

        g.setColor(new Color(0, 20, 73, 152));
        g.fillRoundRect(250,335,300,90, 40,40);
        g.fillRoundRect(250,435,300,90,40,40);
        g.setColor(Color.white);
        g.setFont(new Font("PHOSPHATE", Font.PLAIN, 90));
        g.drawString("Play", 300,410);
        g.drawString("Quit", 300, 510);

    }
}
