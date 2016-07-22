import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample6 extends JApplet
{
    private JLabel lb ;

    public void init()
    {
	lb = new JLabel("ようこそ") ;

	add(lb, BorderLayout.NORTH) ;

	addMouseListener(new SampleMouseListener()) ;
    }

    class SampleMouseListener extends MouseAdapter
    {
	public void mouseEntered(MouseEvent e)
	{
	    lb.setText("いらっしゃいませ") ;
	}
	public void mouseExited(MouseEvent e)
	{
	    lb.setText("ようこそ") ;
	}
    }
}
       
