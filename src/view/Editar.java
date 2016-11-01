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

public class Editar extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	Container tela;
	JMenuItem itemInserir, itemEditar, itemListar, itemPesquisar;
	static Set<Produto> conjunto = new TreeSet<Produto>();
	JButton editarB;
	JTextField codigo;

	public Editar() {
		super("Sistema de cadastramento de Produtos - Editar");
		tela = getContentPane();
		conjunto = Principal.getConjunto();
		
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
	    
	    
	    JPanel toolbar = new JPanel();
	    toolbar.setLayout(new FlowLayout());
	    
	    JLabel editarL = new JLabel("Digite o código do item a ser editado: ");
	    codigo = new JTextField(10);
	    
	    editarB = new JButton("Editar");
	    editarB.addActionListener(trat);
	    
	    toolbar.add(editarL);
	    toolbar.add(codigo);
	    toolbar.add(editarB);
	    
	    tela.add(menuBar, BorderLayout.NORTH);
	    tela.add(toolbar,BorderLayout.CENTER);
	    setSize(900, 450);
	    setVisible(true);  
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
			
			if(evento.getSource() == editarB){
				
				for (Produto produto : conjunto) {
					if(produto.getCodigo()==Integer.parseInt(codigo.getText())){
						TelaEditar td = new TelaEditar(produto);
						td.pack();
						break;
					}
				}
				System.out.println("Editar pressionado");
			}
			
			}  
			
		}
	
}
