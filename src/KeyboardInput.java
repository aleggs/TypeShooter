import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

    private String wordTyped = "";
    private boolean[] keys;
    public boolean a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;

    public KeyboardInput(){
        keys = new boolean[256];
    }

    public void tick(){

        a = keys[KeyEvent.VK_A];
        b = keys[KeyEvent.VK_B];
        c = keys[KeyEvent.VK_C];
        d = keys[KeyEvent.VK_D];
        e = keys[KeyEvent.VK_E];
        f = keys[KeyEvent.VK_F];
        g = keys[KeyEvent.VK_G];
        h = keys[KeyEvent.VK_H];
        i = keys[KeyEvent.VK_I];
        j = keys[KeyEvent.VK_J];
        k = keys[KeyEvent.VK_K];
        l = keys[KeyEvent.VK_L];
        m = keys[KeyEvent.VK_M];
        n = keys[KeyEvent.VK_N];
        o = keys[KeyEvent.VK_O];
        p = keys[KeyEvent.VK_P];
        q = keys[KeyEvent.VK_Q];
        r = keys[KeyEvent.VK_R];
        s = keys[KeyEvent.VK_S];
        t = keys[KeyEvent.VK_T];
        u = keys[KeyEvent.VK_U];
        v = keys[KeyEvent.VK_V];
        w = keys[KeyEvent.VK_W];
        x = keys[KeyEvent.VK_X];
        y = keys[KeyEvent.VK_Y];
        z = keys[KeyEvent.VK_Z];

//        for (boolean bool : keys){
//            if (bool == true)
//                System.out.println(bool);
//            bool = false;
//        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
//        System.out.print(e.getKeyChar());
//        System.out.println("Pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        wordTyped += e.getKeyChar();
    }

    @Override
    public void keyTyped(KeyEvent e) {

//        wordTyped += e.getKeyChar();
    }
    public String getWordTyped(){
        return wordTyped;
    }
    public void resetWordTyped(){
        wordTyped = "";
    }

}
