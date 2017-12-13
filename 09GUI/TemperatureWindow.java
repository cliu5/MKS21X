
import javax.swing.*;
import java.awt.*;
public class Window2 extends JFrame {
 private Container pane;

 private JButton b;
 private JTextField t;
  private JCheckBox c;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window2() {
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
 public void actionPerformed(ActionEvent e){
 String event=e.getActionCommand();
 if(event.equals("Convert!"){
  if(c.isSelected()){
   t.setText(FtoC(Double.parseDouble(t.getText)));
  }
    }
    }
public static double CtoF(double t){
	return 9 * t / 5 + 32;
    }
public static double FtoC(double t){
	return 5 * (t - 32) / 9;
}

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window2 g = new Window2();
     g.setVisible(true);
  }
}
