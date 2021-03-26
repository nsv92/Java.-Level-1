import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {

    public ApplicationFrame() {
        setTitle("Simple calculator v2.0");
        setBounds(500, 300, 300, 400);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setJMenuBar(createMenuBar());

        setLayout(new BorderLayout());

        JPanel top = createTop();
        add(top, BorderLayout.NORTH);

        Component component = top.getComponent(0);
        add(createBottom((JTextField) component), BorderLayout.CENTER);
        setVisible(true);
    }


    private JPanel createBottom(JTextField in) {
        JPanel bottom = new JPanel();

        bottom.setLayout(new GridLayout(7, 3));

        ButtonListener buttonListener = new ButtonListener(in);
        for (int i = 1; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            bottom.add(btn);
        }

        ClearListener clearListener = new ClearListener(in);
        JButton clear = new JButton("C");
        clear.addActionListener(clearListener);
        clear.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(clear);

        JButton zero = new JButton("0");
        zero.addActionListener(buttonListener);
        zero.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(zero);

        CalculationListener calculationListener = new CalculationListener(in);
        JButton calc = new JButton("=");
        calc.addActionListener(calculationListener);
        calc.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(calc);

        JButton plus = new JButton("+");
        plus.addActionListener(buttonListener);
        plus.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(plus);

        JButton minus = new JButton("-");
        minus.addActionListener(buttonListener);
        minus.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(minus);

        JButton multiplication = new JButton("*");
        multiplication.addActionListener(buttonListener);
        multiplication.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(multiplication);

        JButton division = new JButton("/");
        division.addActionListener(buttonListener);
        division.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(division);

        JButton sqrt = new JButton("\u221A");
        sqrt.addActionListener(buttonListener);
        sqrt.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(sqrt);

        JButton openBracket = new JButton("(");
        openBracket.addActionListener(buttonListener);
        openBracket.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(openBracket);

        JButton closeBracket = new JButton(")");
        closeBracket.addActionListener(buttonListener);
        closeBracket.setFont(new Font("Arial", Font.BOLD, 24));
        bottom.add(closeBracket);

        return bottom;
    }

    private JPanel createTop() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        JTextField in = new JTextField();
        in.setEditable(false);
        in.setFont(new Font("Arial", Font.BOLD, 20));

        top.add(in, BorderLayout.NORTH);

        return top;
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = menuBar.add(new JMenu("File"));
        menu.add(new JMenuItem("Power Safe Mode"));

        JMenuItem exit = menu.add(new JMenuItem("Exit"));
        exit.addActionListener(new ExitButtonListener());

        return menuBar;
    }
}