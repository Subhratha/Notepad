import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {
    GUI gui;
    public KeyHandler(GUI gui){
       this.gui=gui;
    }
    public void keyTyped(KeyEvent e){

    }
    public void keyPressed(KeyEvent e){
        if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_S){
            gui.file.save();
        }
        if(e.isShiftDown()&&e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_S){
            gui.file.saveAs();
        }
        if(e.isAltDown()&&e.getKeyCode()==KeyEvent.VK_F){
            gui.menuFile.doClick();
        }
    }
    public void keyReleased(KeyEvent e){

    }
}
