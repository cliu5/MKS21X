import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JButton b,b2;
    private JCheckBox c;
    private JTextField t;

    public void actionPerformed(ActionEvent e){
	 Double doubleVal = Double.parseDouble(t.getText());
        String s = e.getActionCommand();
        if(s.equals("Convert")){
            //button code here
            if( c.isSelected() ){
		   
                t.setText(Double.toString(FtoC(doubleVal)));
            }else{
                t.setText(Double.toString(CtoF(doubleVal)));
            }
        }
        if(s.equals("Clear")){
            //button code here
            t.setText("");
        }

    }

    public TemperatureWindow() {
        this.setTitle("My first GUI");
        this.setSize(500,80);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        b = new JButton("Convert");
        b2 = new JButton("Clear");
        c = new JCheckBox("Farenheit to Celsius? (If C to F, don't check)");
        t = new JTextField(15);

        b.addActionListener(this);
        b2.addActionListener(this);
        t.addActionListener(this);
        c.addActionListener(this);

        pane.add(t);
        pane.add(c);
        pane.add(b);
        pane.add(b2);

    }

    public static void main(String[] args) {
        TemperatureWindow g = new TemperatureWindow();
        g.setVisible(true);
    }

public static Double CtoF(Double t){
	return 9 * t / 5 + 32;
    }
public static Double FtoC(Double t){
	return 5 * (t - 32) / 9;
}
}

