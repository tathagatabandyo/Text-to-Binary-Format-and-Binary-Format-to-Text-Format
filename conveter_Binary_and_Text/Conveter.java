package conveter_Binary_and_Text;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;

public class Conveter extends JFrame{
   
    private static final long serialVersionUID = 1L;
    JButton b1,b2;
    public Conveter(String s) {
        super(s);
        setSize(530,270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container c=this.getContentPane();
        c.setBackground(new Color(44, 62, 80));
        setLayout(null);
        setResizable(false);
        
        b1=new JButton("Convate any Text to Binary Number");
        b2=new JButton("Convate Binary Number to Text Formate");
        b1.setBounds(50,60,415,35);
        b2.setBounds(50,150,415,35);

        add(b1);
        add(b2);
        Font font=new Font("arial",Font.BOLD,20);
        b1.setFont(font);
        b2.setFont(font);
        Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
        b1.setCursor(cursor);
        b2.setCursor(cursor);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TextToBinary("Any Text to Binary Number").setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BinaryToText("Binary Number to Text Formate").setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new Conveter("Binary to Text OR Text to Binary").setVisible(true);
    }
}
