
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener{
 private Container pane;
 private JButton b;
 private JTextField t;
 private JCheckBox c;
	
	public void actionPerformed(ActionEvent e){
		 double x = Double.parseDouble(t.getText());
		String s=e.getActionCommand();
		System.out.println(s);
		 if(s.equals("Convert!")){
            if( c.isSelected() ){
                t.setText(t.getText().toUpperCase());
            }else{
                t.setText("What do you want?");
            }
        }
        if(s.equals("Clear")){
            //button code here
            t.setText("");
        }

    }
		
		
  //CONSTRUCTOR SETS EVERYTHING UP
  public TemperatureWindow() {
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
     b = new JButton("Convert!");
     t = new JTextField(12);
     c = new JCheckBox("Farenheit?");
     pane.add(b);
     pane.add(t);
   pane.add(c);
 }
 
public static double CtoF(double t){
	return 9 * t / 5 + 32;
    }
public static double FtoC(double t){
	return 5 * (t - 32) / 9;
}

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     TemperatureWindow g = new TemperatureWindow();
     g.setVisible(true);
  }
}
