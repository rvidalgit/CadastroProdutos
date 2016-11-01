package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import entity.Produto;

public class Listar extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JMenuItem itemRemover, itemInserir, itemEditar, itemPesquisar;
	static Set<Produto> conjunto = new TreeSet<Produto>();
	Container tela;
	
	public Listar() {
		super("Sistema de cadastramento de Produtos - Listar");
		conjunto = Principal.getConjunto();
		tela = getContentPane();
		
		TrataEventos trat = new TrataEventos();
	    BorderLayout layout = new BorderLayout();
	    tela.setLayout(layout); 
	    JMenuBar menuBar = new JMenuBar();

	    itemEditar = new JMenuItem("Editar");
	    itemEditar.addActionListener(trat);
	    menuBar.add(itemEditar);
	    
	    itemRemover = new JMenuItem("Remover");
	    itemRemover.addActionListener(trat);
	    menuBar.add(itemRemover);
	    
	    itemPesquisar = new JMenuItem("Pesquisar");
	    itemPesquisar.addActionListener(trat);
	    menuBar.add(itemPesquisar);
	    
	    JPanel toolbar = new JPanel();
	    toolbar.setLayout(new GridLayout(conjunto.size() + 1, 6)); //numero de linhas = numero de elemento e colunas 6 (variaveis)
	    JLabel codigoL = new JLabel("Codigo");
	    JLabel categoriaL = new JLabel("Categoria");
	    JLabel descricaoL = new JLabel("Descrição");
	    JLabel precoL = new JLabel("Preço");
	    JLabel qtdL = new JLabel("Quantidade");
	    JLabel dataL = new JLabel("Data de Cadastro");
	    
	    toolbar.add(codigoL);
	    toolbar.add(categoriaL);
	    toolbar.add(descricaoL);
	    toolbar.add(precoL);
	    toolbar.add(qtdL);
	    toolbar.add(dataL);
	    
	    for (Produto produto : conjunto) {
		    codigoL = new JLabel(produto.getCodigo().toString());//integer para String
		    categoriaL = new JLabel(produto.getCategoria());
		    descricaoL = new JLabel(produto.getDescricao());
		    precoL = new JLabel(produto.getPreco().toString());//double para String
		    qtdL = new JLabel(String.valueOf(produto.getQtd()));//converter um int para String
		    dataL = new JLabel(produto.getSpf());
	    	
		    toolbar.add(codigoL);
		    toolbar.add(categoriaL);
		    toolbar.add(descricaoL);
		    toolbar.add(precoL);
		    toolbar.add(qtdL);
		    toolbar.add(dataL);
		}
	    
	    tela.add(toolbar,BorderLayout.CENTER);
	    tela.add(menuBar, BorderLayout.NORTH);
	    setSize(1100, 550);
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
			
			if(evento.getSource() == itemRemover){
				Remover remover = new Remover();
				remover.pack();
				System.out.println("Remover pressionado");
			}
			
			if(evento.getSource() == itemPesquisar){
				Pesquisar pesquisar = new Pesquisar();
				pesquisar.pack();
				System.out.println("Pesquisar pressionado");
			}
			
			}  
			
		}
}
