package interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;

import logic.data.Customer;
import logic.data.DistributionCenter;
import logic.data.ListCustomer;
import logic.data.ListDistributionCenter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Screen extends JFrame {
	private static final long serialVersionUID = 1L;
	
	int width, height;
	
	//Hacer todos los news de aca para abajo
	CardLayout layout = new CardLayout();
	JPanel panel = new JPanel();
	JPanel menu = new JPanel();
	
	JMapViewer map = new JMapViewer();
	Coordinate coordinate = new Coordinate(-34.518164, -58.659785);
	
	ListCustomer customers = new ListCustomer();
	ListDistributionCenter centers = new ListDistributionCenter();
	JMenuBar menuBar = new JMenuBar();
	JMenu menuList = new JMenu("Acciones");
	JMenuItem loadData = new JMenuItem("Cargar datos");
	
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
		menu.add(map);
		map.setBounds(0, 29, 1008, 698);
		map.setDisplayPosition(coordinate, 12);
		map.setZoomControlsVisible(false);
		
		menu.add(menuBar);
		menuBar.setBounds(0, 0, 1018, 30);
		menuBar.add(menuList);
		
		menuList.setMnemonic(KeyEvent.VK_A);
		menuList.add(loadData);
		loadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customers = ListCustomer.readJSON("ListCustomer.JSON");
				centers = ListDistributionCenter.readJSON("ListDistributionCenters.JSON");
				int contador = 1;
				for (Customer customer : customers.getCustomers()) {
					MapMarker center1 = new MapMarkerDot("Cliente " + contador, new Coordinate(customer.getLatitude(), customer.getLongitude()));
					center1.getStyle().setBackColor(Color.blue);
					center1.getStyle().setColor(Color.black);
					map.addMapMarker(center1);
					contador++;
				}
				contador = 1;
				for (DistributionCenter centers : centers.getCenters()) {
					MapMarker center1 = new MapMarkerDot("Local " + contador, new Coordinate(centers.getLatitude(), centers.getLongitude()));
					center1.getStyle().setBackColor(Color.red);
					center1.getStyle().setColor(Color.yellow);
					map.addMapMarker(center1);
					contador++;
					}
			}
		});
	}
		
	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
	}
}