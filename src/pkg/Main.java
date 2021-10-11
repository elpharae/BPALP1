package pkg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

/*
Zkusit si:
1) obvod obdelníku
2) objem kvádru
 */



public class Main {

    private Scanner sc;

    float per() {
        float a, b;

        System.out.println("Zadej stranu A");
        a = sc.nextFloat();
        System.out.println("Zadej stranu B");
        b = sc.nextFloat();

        return 2 * (a + b);
    }

    float vol() {
        float a, b, c;

        System.out.println("Zadej stranu A");
        a = sc.nextFloat();
        System.out.println("Zadej stranu B");
        b = sc.nextFloat();
        System.out.println("Zadej stranu C");
        c = sc.nextFloat();

        return a * b * c;
    }

    public Main() {
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new ButtonClicker("Button Clicker", "Click!", 400, 100);
        //new GuessMyNum(500, 15);

        //Main obj = new Main();
        //System.out.println("Perimeter of a rectangle: " + obj.per());
        //System.out.println("Volume of a block: " + obj.vol());
    }
}

class GuessMyNum {

    private int num;
    private int bound;
    private int attempts;
    private int guessCount = 0;
    private String guess = "";
    private boolean canPlay = true;

    public GuessMyNum(int bound, int attempts) {
        this.bound = bound;
        this.attempts = attempts;
        this.num = new Random().nextInt(this.bound);

        game();
    }

    private void game() {
        Scanner sc = new Scanner(System.in);
        int guess;

        while (this.canPlay = this.guessCount < this.attempts) {
            System.out.println("Enter a number in range from 1 to " + this.bound);
            this.guess = sc.next();

            try {
                this.guessCount++;

                guess = Integer.parseInt(this.guess);

                if (guess < this.num) System.out.println("Too low");
                else if (guess > this.num) System.out.println("Too high");
                else break;
            } catch (NumberFormatException e) {
                System.err.println("Enter a valid number");
            }
        }

        if (this.canPlay) System.out.println("Correct! My number was " + this.num + ". It took you " + this.guessCount + " guesses.");
        else System.err.println("Game over");
    }

}

class ButtonClicker {

    private int count;

    private JFrame okno;
    private JPanel panel;
    private JLabel label;
    private JButton button;

    public ButtonClicker(String windowTitle, String buttonTitle, int screenWidth, int screenHeight) {
        this.count = 0;
        this.okno = new JFrame(windowTitle);
        this.panel = new JPanel();
        this.label = new JLabel();
        this.button = new JButton(buttonTitle);

        initWindow(screenWidth, screenHeight);
    }

    private void initWindow(int x, int y) {
        this.okno.setSize(x, y);
        this.okno.setLocationRelativeTo(null);
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.okno.setVisible(true);

        this.label.setText(Integer.toString(count));
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.label.setVerticalAlignment(SwingConstants.CENTER);

        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(Integer.toString(++count));
            }
        });

        this.panel.setLayout(new GridLayout(1,2));
        this.panel.add(this.label);
        this.panel.add(this.button);

        this.okno.add(this.panel);
    }
}
