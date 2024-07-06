public class FunctionEdit {
    GUI gui;

    public FunctionEdit(GUI gui) {
        this.gui = gui;
    }

    public void undo() {
        if (gui.um.canUndo()) {
            gui.um.undo();
        }
    }

    public void redo() {
        if (gui.um.canRedo()) {
            gui.um.redo();
        }
    }
}
