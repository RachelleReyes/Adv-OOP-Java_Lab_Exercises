package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class AplicacionCliente extends JFrame {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private Socket cliente;
	private int puerto = 9001;
	private String host = "127.0.0.1"; //Servidor Local
	//Ventana configuracion: puerto y host configurable

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionCliente frame = new AplicacionCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AplicacionCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar); //Maneja todo el menu
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile); 
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/open.png"))); //Concatena la cadena a la carpeta source
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/save.png")));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/cancel.png")));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/about.png")));
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNew = new JButton("");
		btnNew.setToolTipText("Nuevo");
		btnNew.setIcon(new ImageIcon(AplicacionCliente.class.getResource("/img/new.png")));
		
		btnNew.setBorderPainted(false); //Quita el borde
		toolBar.add(btnNew);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout) panelPrincipal.getLayout();
				//c.next(panelPrincipal);
				c.show(panelPrincipal,"JUEGO"); //Muestra un panel especifico
				try {
					cliente = new Socket(host,puerto);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		toolBar.add(btnConectar);
		
		JButton btnStop = new JButton("Stop");
		toolBar.add(btnStop);
		
		panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		
		PanelPresentacion pnlPresentacion = new PanelPresentacion();
		panelPrincipal.add(pnlPresentacion,"PRESENTACION"); 
		
		PanelJuego pnlJuego = new PanelJuego();
		panelPrincipal.add(pnlJuego,"JUEGO");
		
	}

}
