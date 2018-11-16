package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class AplicacionServidor extends JFrame implements Runnable{

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private ServerSocket server;
	private boolean isRunning;
	private Thread t;
	private Socket cliente;
	private int puerto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionServidor frame = new AplicacionServidor();
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
	public AplicacionServidor() {
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		t = new Thread(this);

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar); //Maneja todo el menu
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile); 
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/open.png"))); //Concatena la cadena a la carpeta source
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/save.png")));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/cancel.png")));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/about.png")));
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
		btnNew.setIcon(new ImageIcon(AplicacionServidor.class.getResource("/img/new.png")));
		
		btnNew.setBorderPainted(false); //Quita el borde
		toolBar.add(btnNew);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c = (CardLayout)panelPrincipal.getLayout();
				//c.next(panelPrincipal);
				c.show(panelPrincipal,"JUEGO"); //Muestra un panel especifico
				try {
					puerto = 9001;
					server = new ServerSocket(puerto);
					isRunning = true;
					t.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		toolBar.add(btnStart);
		
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			try {
				System.out.println("ESPERANDO CLIENTE");
				cliente = server.accept(); //Accept: stop, espera que un cliente llegue 
				System.out.println("CLIENTE CONECTADO...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//1er hilo que escucha
//2do hilo atender cada peticion
	
	
}
