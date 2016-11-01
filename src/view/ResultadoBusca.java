package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

import entity.Produto;

public class ResultadoBusca extends JFrame{

	private static final long serialVersionUID = 1L;
	Container tela;
	public ResultadoBusca(Set<Produto> resultado) {
		super("Sistema de cadastramento de Produtos - Resultado da busca/categoria");
		tela = getContentPane();
		
	    GridLayout layout = new GridLayout(resultado.size() + 1,6);
	    tela.setLayout(layout); 
	    
	    JLabel codigoL = new JLabel("Codigo");
	    JLabel categoriaL = new JLabel("Categoria");
	    JLabel descricaoL = new JLabel("Descrição");
	    JLabel precoL = new JLabel("Preço");
	    JLabel qtdL = new JLabel("Quantidade");
	    JLabel dataL = new JLabel("Data de Cadastro");
	    
	    tela.add(codigoL);
	    tela.add(categoriaL);
	    tela.add(descricaoL);
	    tela.add(precoL);
	    tela.add(qtdL);
	    tela.add(dataL);
	    
	    for (Produto produto : resultado) {
		    codigoL = new JLabel(produto.getCodigo().toString());//integer para String
		    categoriaL = new JLabel(produto.getCategoria());
		    descricaoL = new JLabel(produto.getDescricao());
		    precoL = new JLabel(produto.getPreco().toString());//double para String
		    qtdL = new JLabel(String.valueOf(produto.getQtd()));//converter um int para String
		    dataL = new JLabel(produto.getSpf());
	    	
		    tela.add(codigoL);
		    tela.add(categoriaL);
		    tela.add(descricaoL);
		    tela.add(precoL);
		    tela.add(qtdL);
		    tela.add(dataL);
		}
	    
	    setSize(1100, 550);
	    setVisible(true);  
	}
}
