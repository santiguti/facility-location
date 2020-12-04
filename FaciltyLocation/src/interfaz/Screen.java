package interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	int width, height;
	
	//Hacer todos los news de aca para abajo
	CardLayout layout = new CardLayout();
	JPanel panel = new JPanel();
	JPanel menu = new JPanel();
	
	public Screen(int width, int height) {
		panel.setLayout(layout);
		addButtons();
		
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Tienda Planner");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		requestFocus();
	}
	
	private void addButtons() {
		//Setteo layouts a null, les agrego background, hago los adds de los botones a los correspondientes layouts
		menu.setLayout(null);
		menu.setBackground(Color.GRAY);
		panel.add(menu, "Menu");
		
		getContentPane().add(panel);
		layout.show(panel, "Menu");
	}
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		//Aca se hacen los if(source == boton) entonces layout.show(panel, "nombreDeOtroPanel")
	}
	
	public static void main(String[] args) {
		Screen s = new Screen(800, 600);
	}
}