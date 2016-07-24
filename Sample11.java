import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample11 extends JApplet
{
    private JLabel lb;
    private JPanel pn;
    private JCheckBox ch1, ch2, tmp;

    public void init()
    {
	lb = new JLabel("いらっしゃいませ");
	pn = new JPanel();
	ch1 = new JCheckBox("車");
	ch2 = new JCheckBox("トラック");

	pn.add(ch1);
	pn.add(ch2);
	add(lb, BorderLayout.NORTH);
	add(pn, BorderLayout.SOUTH);

	ch1.addItemListener(new SampleItemListener());
	ch2.addItemListener(new SampleItemListener());
    }

    class SampleItemListener implements ItemListener
    {
	public void itemStateChanged(ItemEvent e)
	{
	    if(e.getStateChange() == ItemEvent.SELECTED){
		tmp = (JCheckBox) e.getSource();
		lb.setText(tmp.getText() + "を選びました．");
	    }
	    else if(e.getStateChange() == ItemEvent.DESELECTED){
		tmp = (JCheckBox) e.getSource();
		lb.setText(tmp.getText() + "をやめました．");
	    }  
	}
    }
}
       
