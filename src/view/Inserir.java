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

public class Inserir extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static Set<Produto> conjunto = new TreeSet<Produto>();
	Produto p;
	Container tela;
	JTextField codigo, categoria, descricao, preco, qtd, dataCadastro;
	JMenuItem itemRemover, itemEditar, itemListar, itemPesquisar;
	JButton inserir;
	public Inserir() {
		super("Sistema de cadastramento de Produtos - Inserir");
		conjunto = Principal.getConjunto();
		tela = getContentPane();
		p = new Produto();
		
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
	    
	    itemListar = new JMenuItem("Listar");
	    itemListar.addActionListener(trat);
	    menuBar.add(itemListar);
	    
	    itemPesquisar = new JMenuItem("Pesquisar");
	    itemPesquisar.addActionListener(trat);
	    menuBar.add(itemPesquisar);
		
	    JLabel codigoL = new JLabel("Codigo: ");
	    codigo = new JTextField(10);
	    JLabel categoriaL = new JLabel("Categoria: ");
	    categoria = new JTextField(10);
	    JLabel descricaoL = new JLabel("Descrição: ");
	    descricao = new JTextField(30);
	    JLabel precoL = new JLabel("Preço: ");
	    preco = new JTextField(10);
	    JLabel qtdL = new JLabel("Quatidade: ");
	    qtd = new JTextField(3);
	    JLabel dataL = new JLabel("Data de Cadastro: ");
	    JLabel dataCadastro = new JLabel(p.getSpf());
//	    dataCadastro = new JTextField(10);
//	    dataCadastro.setText(p.getSpf());
	    
	    inserir = new JButton("Inserir");
	    inserir.addActionListener(trat);
	    
	    JPanel toolbar = new JPanel();
	    toolbar.setLayout(new GridLayout(6, 2));
	    toolbar.add(codigoL);
	    toolbar.add(codigo);
	    toolbar.add(categoriaL);
	    toolbar.add(categoria);
	    toolbar.add(descricaoL);
	    toolbar.add(descricao);
	    toolbar.add(precoL);
	    toolbar.add(preco);
	    toolbar.add(qtdL);
	    toolbar.add(qtd);
	    toolbar.add(dataL);
	    toolbar.add(dataCadastro);
	    
	    JPanel inserirPanel = new JPanel();
	    inserirPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	    inserirPanel.add(inserir);
	    tela.add(toolbar,BorderLayout.CENTER);
	    tela.add(menuBar, BorderLayout.NORTH);
	    tela.add(inserirPanel, BorderLayout.SOUTH);
	    setSize(900, 450);
	    setVisible(true);  
	}
	
	public static void main(String[] args) {

		Inserir inserir = new Inserir();
		inserir.pack();
	}
	
	class TrataEventos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento){
			
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
			
			if(evento.getSource() == itemPesquisar){
				Pesquisar pesquisar = new Pesquisar();
				pesquisar.pack();
				System.out.println("Pesquisar pressionado");
			}
			
			if(evento.getSource() == inserir){
				p.setCategoria(categoria.getText());
				p.setCodigo(Integer.parseInt(codigo.getText()));
				p.setDescricao(descricao.getText());
				p.setQtd(Integer.parseInt(qtd.getText()));
				p.setPreco(Double.parseDouble(preco.getText().replace(",", ".")));
				Principal.getConjunto().add(p);
				System.out.println("Inserido: " + p.toString());
				System.out.println("-----------------");
				
				for (Produto produto : conjunto) {
					System.out.println(produto);
				}
				
				p = new Produto(); //limpa a variavel
				
			}
			
			}  
			
		}

}
