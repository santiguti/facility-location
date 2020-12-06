package interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.data.Customer;
import logic.data.DistributionCenter;
import logic.data.ListCustomer;
import logic.data.ListDistributionCenter;

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
	
	public Screen(int width, int height) {
		panel.setLayout(layout);
		addButtons();
		
		setSize(800, 600);
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
		clientsList.setBounds(10, 20, 245, 445);
		clientModel.setValueAt("Latitude", 0, 0);
		clientModel.setValueAt("Longitude", 0, 1);
		
		menu.add(centersList);
		centersList.setBounds(539, 20, 245, 445);
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