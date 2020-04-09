package jar_tip;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

import java.io.*;
import java.net.*;

class Jar_with_graphics_demo
{
	public static void main(String args[ ])
	{
		JFrame fr1 = new JFrame("Demo - Jar with graphics n text files");
		fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr1.setBounds(50, 50, 400, 600);
		Container contentpane = fr1.getContentPane();
		contentpane.setLayout(null);

		Jar_demo_panel pane = new Jar_demo_panel( );
		pane.setLocation(1, 25);
		contentpane.add(pane);

		URL india_flag_url = Jar_with_graphics_demo.class.getResource("/my_files/India-flag.jpg");
		Image india_flag_image = Toolkit.getDefaultToolkit().getImage(india_flag_url);
		ImageIcon india_flag = new ImageIcon(india_flag_image); 
		String buttonTxt = "<HTML><FONT COLOR='BLUE'><B>" + 
						"Read national anthem.</B></FONT></HTML>";
		JButton flag_button = new JButton(buttonTxt, india_flag);
		flag_button.setVerticalTextPosition(AbstractButton.BOTTOM);
		flag_button.setHorizontalTextPosition(AbstractButton.CENTER);
		// flag_button.setContentAreaFilled(false);
		flag_button.setToolTipText("Click to read national anthem.");
		flag_button.setForeground(new Color(102, 102, 102));

		ActionListener listen1 = new ActionListener()
		{   // Anonymous inner class
			public void actionPerformed(ActionEvent ae)
			{
				JFrame anthemFrame = new AnthemFrame();
				anthemFrame.setBounds(500, 50, 400, 600);
				anthemFrame.setVisible(true);
			}
		}; // Anonymous inner class ends.
		flag_button.addActionListener(listen1);

		flag_button.setBounds(50, 380, 300, 150);
		contentpane.add(flag_button);

		fr1.setVisible(true);
	}
} // class Jar_with_graphics_demo ends.


class Jar_demo_panel extends JPanel
{
	Image india_map_image;

	Jar_demo_panel()
	{
		setSize(396, 340);
		URL india_map_url = this.getClass().getResource("/my_files/India-map.jpg");
		india_map_image = Toolkit.getDefaultToolkit().getImage(india_map_url); 
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int w = india_map_image.getWidth(this);
		int h = india_map_image.getHeight(this);
		int x = (396 - w) / 2;  // Centering in the frame of width 400 pixels. 
		int y = 2;
		g.drawImage(india_map_image, x, y, w, h, this);
	}
} // class Jar_demo_panel ends.

