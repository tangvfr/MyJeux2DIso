package fr.tangv.jeux2diso.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout.Constraints;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MaskConvert {

	public static void sendMessageError(String string) {
		JOptionPane.showMessageDialog(null, string, "MaskConvert", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void sendMessageInfo(String string) {
		JOptionPane.showMessageDialog(null, string, "MaskConvert", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			sendMessageInfo("In image if the color most 0x808080 then egale true else egale false");
			JFileChooser filechose = new JFileChooser();
			if (filechose.showOpenDialog(null) == 0) {
				File file = filechose.getSelectedFile();
				if (file.exists()) {
					try {
						BufferedImage image = ImageIO.read(file);
						try {
							image.getHeight();
						} catch (Exception e) {
							sendMessageError("Error file is not valid (no image)");
							return;
						}
						String text = "boolean[][] mask = new boolean[][] {";
						BufferedImage mask = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
						for (int y = 0; y < image.getHeight(); y++) {
							String line = "\n{";
							for (int x = 0; x < image.getWidth(); x++) {
								System.out.println(y+":"+x);
								Color color = new Color(image.getRGB(x, y));
								if (color.getRed()  >= 128 && color.getGreen() >= 128 && color.getBlue() >= 128) {
									line += "true";
									mask.setRGB(x, y, Color.darkGray.getRGB());
								} else {
									line += "false";
								}
								if (x < image.getWidth()-1)
									line += ",";
							}
							if (y < image.getHeight()-1)
								line += "},";
							text += line;
						}
						text += "}\n};";
						JFrame frame = new JFrame("MaskConvert Size = "+image.getWidth()+"x"+image.getHeight());
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setSize(500, 500);
						frame.setLocationRelativeTo(null);
						JTextArea tpane = new JTextArea(text);
						tpane.setEditable(false);
						tpane.select(0, text.length());
						JScrollPane spane = new JScrollPane(tpane);
						JLabel it = new JLabel(new ImageIcon(mask));
						frame.getContentPane().add(spane, );
						frame.getContentPane().add(menu);
						frame.setVisible(true);
					} catch (IOException e) {
						sendMessageError("Error with read image/file");
					}
				} else {
					sendMessageError("Error File dont exists");
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			sendMessageError("Error with UIManager");
		}
	}
	
}
