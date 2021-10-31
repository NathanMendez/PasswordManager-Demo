import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PasswordManagerUI {

    public static int mode = 0;
    public PasswordManagerUI(){
        startMenu();
    }

    public static void startMenu(){
        JFrame frame = new JFrame("Passy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

        JLabel VersionCrd = new JLabel("Created by Nathaniel   Version 1");
        VersionCrd.setForeground(Color.white);
        VersionCrd.setFont(new Font("Serif",Font.PLAIN,12));
        VersionCrd.setBounds(220,130,160,30);

        JLabel tittle = new JLabel("Passy");
        tittle.setForeground(Color.white);
        tittle.setFont(new Font("Serif",Font.PLAIN,30));
        tittle.setBounds(50,40,160,30);

        JLabel subtittle = new JLabel("Minimalist Password Manager");
        subtittle.setForeground(Color.white);
        subtittle.setFont(new Font("Serif",Font.PLAIN,11));
        subtittle.setBounds(25,70,160,30);

        JButton generateArea = new JButton("Generate a Password");
        generateArea.setBounds(190,40,160,30);
        generateArea.setBackground(Color.black);
        generateArea.setForeground(Color.white);
        generateArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                generateMenu();
            }
        });

        JButton myVault = new JButton("My Passwords");
        myVault.setBounds(190,90,160,30);
        myVault.setBackground(Color.black);
        myVault.setForeground(Color.white);

        panel.add(VersionCrd);
        panel.add(tittle);
        panel.add(subtittle);
        panel.add(generateArea);
        panel.add(myVault);

        frame.add(panel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public static void generateMenu(){
        JFrame frame = new JFrame("Passy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

        JTextField output = new JTextField();
        output.setEditable(false);
        output.setForeground(Color.white);
        output.setBounds(170,40,160,30);
        output.setBackground(Color.black);

        JButton copy = new JButton("C");
        copy.setBackground(Color.black);
        copy.setForeground(Color.white);
        copy.setFont(new Font("Serif",Font.PLAIN,8));
        copy.setBounds(340,40,30,30);
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(output.getText()),null);
            }
        });

        JCheckBox numbers = new JCheckBox("Include Numbers");
        numbers.setBounds(30,80,140,30);
        numbers.setBackground(Color.black);
        numbers.setForeground(Color.white);
        numbers.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(mode == 0){
                    mode = 1;
                }else{
                    mode = 0;
                }
            }
        });


        JTextField length = new JTextField("Enter Length");
        length.setBackground(Color.black);
        length.setForeground(Color.white);
        length.setBounds(30,40,130,30);

        JButton generate = new JButton("Generate Password");
        generate.setBackground(Color.black);
        generate.setForeground(Color.white);
        generate.setFont(new Font("Serif",Font.PLAIN,15));
        generate.setBounds(170,80,160,30);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    String passwd = PasswordManagerGenerator.generate(mode,Integer.parseInt(length.getText()));
                    output.setText(passwd);

                }catch (Exception f){
                    output.setText("Length Error");
                }
            }
        });

        panel.add(numbers);
        panel.add(generate);
        panel.add(output);
        panel.add(copy);
        panel.add(length);

        frame.add(panel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
