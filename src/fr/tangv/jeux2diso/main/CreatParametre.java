package fr.tangv.jeux2diso.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class CreatParametre {

	public static final String example = "\r\n" + 
			"	public {variable} get{name}() {\r\n" + 
			"		if (verif(\"{namelow}\")) {\r\n" + 
			"			return yfile.{getyml}(\"{namelow}\");\r\n" + 
			"		} else {\r\n" + 
			"			return {return};\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"	\r\n" + 
			"	public void set{name}({variable} {variablename}) {\r\n" + 
			"		yfile.set(\"{namelow}\", {variablename});\r\n" + 
			"		try {\r\n" + 
			"			yfile.save();\r\n" + 
			"		} catch (IOException e) {\r\n" + 
			"			e.printStackTrace();\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"	";
	
	public static void main(String args[]) {
		JFrame frame = new JFrame("CreatParametre");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		JTextArea tpane = new JTextArea();
		tpane.setEditable(false);
		JScrollPane spane = new JScrollPane(tpane);
		String text = "{variable}=\n{name}=\n{variablename}=var\n{getyml}=get\n{return}=null";
		JTextArea paneval = new JTextArea(text);
		paneval.addKeyListener(new KeyListener() {
			private Map<String,String> map;
			private String getMap(String path) {
				if (map.containsKey(path)) {
					return map.get(path);
				} else {
					return "null";
				}
			}
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {
				map = new HashMap<String, String>();
				String[] text = paneval.getText().split("\n");
				for(String string : text) {
					String[] s = string.split("=");
					if(s.length >= 2) {
						if (!map.containsKey(s[0])) {
							map.put(s[0], s[1]);
						} else {
							map.replace(s[0], s[1]);
						}
					}
				}
				tpane.setText(example
						.replace("{variable}", getMap("{variable}"))
						.replace("{name}", getMap("{name}"))
						.replace("{namelow}", getMap("{name}").toLowerCase())
						.replace("{getyml}", getMap("{getyml}"))
						.replace("{return}", getMap("{return}"))
						.replace("{variablename}", getMap("{variablename}"))
						);
			}
			@Override public void keyPressed(KeyEvent e) {}
		});
		JScrollPane spaneval = new JScrollPane(paneval);
		JSplitPane split = new JSplitPane(0, spaneval, spane);
		frame.getContentPane().add(split);
		frame.setVisible(true);
	}
	
}
