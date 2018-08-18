package visualize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main extends JFrame {
	
	//number of elements
	private JLabel lblElementCount = new JLabel("Elements:");
	private JTextField txtElementCount = new JTextField();
	//private JButton btnElementCount  = new JButton("Set");
	
	//iterations (display)
	private static int iterations = 0;
	public int getIterations() {return iterations;}
	public void setIterations(int i) {iterations = i;}
	public void updateIterations() {
		lblIterations.setText("Iterations: " + iterations);
	}
	private static JLabel lblIterations = new JLabel("Iterations: " + iterations);
	
	//delay and time set
	private JLabel lblDelay = new JLabel("Delay (ms):");
	private JTextField txtDelay = new JTextField();
	public JTextField getTxtDelay() {return txtDelay;}
	private JLabel lblTime = new JLabel("Time (s):");
	private JTextField txtTime = new JTextField();
	public JTextField getTxtTime() {return txtTime;}
	
	///NEXT COLUMN///
	
	//select sort
	private JLabel lblSelectSort = new JLabel("Sort:");
	String[] sortChoices = {"Selection Sort", "Insertion Sort", "Quick Sort"};
	JComboBox<String> drpChooseSort = new JComboBox<String>(sortChoices);
	private JButton btnSort = new JButton("Sort");
	
	//select scramble
	private JLabel lblSelectScramble = new JLabel("Mix:");
	String[] scrambleChoices = {"Random"}; //TODO
	JComboBox<String> drpChooseScramble = new JComboBox<String>(scrambleChoices);
	private JButton btnScramble = new JButton("Mix");
	
	///NEXT COLUMN///
	
	//choose color
	private JLabel lblColorSet = new JLabel("Colors: ");
	String[] colorChoices = {"Rainbow", "Black", "White"};
	JComboBox<String> drpChooseColor = new JComboBox<String>(colorChoices);
	private JButton btnColorSet = new JButton("Set");
	
	//choose background
	private JLabel lblBackgroundSet = new JLabel("Backgd: ");
	String[]backgroundChoices = {"White", "Black", "Gray"};
	JComboBox<String> drpChooseBackground = new JComboBox<String>(backgroundChoices);
	private JButton btnBackgroundSet = new JButton("Set");
	
	//kill switch
	private JButton btnKILL = new JButton("Force Stop");

	private SortGraphics panel = new SortGraphics(this);
	//private JTextField txtB = new JTextField(); (template stuff)
	//private JTextField txtC = new JTextField();

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
		//panel
		panel.initElements(50);
		
		//number of elements
		lblElementCount.setBounds(50,450, 70,30);
		txtElementCount.setBounds(140,450, 100,30);
		//btnElementCount.setBounds(260,450, 70,30);
		add(lblElementCount);
		add(txtElementCount);
		//add(btnElementCount);
		
		//iterations (display)
		lblIterations.setBounds(50,485, 190,30);
		add(lblIterations);
		
		//delay and time set
		lblDelay.setBounds(50,520, 80,30);
		txtDelay.setBounds(118,520, 40,30);
		lblTime.setBounds(170,520, 80,30);
		txtTime.setBounds(225,520, 40,30);
		add(lblDelay);
		add(lblTime);
		add(txtDelay);
		add(txtTime);
		
		///NEXT COLUMN///
		
		//select sort
		lblSelectSort.setBounds(260,450, 30,30);
		drpChooseSort.setBounds(300,450, 110,30);
		btnSort.setBounds(415,450, 60,30);
		add(lblSelectSort);
		drpChooseSort.setVisible(true);
		add(drpChooseSort);
		add(btnSort);
		
		//select scramble
		lblSelectScramble.setBounds(260,485, 30,30);
		drpChooseScramble.setBounds(300,485, 110,30);
		btnScramble.setBounds(415,485, 60,30);
		add(lblSelectScramble);
		drpChooseScramble.setVisible(true);
		add(drpChooseScramble);
		add(btnScramble);
		
		///NEXT COLUMN///
		
		//color
		lblColorSet.setBounds(520,450, 70,30);
		drpChooseColor.setBounds(580,450, 100,30);
		btnColorSet.setBounds(685,450, 60,30);
		add(btnColorSet);
		add(lblColorSet);
		drpChooseColor.setVisible(true);
		add(drpChooseColor);
		
		//background
		lblBackgroundSet.setBounds(520,485, 70,30);
		drpChooseBackground.setBounds(580,485, 100,30);
		btnBackgroundSet.setBounds(685,485, 60,30);
		add(lblBackgroundSet);
		drpChooseBackground.setVisible(true);
		add(drpChooseBackground);
		add(btnBackgroundSet);
		
		//kill switch
		btnKILL.setBounds(520,520, 100,30);
		add(btnKILL);

		//txtB.setBounds(100,35,100,20);
		//txtC.setBounds(100,65,100,20); (stuff that came with the template)

		add(panel);


		//add(txtB);
		//add(txtC); (stuff that came with the template)
	}

	private void initEvent(){

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});

		/*btnElementCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnElementCountClick(e);
			}
		});*/
		
		//number of elements
		txtElementCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtElementSet(e);
			}
		});
		
		//delay and time
		txtDelay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDelaySet(e);
			}
		});
		
		txtTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTimeSet(e);
			}
		});
		
		//sort
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSortClick(e);
			}
		});
		
		//scramble
		btnScramble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnScrambleClick(e);
			}
		});
		
		//sort type
		drpChooseSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drpChooseSortUpdate(e);
			}
		});
		
		//color
		btnColorSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnColorSetClick(e);
			}
		});
		
		//background
		btnBackgroundSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBackgroundSetClick(e);
			}
		});
		
		//kill switch
		btnKILL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnKILLClick(e);
			}
		});
		

		
	}
	
	private void txtElementSet(ActionEvent evt){
		try{
			double d = Double.valueOf(txtElementCount.getText());
			int x = (int)(d);
			if(x<1) {
				txtElementCount.setText("1");
				panel.initElements(1);
			} else if(x>500) {
				txtElementCount.setText("500");
				panel.initElements(500);
			} else {
				txtElementCount.setText(x+"");
				panel.initElements(x);
			}
			
		}catch(Exception e){
			String exc = e.toString();
			if(exc.contains("java.lang.NumberFormatException")) {
				txtElementCount.setText("100");
			}else {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void txtDelaySet(ActionEvent evt){
		try{
			double i = Double.valueOf(txtDelay.getText());
			int j = (int)i;
			panel.setSleep(j);
			panel.setTime();
		}catch(Exception e){
			String exc = e.toString();
			if(exc.contains("java.lang.NumberFormatException")) {
				txtElementCount.setText("100");
			}else {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void txtTimeSet(ActionEvent evt){
		try{
			double d = Double.valueOf(txtTime.getText());
			panel.setTime(d);
			panel.setSleep();
		}catch(Exception e){
			String exc = e.toString();
			if(exc.contains("java.lang.NumberFormatException")) {
				txtElementCount.setText("100");
			}else {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void drpChooseSortUpdate(ActionEvent evt) {
		try{
			panel.updateIterations((String)drpChooseSort.getSelectedItem());
		}catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
		}
	}
  
	private void btnSortClick(ActionEvent evt) {
		try{
			panel.sort((String) drpChooseSort.getSelectedItem());
		}catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnScrambleClick(ActionEvent evt) {
		try{
			panel.scramble((String) drpChooseScramble.getSelectedItem());
		}catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnColorSetClick(ActionEvent evt) {
		try{
			panel.elementColor((String) drpChooseColor.getSelectedItem());
		}catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnBackgroundSetClick(ActionEvent evt) {
		try{
			panel.backgroundColor((String) drpChooseBackground.getSelectedItem());
		}catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, 
				e.toString(),
				"Error", 
				JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void btnKILLClick(ActionEvent evt) {
		try{
			panel.setKILL(true);
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

