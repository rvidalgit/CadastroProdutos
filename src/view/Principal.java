package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import persistence.Dao;

public class Principal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	Dao dao;
	private static Set<Produto> conjunto;
	Container tela;
	JTextField texto;
	JButton carrega, salva;
	JMenuItem itemRemover, itemInserir, itemEditar, itemListar, itemPesquisar;
	public Principal() {
		super("Sistema de cadastramento de Produtos - HOME");
		conjunto = new TreeSet<Produto>();
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
	    
	    itemRemover = new JMenuItem("Remover");
	    itemRemover.addActionListener(trat);
	    menuBar.add(itemRemover);
	    
	    itemListar = new JMenuItem("Listar");
	    itemListar.addActionListener(trat);
	    menuBar.add(itemListar);
	    
	    itemPesquisar = new JMenuItem("Pesquisar");
	    itemPesquisar.addActionListener(trat);
	    menuBar.add(itemPesquisar);
	    
	    JLabel rotulo = new JLabel("Nome do arquivo: ");
	    texto = new JTextField(10);
	    carrega = new JButton("Carregar");
	    carrega.addActionListener(trat);
	    salva = new JButton("Salvar");
	    salva.addActionListener(trat);
	    JPanel toolbar = new JPanel();
	    toolbar.setLayout(new FlowLayout());

	    toolbar.add(rotulo);
	    toolbar.add(texto);
	    toolbar.add(carrega);
	    toolbar.add(salva);
	    
	    tela.add(menuBar, BorderLayout.NORTH);
	    tela.add(toolbar,BorderLayout.CENTER);
	    setSize(900, 450);
	    setVisible(true);  
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.pack(); //ajusta a tela
	}
	
	class TrataEventos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento){
			if(evento.getSource() == carrega){
				System.out.println("Carregar pressionado");
				dao = new Dao();
		  	    try {
					Principal.conjunto = dao.lerArquivoTexto(texto.getText());
					
					for (Produto produto : conjunto) {
						System.out.println(produto);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}}
			
			if(evento.getSource() == salva){
				dao = new Dao();
				dao.gravar(conjunto, texto.getText());
				System.out.println("Salvar pressionado");
			}
			
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
			
			if(evento.getSource() == itemRemover){
				Remover remover = new Remover();
				remover.pack();
				System.out.println("Remover pressionado");
			}
			
			if(evento.getSource() == itemListar){
				Listar listar = new Listar();
				System.out.println("Listar pressionado");
			}
			
			if(evento.getSource() == itemPesquisar){
				Pesquisar pesquisar = new Pesquisar();
				pesquisar.pack();
				System.out.println("Pesquisar pressionado");
			}
			
			}  
			
		}

	public static Set<Produto> getConjunto() {
		return conjunto;
	}

	public static void setConjunto(Set<Produto> conjunto) {
		Principal.conjunto = conjunto;
	}
	
}