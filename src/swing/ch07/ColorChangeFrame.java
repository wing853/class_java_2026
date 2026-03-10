package swing.ch07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangeFrame extends JFrame implements ActionListener {

    private JButton button1;
    private JButton button2;
    private JPanel panel1;

    public ColorChangeFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        panel1 = new JPanel();
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        panel1.setBackground(Color.YELLOW);
        add(panel1);
        panel1.add(button1);
        panel1.add(button2);
        setVisible(true);
    }

    private void addEventListener() {
        // JButton 클래스 내에 만들어져 있는 메서드
        // this는 ActionListen타입으로 바라 볼 수 있다.
        //  1. 이벤트 리스너 등록
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    // 운영 체제와 약속되어있는 추상 메서드를 오버라이드
    // 이벤트가 발생되면 이 메서드를 자동으로 수행해(콜백 메서드)라고 미리 정해져있는 메서드
    // 인수값으로 정보(객체)를 받을 수 있다.
    // 단, 어떤 컴포넌트에 이벤트를 등록할지 미리 정해주어야 한다.
    @Override
    public void actionPerformed(ActionEvent e) {
        // 2. actionPerformed 메서드 콜백(호출되어) 동작하게 끔 설계 되어 있음
        System.out.println("actionPerformed() 메서드가 호출 되었다.");
        JButton selectedButton = (JButton) e.getSource();
        System.out.println(selectedButton.getText());

        // 1번 눌렀을때 파란색, 2번 눌렀을때 검은색
        if (selectedButton == (button1)) {
            panel1.setBackground(Color.BLUE);
        } else if (selectedButton == (button2)) {
            panel1.setBackground(Color.BLACK);
        }

    }
}

