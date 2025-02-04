import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener{
    //java swing used. GUI widget for java

    JFrame window;//for window
    //TEXT AREA
    JTextArea textArea;//Multiline area that displays plain text
    JScrollPane scrollPane;

    boolean wordWrapOn=false;
    //TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile,menuEdit,menuFormat,menuColor;
    //FILEMENU
    JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
    //EDIT MENU
    JMenuItem iUndo,iRedo;
    //FORMAT MENU
    JMenuItem iWrap,iFontArial,iFontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize28;
    JMenu menuFont,menuFontSize;
    //color menu
    JMenuItem iColor1,iColor2,iColor3;

    FunctionFile file=new FunctionFile(this);
    FunctionFormat format=new FunctionFormat(this);
    FunctionColor color=new FunctionColor(this);
    FunctionEdit edit=new FunctionEdit(this);
    KeyHandler kHandler=new KeyHandler(this);
    

    UndoManager um = new UndoManager();
    public static void main(String[] args){
        new GUI();
    }
    //constructor
    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();

        format.selectedFont="Arial";
        format.createFont(16);
        format.wordWrap();
        color.changeColor("White");
        window.setVisible(true);


    }
    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800, 600);//default size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close window when exit

    }
    public void createTextArea() {
        textArea = new JTextArea();
        textArea.setFont(format.arial);

        textArea.addKeyListener(kHandler);
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });



        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        window.add(scrollPane);
        //window.add(textArea);
    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor= new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand(("New"));
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand(("Open"));
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand(("Save"));
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("SaveAs");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand(("SaveAs"));
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand(("Exit"));
        menuFile.add(iExit);
    }
    public void createEditMenu(){
        iUndo=new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand(("Undo"));
        menuEdit.add(iUndo);
        iRedo=new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand(("Redo"));
        menuEdit.add(iRedo);
    }
    public void createFormatMenu(){
        iWrap=new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand(("Word Wrap"));
        menuFormat.add(iWrap);

        menuFont=new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial= new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand(("Arial"));
        menuFont.add(iFontArial);

        iFontCSMS= new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand(("Comic Sans MS"));
        menuFont.add(iFontCSMS);

        iFontTNR= new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand(("Times New Roman"));
        menuFont.add(iFontTNR);

        menuFontSize =new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8=new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("Size8");
        menuFontSize.add(iFontSize8);

        iFontSize12=new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("Size12");
        menuFontSize.add(iFontSize12);

        iFontSize16=new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("Size16");
        menuFontSize.add(iFontSize16);

        iFontSize20=new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("Size20");
        menuFontSize.add(iFontSize20);


        iFontSize24=new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("Size24");
        menuFontSize.add(iFontSize24);

        iFontSize28=new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("Size28");
        menuFontSize.add(iFontSize28);

    }
    public void createColorMenu(){
        iColor1=new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2=new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3=new JMenuItem("Pink");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Pink");
        menuColor.add(iColor3);

    }

    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        switch(command){
            case "New": file.newFile();break;
            case "Open": file.open();break;
            case "Save": file.save();break;
            case "SaveAs": file.saveAs();break;
            case "Exit": file.exit();break;
            case "Undo": edit.undo();break;
            case "Redo": edit.redo();break;
            case "Word Wrap":format.wordWrap();break;
            case "Arial": format.setFont("Arial"); break;
            case "Comic Sans MS": format.setFont("Comic Sans MS"); break;
            case "Times New Roman": format.setFont("Times New Roman"); break;
            case "Size8": format.createFont(8); break;
            case "Size12": format.createFont(12); break;
            case "Size16": format.createFont(16); break;
            case "Size20": format.createFont(20); break;
            case "Size24": format.createFont(24); break;
            case "Size28": format.createFont(28); break;
            case "White": color.changeColor(command);break;
            case "Black": color.changeColor(command);break;
            case "Pink" : color.changeColor(command);break;

        }

    }
    
}