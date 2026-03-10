package swing.ch08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame implements ActionListener {
    // 이전에 했던 코드를 한번 더 복습
    private JButton[] buttons = new JButton[7];
    private JPanel panel;

    public ColorFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    public void initData() {
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("button" + (i + 1));
        }
        panel = new JPanel();
    }

    public void setInitLayout() {
        setLayout(new BorderLayout());
        add(panel);
        panel.setBackground(Color.DARK_GRAY);
        for (int i = 0; i < buttons.length; i++) {
            panel.add(buttons[i]);
        }
        setVisible(true);
    }

    public void addEventListener() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selectButton = (JButton) e.getSource();
        if(selectButton == buttons[0]) {
            panel.setBackground(Color.red);
        } else if(selectButton == buttons[1]) {
            panel.setBackground(Color.ORANGE);
        }else if(selectButton == buttons[2]) {
            panel.setBackground(Color.YELLOW);
        }else if(selectButton == buttons[3]) {
            panel.setBackground(Color.GREEN);
        }else if(selectButton == buttons[4]) {
            panel.setBackground(Color.cyan);
        }else if(selectButton == buttons[5]) {
            panel.setBackground(Color.BLUE);
        }else if(selectButton == buttons[6]) {
            panel.setBackground(Color.MAGENTA);
        }
    }
}
