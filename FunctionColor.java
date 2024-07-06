import java.awt.Color;

public class FunctionColor {
    GUI gui;
    public FunctionColor(GUI gui){
        this.gui = gui;
    }
    public void changeColor(String color){
       switch (color) {
        case "White":
        gui.window.getContentPane().setBackground(Color.white);
        gui.textArea.setBackground(Color.white);
        gui.textArea.setForeground(Color.black);
        break;
       case "Black":
       gui.window.getContentPane().setBackground(Color.black);
       gui.textArea.setBackground(Color.black);
       gui.textArea.setForeground(Color.white);
       break;
       case "Pink":
       gui.window.getContentPane().setBackground(Color.pink);
       gui.textArea.setBackground(Color.pink);
       gui.textArea.setForeground(Color.white);
       break;
       }
    }
}
