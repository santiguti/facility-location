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
		
		getContentPane().add(panel);
		layout.show(panel, "Menu");
		
		//Luego agrego labels, buttons, list a los diferentes layouts y les setteo font, posicion, etc
		menu.add(clientsList);
		clientsList.setBounds(10, 20, 500, 260);
		clientModel.setValueAt("Latitude", 0, 0);
		clientModel.setValueAt("Longitude", 0, 1);
		
		menu.add(addClient);
		addClient.setBounds(520, 25, 150, 25);
		menu.add(removeClient);
		removeClient.setBounds(520, 75, 150, 25);
		menu.add(toBeRemovedClient);
		toBeRemovedClient.setBounds(680, 75, 40, 25);
		toBeRemovedClient.setModel(new SpinnerNumberModel(1, 1, clients.size(), 1));
		
		menu.add(centersList);
		centersList.setBounds(10, 380, 500, 260);
		centersModel.setValueAt("Center ID", 0, 0);
		centersModel.setValueAt("Latitude", 0, 1);
		centersModel.setValueAt("Longitude", 0, 2);
	}
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		//Aca se hacen los if(source == boton) entonces layout.show(panel, "nombreDeOtroPanel")
	}
	
	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
	}
}