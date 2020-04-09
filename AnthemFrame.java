package jar_tip;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

import java.io.*;
import java.net.*;

class AnthemFrame extends JFrame
{
	AnthemFrame()
	{
		super("India - National Anthem");
		JPanel pane = new AnthemPanel();
		setContentPane(pane);	 

		WindowListener listenWin = 
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					setVisible(false);
					dispose();
				}
			};
		addWindowListener(listenWin);
	}
} // class AnthemFrame ends.

class AnthemPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Font f1 = new Font("Serif", Font.BOLD, 12);
		g.setFont(f1);

		int i = 0;
		String line;
		try
		{
			InputStream txt_file = getClass().getResourceAsStream("/my_files/National-anthem-India.txt");
			InputStreamReader anthem_file = new InputStreamReader(txt_file);
			BufferedReader data = new BufferedReader(anthem_file);
			while((line = data.readLine()) != null)
			{
				g.drawString(line, 15, 30+i*40);
				i++;
			}
			anthem_file.close();
		}
		catch(IOException e)
		{
			System.out.println("Error while reading the file National-anthem-India.txt");
		}	  
	}
} // class AnthemPanel ends.
