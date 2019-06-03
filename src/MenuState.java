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
        g.drawString("Z-Type",150,250);
        g.setFont(new Font("PHOSPHATE", Font.BOLD, 20));
        g.drawString("low budget version", 420,290);

        g.setColor(new Color(0, 20, 73, 152));
        g.fillRoundRect(250,335,300,90, 40,40);
        g.fillRoundRect(250,435,300,90,40,40);
        g.setColor(Color.white);
        g.setFont(new Font("PHOSPHATE", Font.PLAIN, 90));
        g.drawString("Play", 300,410);
        g.drawString("Quit", 300, 510);

    }
}
