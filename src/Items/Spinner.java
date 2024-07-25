package Items;

import javax.swing.JSpinner;

public class Spinner extends JSpinner {

    public void setLabelText(String text) {
        Items.SpinnerUI.Editor editor = (Items.SpinnerUI.Editor) getEditor();
        editor.setLabelText(text);
    }

    public String getLabelText() {
        Items.SpinnerUI.Editor editor = (Items.SpinnerUI.Editor) getEditor();
        return editor.getLabelText();
    }

    public Spinner() {
        super();
        setOpaque(false);
        setUI(new Items.SpinnerUI());
    }
}
