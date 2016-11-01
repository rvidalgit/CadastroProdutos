package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
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

public class Pesquisar extends JFrame{

	private static final long serialVersionUID = 1L;
	JMenuItem itemRemover, itemInserir, itemEditar, itemListar;
	static Set<Produto> conjunto = new TreeSet<Produto>();
	Container tela;
	Set<Produto> resultado;
	JButton pesquisar;
	JTextField categoria;
	public Pesquisar() {
		super("Sistema de cadastramento de Produtos - Pesquisar");
		conjunto = Principal.getConjunto();
		tela = getContentPane();
		resultado = new TreeSet<Produto>();
		
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
	    
	    JPanel toolbar = new JPanel();
	    toolbar.setLayout(new FlowLayout());
	    
	    JLabel categoriaL = new JLabel("Categoria: ");
	    categoria = new JTextField(15);
	    
	    pesquisar = new JButton("Pesquisar");
	    pesquisar.addActionListener(trat);
	    
	    toolbar.add(categoriaL);
	    toolbar.add(categoria);
	    toolbar.add(pesquisar);
	    
	    tela.add(menuBar, BorderLayout.NORTH);
	    tela.add(toolbar,BorderLayout.CENTER);
	    setSize(900, 450);
	    setVisible(true);  
	}
	
	public static void main(String[] args) {
		Pesquisar pesq = new Pesquisar();
		pesq.pack();
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
			
			if(evento.getSource() == itemRemover){
				Remover remover = new Remover();
				remover.pack();
				System.out.println("Remover pressionado");
			}
			
			if(evento.getSource() == itemListar){
				Listar listar = new Listar();
				listar.pack();
				System.out.println("Listar pressionado");
			}
			
			if(evento.getSource() == pesquisar){
				System.out.println("Pesquisar pressionado - Buscar: " + categoria.getText().toLowerCase());
				for (Produto produto : conjunto) {
					if (produto.getCategoria().toLowerCase().intern()==categoria.getText().toLowerCase().intern()) {
						resultado.add(produto);
					}
				}
				
				for (Produto produto : resultado) {
					System.out.println(produto);
				}
				ResultadoBusca rb = new ResultadoBusca(resultado);
				rb.pack();
			}
			
			}  
			
		}
	
}
