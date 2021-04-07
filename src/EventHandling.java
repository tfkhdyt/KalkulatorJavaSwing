import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandling {
    private JButton b1, b2;
    private JTextField t1, t2;
    private JPanel panel1, panel2;
    private JLabel l1, l2;
    private JFrame f;
    private double a, b, c;
    private String konv1 = "Suhu dalam Celsius adalah ";
    private String konv2 = "Suhu dalam Fahrenheit adalah ";
    
    public EventHandling(){
        f = new JFrame("Konversi Suhu");
        b1 = new JButton("Konversi ke Fahrenheit");
        b2 = new JButton("Konversi ke Celsius");
        l1 = new JLabel("Suhu dalam Celsius");
        l2 = new JLabel("Suhu dalam fahrenheit");
        t1 = new JTextField("10");
        t2 = new JTextField("10");
    }

    public void hitungSuhu(){
        panel1 = new JPanel();
        panel2 = new JPanel();
        b1.addActionListener(new FahrenheitHandler());
        b2.addActionListener(new CelsiusHandler());
        panel1.add(l1);
        panel1.add(t1);
        panel1.add(b1);
        panel2.add(l2);
        panel2.add(t2);
        panel2.add(b2);
        JTabbedPane tab = new JTabbedPane();
        tab.add(panel1, "Celsius ke Fahrenheit");
        tab.add(panel2, "Fahrenheit ke Celsius");
        f.getContentPane().add(tab, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,100);
        f.setVisible(true);
    }
    
    private class FahrenheitHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                a = Double.parseDouble(t1.getText());
                b = a*1.8+32;
                JOptionPane.showConfirmDialog(null, konv2+b, "Hasil", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception j){
                JOptionPane.showConfirmDialog(null, "Masukkan Angka!", "Error", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);                
            }
        }
    }
    
    private class CelsiusHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                a = Double.parseDouble(t2.getText());
                b = (a-32)/1.8;
                JOptionPane.showConfirmDialog(null, konv1+b, "Hasil", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception j){
                JOptionPane.showConfirmDialog(null, "Masukkan Angka!", "Error", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);                
            }
        }
    }
    
    public static void main(String[] args){
        EventHandling eh = new EventHandling();
        eh.hitungSuhu();
    }
}
