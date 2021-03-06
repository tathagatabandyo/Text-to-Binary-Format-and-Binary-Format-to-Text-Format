package conveter_Binary_and_Text;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BinaryToText extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    int p=0;
    JButton con, cons,hb;
    JPanel p1, p2, p3, p4, p5;;
    JTextArea t1, t2;
    JScrollPane s1, s2;

    public BinaryToText(String s) {
        super(s);
        setSize(1000, 780);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0, 0));
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);
        add(p3, BorderLayout.EAST);
        add(p4, BorderLayout.WEST);
        add(p5, BorderLayout.CENTER);

        Color color = new Color(44, 62, 80);
        p1.setBackground(color);
        p2.setBackground(color);
        p3.setBackground(color);
        p4.setBackground(color);
        p5.setBackground(color);
        p1.setPreferredSize(new Dimension(10, 40));
        p2.setPreferredSize(new Dimension(10, 50));
        p3.setPreferredSize(new Dimension(10, 10));
        p4.setPreferredSize(new Dimension(10, 10));

        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.setLayout(new GridLayout(1, 2, 40, 10));
        p5.setLayout(new GridLayout(2, 1, 10, 10));
        t1 = new JTextArea();
        t2 = new JTextArea();
        s1 = new JScrollPane(t1);
        s2 = new JScrollPane(t2);
        p5.add(s1);
        p5.add(s2);

        hb=new JButton("GO TO Home Page");
        p1.add(hb);
        con = new JButton("Covate Binary Number to Text Formate");
        cons = new JButton("Covate Binary Number Text Formate and Save");
        p2.add(con);
        p2.add(cons);
        Font font = new Font("arial", Font.BOLD, 20);
        Font font1 = new Font("arial", Font.BOLD, 26);
        con.setFont(font);
        cons.setFont(font);
        t1.setFont(font1);
        t2.setFont(font1);
        t1.setLineWrap(true);
        t2.setLineWrap(true);
        t1.setWrapStyleWord(true);
        t2.setWrapStyleWord(true);
        t1.setToolTipText("Type Binary Number");
        t2.setEditable(false);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        con.setCursor(cursor);
        cons.setCursor(cursor);
        hb.setCursor(cursor);
        hb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Conveter("Binary to Text OR Text to Binary").setVisible(true);
            }
        });
        con.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Field The First Text Area","WARNING",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    p=0;
                    binaryToText();
                }
            }
        });
        cons.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Field The First Text Area","WARNING",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    p=1;
                    String[] str1=binaryToText();
                    try {
                        StringBuilder strb=new StringBuilder();
                        for(String str2:str1) {
                            int a=Integer.parseInt(str2,2);
                            strb.append((char)a);
                        }
                        t2.append(strb.toString());
                        
                        JFileChooser fc=new JFileChooser();
                        File fx=new File(System.getProperty("user.home"));
                        fc.setCurrentDirectory(new File(fx.getAbsolutePath()+"/Desktop"));
                        fc.setSelectedFile(new File("binary.txt"));
                        fc.setDialogTitle("Specify a file to save");
                        fc.showSaveDialog(null);
                        String sp=fc.getSelectedFile().getAbsolutePath();
                        BufferedWriter bw = new BufferedWriter(new FileWriter(sp));
                        bw.write(strb.toString());
                        bw.close();
                    } 
                    catch (NumberFormatException e2) {
                        JOptionPane.showMessageDialog(null,"Your Input Number is Not Binary Number","WARNING",JOptionPane.WARNING_MESSAGE);
                        t2.setEditable(false);
                    }
                    catch (NullPointerException e1) {
                        JOptionPane.showMessageDialog(null, "You Not Select Any Part and File is Not Save", "WARNING",JOptionPane.WARNING_MESSAGE);
                    }
                    catch(IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e ){
                t1.requestFocus();
            }
        });
    }
    public String[] binaryToText() {
        t2.setText("");
        t2.setEditable(true);
        String str1=t1.getText();
        String[] str2=str1.split("\\s");
        if(p==0) {
            try {
                StringBuilder strb=new StringBuilder();
                for(String str3:str2) {
                    int a=Integer.parseInt(str3,2);
                    strb.append((char)a);
                }
                t2.append(strb.toString());
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Your Input Number is Not Binary Number","WARNING",JOptionPane.WARNING_MESSAGE);
                t2.setEditable(false);
            }
        }
        return str2;
    }

    public static void main(String[] args) {
        new BinaryToText("Binary Number to Text Formate").setVisible(true);
    }
}
