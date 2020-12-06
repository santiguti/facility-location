package interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.data.Customer;
import logic.data.DistributionCenter;
import logic.data.ListCustomer;
import logic.data.ListDistributionCenter;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Screen extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	int width, height;
	
	//Hacer todos los news de aca para abajo
	CardLayout layout = new CardLayout();
	JPanel panel = new JPanel();
	JPanel menu = new JPanel();
	JPanel map = new JPanel();
	
	ListCustomer clients = new ListCustomer();
	ListDistributionCenter centers = new ListDistributionCenter();
	DefaultTableModel clientModel = new DefaultTableModel(1, 2);
	DefaultTableModel centersModel = new DefaultTableModel(1, 3);
	JTable clientsList = new JTable(clientModel);
	JTable centersList = new JTable(centersModel);
	
	JButton addClient = new JButton("Add");
	JButton removeClient = new JButton("Remove");
	JSpinner toBeRemovedClient = new JSpinner();
	JTextField latitudeClient = new JTextField();
	JTextField longitudeClient = new JTextField();
	
	JButton addCenter = new JButton("Add");
	JButton removeCenter = new JButton("Remove");
	JSpinner toBeRemovedCenter = new JSpinner();
	JTextField centerID = new JTextField();
	JTextField latitudeCenter = new JTextField();
	JTextField longitudeCenter = new JTextField();
	
	JButton menuToMap = new JButton("\u2192");
	JButton mapToMenu = new JButton("\u2190");
	
	public Screen(int width, int height) {
		panel.setLayout(layout);
		addButtons();
		
		setSize(1024, 768);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Tienda Planner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		requestFocus();
	}
	
	private void addButtons() {
		//Setteo layouts a null, les agrego background
		menu.setLayout(null);
		menu.setBackground(Color.GRAY);
		panel.add(menu, "Menu");
		
		map.setLayout(null);
		map.setBackground(Color.black);
		panel.add(map, "Map");
		
		getContentPane().add(panel);
		layout.show(panel, "Menu");
		
		//Luego agrego labels, buttons, list a los diferentes layouts y les setteo font, posicion, etc
		menu.add(clientsList);
		clientsList.setBounds(10, 59, 500, 260);
		clientModel.setValueAt("Latitude", 0, 0);
		clientModel.setValueAt("Longitude", 0, 1);
		
		menu.add(addClient);
		addClient.setBounds(680, 171, 150, 25);
		
		menu.add(removeClient);
		removeClient.setBounds(520, 280, 150, 25);
		
		menu.add(toBeRemovedClient);
		toBeRemovedClient.setBounds(680, 280, 40, 25);
		toBeRemovedClient.setModel(new SpinnerNumberModel(0, 0, clients.size(), 1));
		
		menu.add(latitudeClient);
		latitudeClient.setBounds(596, 123, 150, 25);
		menu.add(longitudeClient);
		longitudeClient.setBounds(756, 123, 150, 25);
		
		menu.add(centersList);
		centersList.setBounds(10, 409, 500, 260);
		centersModel.setValueAt("Center ID", 0, 0);
		centersModel.setValueAt("Latitude", 0, 1);
		centersModel.setValueAt("Longitude", 0, 2);
		
		menu.add(addCenter);
		addCenter.setBounds(680, 494, 150, 25);
		
		menu.add(removeCenter);
		removeCenter.setBounds(520, 610, 150, 25);
		
		menu.add(toBeRemovedCenter);
		toBeRemovedCenter.setBounds(680, 610, 40, 25);
		toBeRemovedCenter.setModel(new SpinnerNumberModel(0, 0, centers.size(), 1));
		
		menu.add(centerID);
		centerID.setBounds(520, 446, 150, 25);
		menu.add(latitudeCenter);
		latitudeCenter.setBounds(680, 446, 150, 25);
		menu.add(longitudeCenter);
		longitudeCenter.setBounds(840, 446, 150, 25);
		
		menu.add(menuToMap);
		menuToMap.setBounds(880, 675, 95, 35);
		
		map.add(mapToMenu);
		mapToMenu.setBounds(10, 10, 50, 20);
	}
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		//Aca se hacen los if(source == boton) entonces layout.show(panel, "nombreDeOtroPanel")
	}
	
	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
	}
}