package br.estacio.progII.ex01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex01Frame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel painelTopo;
	
	private JPanel painelCentro;
	
	private JLabel labelTabuadoDo;
	
	private JLabel labelDe;
	
	private JLabel labelAte;
	
	private JButton buttonCalcular;
	
	private JTextField textFieldDe;
	
	private JTextField textFieldAte;
	
	private JTextField textFieldTabuadaDo;
	
	
	public Ex01Frame() {
		instanciarElementos();
		
		configurarFrame();
		
		definirEventos();
		
	
		
		montarFrame();
		
		
	}

	/**
	 * Definindo os eventos dos Frames.
	 */
	private void definirEventos() {
		
		buttonCalcular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				
				try {
					 
					if(textFieldTabuadaDo.getText().length() < 1) {
						
						JOptionPane.showMessageDialog(null, "Por favor preencher o campo Tabuada do:");
						return;
					}
					
				} catch (NullPointerException ex) {

					JOptionPane.showMessageDialog(null, "Por favor preencher o campo Tabuada do:");
					return;
				}
				
				try {
					 
					if(textFieldDe.getText().length() < 1) {
						
						JOptionPane.showMessageDialog(null, "Por favor preencher o campo De:");
						return;
					}
					
				} catch (NullPointerException ex) {

					JOptionPane.showMessageDialog(null, "Por favor preencher o campo De:");
					return;
				}
				
				try {
					 
					if(textFieldAte.getText().length() < 1) {
						
						JOptionPane.showMessageDialog(null, "Por favor preencher o campo Até:");
						return;
					}
					
				} catch (NullPointerException ex) {

					JOptionPane.showMessageDialog(null, "Por favor preencher o campo Até:");
					return;
				}
				
				try {

					Integer.valueOf(textFieldTabuadaDo.getText());
					
				} catch (NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(null, "Por favor preencher o campo Tabuada do: com valor numerico.");
					
					return;
				}
				
				try {

					Integer.valueOf(textFieldDe.getText());
					
				} catch (NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(null, "Por favor preencher o campo De: com valor numerico.");
					
					return;
				}
				
				try {

					Integer.valueOf(textFieldAte.getText());
					
				} catch (NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(null, "Por favor preencher o campo Até: com valor numerico.");
					
					return;
				}
				
				if(Integer.valueOf(textFieldAte.getText()) < Integer.valueOf(textFieldDe.getText())) {
					
					JOptionPane.showMessageDialog(null, "O valor do campo De não poderá ser maior que o Até");
				
					return;
				}

				
				
				Ex01Class classe = new Ex01Class();
				
				List<String> retornaListagemDaTabuada = classe.alimentaListagem(textFieldTabuadaDo.getText(), textFieldDe.getText(), textFieldAte.getText());


				painelCentro.removeAll();
				
				painelCentro.repaint();
				
				for(int index = 0; index < retornaListagemDaTabuada.size(); index++) {
					
					JLabel labelNovo = new JLabel();
					
					labelNovo.setText(retornaListagemDaTabuada.get(index));
					
					painelCentro.add(labelNovo);
					
				}
				
				painelCentro.revalidate();
				
			}
		});
		
	}

	/**
	 * Configurando o Frame
	 */
	private void configurarFrame() {
		
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("                                                                                        Tabuada");
		this.setLayout(new BorderLayout(5,5));
		
		this.getContentPane().add(painelTopo, BorderLayout.PAGE_START);
		
		this.getContentPane().add(painelCentro, BorderLayout.CENTER);
		
	}
	
	/**
	 * Instanciando os Elementos
	 */
	private void instanciarElementos()  {
		
		painelTopo = new JPanel(new FlowLayout());
		
		painelTopo.setBackground(Color.LIGHT_GRAY);
		
		labelDe = new JLabel("De: ");
		
		labelAte = new JLabel("Até: ");
		
		labelTabuadoDo = new JLabel("Tabuada do: ");
		
		textFieldDe = new JTextField(10);
		
		textFieldAte = new JTextField(10);
		
		textFieldTabuadaDo = new JTextField(10);
		
		buttonCalcular = new JButton("Calcular");

		
		painelCentro = new JPanel(new FlowLayout());
		
		
	}
	
	/**
	 * Adicionando os elementos nos Paineis
	 */
	private void montarFrame() {
		
		painelTopo.add(labelTabuadoDo);
		
		painelTopo.add(textFieldTabuadaDo);
		
		painelTopo.add(labelDe);
		
		painelTopo.add(textFieldDe);
		
		painelTopo.add(labelAte);
		
		painelTopo.add(textFieldAte);
		
		painelTopo.add(buttonCalcular);
		
	}
	
}
