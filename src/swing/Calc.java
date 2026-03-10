package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc extends JFrame implements ActionListener {
    private String[] cal = {
            "←", "CE", "C", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", "%", ".", "="
    };
    private JButton[] buttons = new JButton[cal.length];
    private JPanel panel;
    private JTextField resultField;

    public Calc() {
        setTitle("계산기");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initData() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(cal[i]);
        }
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        resultField = new JTextField();
        resultField.setBounds(0,0,400,100);
    }

    private void setInitLayout() {

        setLayout(new BorderLayout());

        resultField.setPreferredSize(new Dimension(400, 100));
        resultField.setHorizontalAlignment(JTextField.RIGHT);

        add(resultField, BorderLayout.NORTH);

        panel.setLayout(new GridLayout(5, 4));
        add(panel, BorderLayout.CENTER);

        for (int i = 0; i < buttons.length; i++) {
            panel.add(buttons[i]);
        }

        setVisible(true);
    }

    public final void run() {
        initData();
        setInitLayout();
        revalidate();
        repaint();
        addEventListener();
    }

    private void addEventListener() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentString = resultField.getText();
        JButton selectButton = (JButton) e.getSource();
        if(selectButton == buttons[buttons.length - 1]){
            resultField.setText(" = 입력");
        } else {
            resultField.setText(currentString + " " + selectButton.getText());
        }
    }
}
