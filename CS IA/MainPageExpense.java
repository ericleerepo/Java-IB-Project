import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class MainPageExpense here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainPageExpense extends JFrame
{
    public MainPageExpense(){
        super("Expense Calculator");
        Container c = getContentPane();
        c.setBackground(Color.PINK);
        c.setLayout(new GridLayout(3,1));
        
        
    }
}
