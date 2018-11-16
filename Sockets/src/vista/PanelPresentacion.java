package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PanelPresentacion extends JPanel{
	public PanelPresentacion() {
		setBackground(new Color(95, 158, 160));
		setLayout(new BorderLayout(0, 0));
		
		String mensaje = "<html> <center> <h3> Universidad Autonoma <br><hr> de Baja California </center> </html> ";
		
		
		JLabel lblNewLabel = new JLabel(mensaje);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon(PanelPresentacion.class.getResource("/img/uabc.png")));
		add(lblNewLabel, BorderLayout.CENTER);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

	}
	
}
