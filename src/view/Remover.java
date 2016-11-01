package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Produto;

public class Remover extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JMenuItem itemInserir, itemEditar, itemListar, itemPesquisar;
	static Set<Produto> conjunto = new TreeSet<Produto>();
	JButton remover;
	Container tela;
	JTextField codigo;
	
	public Remover() {
		super("Sistema de cadastramento de Produtos - Remover");
		conjunto = Principal.getConjunto();
		tela = getContentPane();
		
		TrataEventos trat = new TrataEventos();
	    BorderLayout layout = new BorderLayout();
	    tela.setLayout(layout); 
	    JMenuBar menuBar = new JMenuBar();
	   
	    itemInserir = new JMenuItem("Inserir");
	    itemInserir.addActionListener(trat);
	    menuBar.add(itemInserir);

	    itemEditar = new JMenuItem("Editar");
	    itemEditar.addActionListener(trat);
	    menuBar.add(itemEditar);
	    
	    itemListar = new JMenuItem("Listar");
	    itemListar.addActionListener(trat);
	    menuBar.add(itemListar);
	    
	    itemPesquisar = new JMenuItem("Pesquisar");
	    itemPesquisar.addActionListener(trat);
	    menuBar.add(itemPesquisar);
	    
	    JLabel codigoL = new JLabel("Digite o Código do produto da ser removido: ");
	    codigo = new JTextField(10);
	    
	    remover = new JButton("Remover");
	    remover.addActionListener(trat);
	    
	    JPanel toolbar = new JPanel();
	    toolbar.setLayout(new GridLayout(6, 2));
	    toolbar.add(codigoL);
	    toolbar.add(codigo);
	    JPanel inserirPanel = new JPanel();
	    inserirPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	    inserirPanel.add(remover);
	    tela.add(toolbar,BorderLayout.CENTER);
	    tela.add(menuBar, BorderLayout.NORTH);
	    tela.add(inserirPanel, BorderLayout.SOUTH);
	    setSize(900, 450);
	    setVisible(true);
	}
	
	public static void main(String[] args) {
		Remover remover = new Remover();
		remover.pack();
	}



	class TrataEventos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento){
			
			if(evento.getSource() == itemInserir){
				Inserir inserir = new Inserir();
				inserir.pack();
				System.out.println("Inserir pressionado");
			}
			
			if(evento.getSource() == itemEditar){
				Editar editar = new Editar();
				editar.pack();
				System.out.println("Editar pressionado");
			}
			
			if(evento.getSource() == itemListar){
				Listar listar = new Listar();
				listar.pack();
				System.out.println("Listar pressionado");
			}
			
			if(evento.getSource() == itemPesquisar){
				Pesquisar pesquisar = new Pesquisar();
				pesquisar.pack();
				System.out.println("Pesquisar pressionado");
			}
			
			if(evento.getSource() == remover){
				System.out.println("Remover pressionado");
				for (Produto produto : conjunto) {
					if(produto.getCodigo()==Integer.parseInt(codigo.getText())){
						Principal.getConjunto().remove(produto);
						System.out.println("Removido: " + produto);
						break;
					}
				}
				for (Produto produto : conjunto) {
					System.out.println(produto);
				}
			}
			
			}  
			
		}

}
