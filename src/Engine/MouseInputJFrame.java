package Engine;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class MouseInputJFrame extends JFrame implements MouseMotionListener, MouseListener{

	public MouseInputJFrame(String name) {
		super(name);
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		Keyboard.setMousePos(e.getPoint()); 
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	
	@Override
	public void mouseDragged(MouseEvent e) {} //Not needed but required for the interface

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			Keyboard.setMousePressed(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			Keyboard.setMousePressed(false);
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
