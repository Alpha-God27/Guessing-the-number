//random number guessing game

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JOptionPane;

class RandomGame extends Frame implements ActionListener {
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    TextField t1;
    int targetNumber;

    RandomGame() {
        t1 = new TextField();
        t1.setBounds(50, 100, 360, 50);
        t1.setFont(new Font("Arial", Font.PLAIN, 24)); // Set the font size
        t1.setBackground(Color.WHITE); // Set the background color
        t1.setForeground(Color.WHITE); // Set the text color
        setTitle("Random Game");

        b0 = new Button("0");
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        b0.setBounds(50, 175, 60, 35);
        b1.setBounds(125, 175, 60, 35);
        b2.setBounds(200, 175, 60, 35);
        b3.setBounds(275, 175, 60, 35);
        b4.setBounds(350, 175, 60, 35);
        b5.setBounds(50, 225, 60, 35);
        b6.setBounds(125, 225, 60, 35);
        b7.setBounds(200, 225, 60, 35);
        b8.setBounds(275, 225, 60, 35);
        b9.setBounds(350, 225, 60, 35);
        b0.setBackground(Color.WHITE);
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);
        b4.setBackground(Color.WHITE);
        b5.setBackground(Color.WHITE);
        b6.setBackground(Color.WHITE);
        b7.setBackground(Color.WHITE);
        b8.setBackground(Color.WHITE);
        b9.setBackground(Color.WHITE);
        setSize(450, 350);
        add(t1);
        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0); // Exit the application
            }
        });

        generateTargetNumber();
    }

    private void generateTargetNumber() {
        Random random = new Random();
        targetNumber = random.nextInt(10);
    }

    public void actionPerformed(ActionEvent e) {
        Button source = (Button) e.getSource();
        t1.setText(t1.getText() + source.getLabel());

        if (t1.getText().length() == 1) {
            int guessedNumber = Integer.parseInt(t1.getText());
            if (guessedNumber == targetNumber) {
                JOptionPane.showMessageDialog(this, "Congratulations! You won!");
                generateTargetNumber();
            } else {
                JOptionPane.showMessageDialog(this, "Bad luck! Try again.");
            }
            t1.setText("");
        }
    }

    public static void main(String args[]) {
        new RandomGame();
    }
}
