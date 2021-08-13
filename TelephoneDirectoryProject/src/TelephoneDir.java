import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.*;
import java.util.*;
public class TelephoneDir extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1938892008740243132L;

	static JLabel label1,label2,label3,sep;
	static JButton addB,modify,delete,clear,browse,viewAll;
	static JTextField txtA1;
	static JTextArea  txtA2;
	static JOptionPane dialog;
	
	static Properties prop;
	static InputStream input = null;
	static OutputStream output = null;
	
	static TelephoneDir phoneDir;
	
	public TelephoneDir(){
		super("Telephone Directory :");
		prop = new Properties();
		setLayout(new FlowLayout());
		
		try{
			input = new FileInputStream("resources/TelephoneDir.properties");
			prop.load(input);
		}catch(Exception ex){
			ex.printStackTrace();
			System.out.println("there was some error in opening properties file : "+ex);
		}

		label1 = new JLabel("        Name :       ");
		add(label1);
		txtA1 = new JTextField(15);
		add(txtA1);
		label2 = new JLabel("  Phone Number : ");
		add(label2);
		txtA2 = new JTextArea(1,15);
		add(txtA2);
		sep = new JLabel("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		add(sep);
		addB=new JButton("ADD RECORD");
		add(addB);
		browse=new JButton("VIEW RECORD");
		add(browse);
		modify=new JButton("MODIFY");
		add(modify);
		viewAll=new JButton("VIEW ALL RECORDS");
		add(viewAll);
		delete=new JButton("DELETE");
		add(delete);
		clear=new JButton("CLEAR TEXT");
		add(clear);
		sep = new JLabel("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		add(sep);
		label3 = new JLabel("");
		add(label3);
		sep = new JLabel("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		add(sep);
		
		addB.addActionListener(this);
		browse.addActionListener(this);
		modify.addActionListener(this);
		viewAll.addActionListener(this);
		delete.addActionListener(this);
		clear.addActionListener(this);
		txtA1.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==txtA1){
		}
		
		if(e.getSource()==addB){
	 	 	label3.setText("To ADD new record to the DataBase");
	 	 	
	 	 	String name=txtA1.getText();
			String phoneNumber=txtA2.getText();
			String existingPhone = prop.getProperty(name);
			if(name.length()==0 || phoneNumber.length()==0) {
				dialog = new JOptionPane();
				JOptionPane.showMessageDialog(this,
					    "Check that fields are not empty.","Message",
					    JOptionPane.PLAIN_MESSAGE);
			}
			else if(existingPhone == null){
				try
				 {
					output = new FileOutputStream("resources/TelephoneDir.properties");
					prop.setProperty(name, phoneNumber);
					prop.store(output, null);
					output.flush();
					output.close();
					txtA1.setText("");
					txtA2.setText("");
				 }
				catch(Exception e2)
				{
					label3.setText("Check that fields are not empty.");
				}
			}else{
				dialog = new JOptionPane();
				JOptionPane.showMessageDialog(this,
					    "Name already exists.You cannot add it but modify.","Message",
					    JOptionPane.PLAIN_MESSAGE);
				//txtA2.setText(existingPhone);
				txtA1.setText("");
				txtA2.setText("");
			}
		}
		
		if(e.getSource()==browse){
			label3.setText("VIEW phone number against a name");
			
	 	 	try{
				String name=txtA1.getText();
				//String phoneNumber = txtA2.getText();
			    String existingPhone = prop.getProperty(name);
			    
			    if(name.length()==0) {
			    	dialog = new JOptionPane();
					JOptionPane.showMessageDialog(this,
						    "Enter a name to search.","Message",
						    JOptionPane.PLAIN_MESSAGE);
			    }
			    else if(existingPhone != null){
					txtA2.setText(existingPhone);
				}else{
					dialog = new JOptionPane();
					JOptionPane.showMessageDialog(this,
						    "Name does not exist.","Message",
						    JOptionPane.PLAIN_MESSAGE);
				}
			}
			catch(Exception e2)
			{
				label3.setText("Error in VIEW : "+e2);
			}
		}
		
		if(e.getSource()==modify){
	 	 	label3.setText("MODIFY phone number against a name");
	 	 	try{
				String name=txtA1.getText();
			    String phoneNumber=txtA2.getText();
			    
			    String existingPhone = prop.getProperty(name);
			    if(name.length()==0 || phoneNumber.length()==0) {
					dialog = new JOptionPane();
					JOptionPane.showMessageDialog(this,
						    "Check that fields are not empty.","Message",
						    JOptionPane.PLAIN_MESSAGE);
				}
			    else if(existingPhone != null){
					output = new FileOutputStream("resources/TelephoneDir.properties");
					prop.setProperty(name, phoneNumber);
					prop.store(output, null);
					output.flush();
					output.close();
					txtA1.setText("");
					txtA2.setText("");
					
				}else{
					dialog = new JOptionPane();
					JOptionPane.showMessageDialog(this,
						    "This cannot be modified because name does not exist.","Message",
						    JOptionPane.PLAIN_MESSAGE);
					txtA1.setText("");
					txtA2.setText("");
				}
			}
			catch(Exception e2)
			{
				label3.setText("Error in MODIFY : "+e2);
			}
		}
		
		if(e.getSource()==viewAll) {
			label3.setText("VIEW ALL records in the database");
			String all = "<html>";
			boolean empty = true;
			try {
				for (String key: prop.stringPropertyNames()) {
					empty = false;
					all += key + ": " + prop.getProperty(key) + "<br/>";
		        }
				all += "</html>";
				if(empty == true) {
					dialog = new JOptionPane();
					JOptionPane.showMessageDialog(this,
						    "No records exist","Message",
						    JOptionPane.PLAIN_MESSAGE);
				}
				else
					label3.setText(all);
			}
			catch(Exception e2)
			{
				label3.setText("Error in VIEW ALL : "+e2);
			}
		}
		
		if(e.getSource()==delete){
	 	 	label3.setText("DELETE record from the database");
	 	 	try{
				String ts=txtA1.getText();
				String existingPhone = prop.getProperty(ts);
				
				if(ts.length()==0) {
					dialog = new JOptionPane();
					JOptionPane.showMessageDialog(this,
						    "Enter a name to delete.","Message",
						    JOptionPane.PLAIN_MESSAGE);
				}
				else if(existingPhone != null){
					output = new FileOutputStream("resources/TelephoneDir.properties");
					prop.remove(ts);
					prop.store(output, null);
					output.flush();
					output.close();
					txtA1.setText("");
					txtA2.setText("");
				}else{
					dialog = new JOptionPane();
					JOptionPane.showMessageDialog(this,
						    "This cannot be deleted because name does not exist.","Message",
						    JOptionPane.PLAIN_MESSAGE);
				}
			}
			catch(Exception e2)
			{
				label3.setText("Error in DELETE : "+e2);
			}
		}
		
		if(e.getSource()==clear){
	 	 	label3.setText("CLEARS both the fields");
	 	 	txtA1.setText("");
			txtA2.setText("");
		}
	}
	public static void main(String args[]){
		phoneDir = new TelephoneDir();
		phoneDir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		phoneDir.setSize(350,420);
		phoneDir.setVisible(true);   	
	}

}
