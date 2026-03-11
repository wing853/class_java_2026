package swing.ch09;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {

    private final int WIDTH = 1050;
    private final int HEIGHT = 680;
    private final int MOVE = 10;
    private final int CHARACTER_WIDTH = 100;
    private final int CHARACTER_hEIGHT = 100;
    private JLabel backgroundMap;
    private JLabel player;
    private JLabel enemy;
    private ImageIcon playerIconL = new ImageIcon("images/playerL.png");;
    private ImageIcon playerIconR = new ImageIcon("images/playerR.png");
    private ImageIcon playerIconDie;
    private ImageIcon enemyIcon;


    public MyFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }


    private void initData() {
        setTitle("이미지 사용 연습");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon(("images/backgroundMap.png"));
        backgroundMap = new JLabel(backgroundIcon);
        backgroundMap.setSize(WIDTH, HEIGHT);
        backgroundMap.setLocation(0, 0);

        // 플레이서 설정
        enemyIcon = new ImageIcon("images/enemyL.png");
        playerIconDie = new ImageIcon("images/playerLDie.png");
        player = new JLabel(playerIconL);
        enemy = new JLabel(enemyIcon);

        player.setSize(CHARACTER_WIDTH, CHARACTER_hEIGHT);
        player.setLocation(200, 190);

        enemy.setSize(CHARACTER_WIDTH,CHARACTER_hEIGHT);
        enemy.setLocation(500,400);
    }

    private void setInitLayout() {
        setLayout(null); // 좌표 기반
        backgroundMap.add(player);
        backgroundMap.add(enemy);
        add(backgroundMap);
        setVisible(true);
    }

    private void addEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int playerX = player.getX();
                int playerY = player.getY();
                int enemyX = enemy.getX();
                int enemyY = enemy.getY();

                if (keyCode == KeyEvent.VK_LEFT) {
                    if(playerX < 90){
                        return;
                    }
                    player.setIcon(playerIconL);
                    player.setLocation(playerX - MOVE, playerY);
                } else if (keyCode == KeyEvent.VK_UP) {
                    if(playerY < 50) {
                        return;
                    }
                    player.setLocation(playerX, playerY - MOVE);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    if(playerX > 880) {
                        return;
                    }
                    player.setIcon(playerIconR);
                    player.setLocation(playerX + MOVE, playerY);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    if(playerY > 530) {
                        return;
                    }
                    player.setLocation(playerX, playerY + MOVE);
                }
            }
        });
    }



    // 테스트 코드 - 메인 쓰레드
    public static void main(String[] args) {
        new MyFrame();

    }

}
