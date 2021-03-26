import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener {
    private final JTextField in;

    public ClearListener(JTextField in) {
        this.in = in;
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        StringBuilder stringBuilder = new StringBuilder(in.getText());
        if (stringBuilder.length() > 0) stringBuilder.setLength(stringBuilder.length() - 1);

        in.setText(stringBuilder.toString());
    }
}
