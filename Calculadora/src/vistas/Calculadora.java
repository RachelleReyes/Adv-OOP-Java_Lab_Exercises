package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ControlBoton;

public class Calculadora extends JFrame implements Interfaz{

	private JPanel contentPane;
	private JTextField txtOperador1;
	private JTextField txtOperador2;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnSuma = new JButton("Suma");
		/*
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double operador1 = Double.parseDouble(txtOperador1.getText());
				double operador2 = Double.parseDouble(txtOperador2.getText());
				double resultado = operador1 + operador2;
				txtResultado.setText(String.valueOf(resultado));
			
			}
		}); */
		
		panelBotones.add(btnSuma);
		
		JButton btnResta = new JButton("Resta");
		/*
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double operador1 = Double.parseDouble(txtOperador1.getText());
				double operador2 = Double.parseDouble(txtOperador2.getText());
				double resultado = operador1 - operador2;
				txtResultado.setText(String.valueOf(resultado));
			}
		});*/
		panelBotones.add(btnResta);
		
		JButton btnMultiplicar = new JButton("Multiplicar");
		/*
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double operador1 = Double.parseDouble(txtOperador1.getText());
				double operador2 = Double.parseDouble(txtOperador2.getText());
				double resultado = operador1 * operador2;
				txtResultado.setText(String.valueOf(resultado));
				
			}
		});*/
		panelBotones.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("Dividir");
		/*
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double operador1 = Double.parseDouble(txtOperador1.getText());
				double operador2 = Double.parseDouble(txtOperador2.getText());
				double resultado = operador1 / operador2;
				txtResultado.setText(String.valueOf(resultado));
			}
		});*/
		panelBotones.add(btnDividir);
		
		JPanel panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		
		JLabel lblOperador = new JLabel("Operador 1:");
		panelDatos.add(lblOperador);
		
		txtOperador1 = new JTextField();
		txtOperador1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtOperador1.setForeground(Color.BLUE);
		txtOperador1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelDatos.add(txtOperador1);
		txtOperador1.setColumns(10);
		
		JLabel lblOperador_1 = new JLabel("Operador 2: ");
		panelDatos.add(lblOperador_1);
		
		txtOperador2 = new JTextField();
		txtOperador2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtOperador2.setForeground(Color.BLUE);
		txtOperador2.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelDatos.add(txtOperador2);
		txtOperador2.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado: ");
		panelDatos.add(lblResultado);
		
		txtResultado = new JTextField();
		txtResultado.setEditable(false);
		txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResultado.setForeground(Color.RED);
		txtResultado.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelDatos.add(txtResultado);
		txtResultado.setColumns(10);
		
		btnSuma.setActionCommand("Sumar");
		btnResta.setActionCommand("Resta");
		btnMultiplicar.setActionCommand("Multiplicar");
		btnDividir.setActionCommand("Dividir");
		
		ControlBoton control = new ControlBoton(this);
		btnSuma.addActionListener(control);
		btnResta.addActionListener(control);
		btnMultiplicar.addActionListener(control);
		btnDividir.addActionListener(control);
	
	}

	@Override
	public double getOperador1() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtOperador1.getText());
	}

	@Override
	public double getOperador2() {
		// TODO Auto-generated method stub
		return Double.parseDouble(txtOperador2.getText());
	}

	@Override
	public void setResultado(double res) {
		// TODO Auto-generated method stub
		txtResultado.setText(String.valueOf(res));
	}

}
