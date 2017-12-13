
import javax.swing.*;
import java.awt.*;
public class Window2 extends JFrame {
 private Container pane;

 private JButton b;
 private JTextField t;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window2() {
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
     b = new JButton("Convert!");
     t = new JTextField(12);
     pane.add(b);
     pane.add(t);
 }
 public void actionPerformed(ActionEvent e){
 String event=e.getActionCommand();
 if(event.equals("Convert!"){
    t.setText();
    }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window2 g = new Window2();
     g.setVisible(true);
  }
}
