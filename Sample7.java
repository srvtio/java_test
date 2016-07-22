import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample7 extends JApplet
{
    private JLabel lb1, lb2 ;

    public void init()
    {
	lb1 = new JLabel("矢印きーでお選びください") ;
	lb2 = new JLabel() ;

	add(lb1, BorderLayout.NORTH) ;
	add(lb2, BorderLayout.SOUTH) ;

	addKeyListener(new SampleKeyListener()) ;
	setFocusable(true) ;
    }

    class SampleKeyListener extends KeyAdapter
    {
	public void KeyPressed(KeyEvent e)
	{
	    String str = "なんもない" ;
	    // int k = e.getKeyCode() ;
	    // switch(k){
	    // case KeyEvent.VK_UP:
	    // 	str = "上" ; break ;
	    // case KeyEvent.VK_DOWN:
	    // 	str = "下" ; break ;
	    // case KeyEvent.VK_LEFT:
	    // 	str = "左" ; break ;
	    // case KeyEvent.VK_RIGHT:
	    // 	str = "右" ; break ;
	    // default :
	    // 	str = "他のキー" ;
	    // }

	    char key = e.getKeyChar();
	    if (key == 'a'){
		str ="aのキー";
	    }
	
	    lb2.setText(str + "ですね．") ;
	}
    }
}
       
