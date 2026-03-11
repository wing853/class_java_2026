package swing.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame extends JFrame implements ActionListener {

    private JButton button1;
    private JPanel panel1;
    private JLabel jLabel;
    private LottoRandomNumber lottoRandomNumber;
    private int init_x = 200;
    private int init_y = 200;
    private JPanel circle;

    public LottoFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("Lotto Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("Game start");
        panel1 = new JPanel();
        jLabel = new JLabel("Game Start 버튼을 눌러주세요", JLabel.CENTER);

        lottoRandomNumber = new LottoRandomNumber();
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        add(button1, BorderLayout.NORTH);
        button1.setSize(100, 100);
        setVisible(true);
        add(jLabel, BorderLayout.CENTER);
        jLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));

    }

    static class Circle extends JPanel {
        public void paint(Graphics g){
            g.drawArc(50,100,50,50,0,360);
            g.drawArc(120,100,50,50,0,360);
            g.drawArc(190,100,50,50,0,360);
            g.drawArc(260,100,50,50,0,360);
            g.drawArc(330,100,50,50,0,360);
            g.drawArc(390,100,50,50,0,360);
        }
    }

    private void addEventListener() {
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lottoNumString = "";
        int[] lottoNumber = lottoRandomNumber.getNumber();
        for (int i = 0; i < lottoNumber.length ; i++) {
            lottoNumString += lottoNumber[i] + " ";
        }
        circle = new Circle();
        add(circle);
        setVisible(true);

        jLabel.setText(lottoNumString);
    }

    // main
    public static void main(String[] args) {
        new LottoFrame();
    } // end of main
}