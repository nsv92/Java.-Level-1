import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculationListener implements ActionListener {
    private final  JTextField in;

    public CalculationListener(JTextField in) {
        this.in = in;
    }

    public void actionPerformed(ActionEvent e) {
        JButton calc = (JButton) e.getSource();
        StringBuilder stringBuilder = new StringBuilder(in.getText());
        String inToPolish = Calculator.stringToPolish(stringBuilder.toString());
//        String answer = Double.toString(Calculator.polishToAnswer(inToPolish));
//        in.setText(answer);
        in.setText(Double.toString(Calculator.polishToAnswer(inToPolish)));
    }
}
