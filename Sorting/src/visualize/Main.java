package visualize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main extends JFrame {
	//lol
	
	//number of elements
	private JLabel lblElementCount = new JLabel("Elements:");
	private JTextField txtElementCount = new JTextField();
	private JButton btnElementCount  = new JButton("Set");
	
	//choose color
	private JLabel lblColorSet = new JLabel("Colors: ");
	String[] colorChoices = {"Rainbow", "White"};
	JComboBox<String> drpChooseColor = new JComboBox<String>(colorChoices);
	private JButton btnColorSet = new JButton("Set");

  
	private JTextField txtB = new JTextField();
	private JTextField txtC = new JTextField();

  	
	
	private JLabel lblC = new JLabel("C :");

	public Main(){
		setTitle("Sorting Visualizer");
		setSize(800,600);
		setLocation(new Point(300,200));
		setLayout(null);    
		setResizable(false);

		initComponent();    
		initEvent();   
	}

	private void initComponent(){
		//number of elements
		lblElementCount.setBounds(50,450, 70,30);
		txtElementCount.setBounds(140,450, 100,30);
		btnElementCount.setBounds(260,450, 70,30);
		
		//color
		lblColorSet.setBounds(50,500, 70,30);
		drpChooseColor.setBounds(140,500, 100,30);
		btnColorSet.setBounds(260,500, 70,30);

		
		txtB.setBounds(100,35,100,20);
		txtC.setBounds(100,65,100,20);

    
		
		lblC.setBounds(20,65,100,20);


		add(lblElementCount);
		add(txtElementCount);
		add(btnElementCount);
		
		add(lblColorSet);
		drpChooseColor.setVisible(true);
		add(drpChooseColor);
		
		add(btnColorSet);

		
		add(lblC);


		add(txtB);
		add(txtC);
	}

	private void initEvent(){

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});

		btnElementCount.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent e) {
			btnElementCountClick(e);
			}
		});

		btnColorSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnColorSetClick(e);
			}
		});
	}
  
	private void btnElementCountClick(ActionEvent evt){
		System.exit(0);
	}
  
	private void btnColorSetClick(ActionEvent evt){
		Integer x,y,z;
		try{
			x = Integer.parseInt(txtElementCount.getText());
			y = Integer.parseInt(txtB.getText());
			z = x + y;
			txtC.setText(z.toString());

		}catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
		}	
	}
  
	public static void main(String[] args){
		Main f = new Main();
	    f.setVisible(true);
	}
}
