import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample10 extends JApplet
{
    private JLabel lb ;
    private JPanel pn ;
    private JButton bt ;
    private Icon ic ;

    public void init()
    {
	lb = new JLabel("いらっしゃいませ") ;
	pn = new JPanel() ;
	bt = new JButton("購入") ;
	ic = new ImageIcon(getImage(getDocumentBase(),"car.eps")) ;

	bt.setIcon(ic) ;

	pn.add(bt) ;
	add(lb, BorderLayout.NORTH) ;
	add(pn, BorderLayout.SOUTH) ;

	bt.addActionListener(new SampleActionListener()) ;
    }

    class SampleActionListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    lb.setText("ご購入ありがとうございます．") ;
	    bt.setEnabled(false) ;
	}
    }
}
       
