package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Produto;

public class TelaEditar extends JFrame{

	private static final long serialVersionUID = 1L;
	Container tela;
	JTextField codigo, categoria, descricao, preco, qtd, dataCadastro;
	JButton gravar;
	Produto temp;
	public TelaEditar(Produto p) {
		super("Sistema de cadastramento de Produtos - Editar Produto");
		tela = getContentPane();

		TrataEventos trat = new TrataEventos();
	    BorderLayout layout = new BorderLayout();
	    tela.setLayout(layout); 
	    
	    gravar = new JButton("Gravar");
	    gravar.addActionListener(trat);
	    
	    JPanel inserirPanel = new JPanel();
	    inserirPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
	    inserirPanel.add(gravar);
	    
	    JLabel codigoL = new JLabel("Codigo: ");
	    codigo = new JTextField(10);
	    codigo.setText(p.getCodigo().toString());
	    JLabel categoriaL = new JLabel("Categoria: ");
	    categoria = new JTextField(10);
	    categoria.setText(p.getCategoria());
	    JLabel descricaoL = new JLabel("Descrição: ");
	    descricao = new JTextField(30);
	    descricao.setText(p.getDescricao());
	    JLabel precoL = new JLabel("Preço: ");
	    preco = new JTextField(10);
	    preco.setText(p.getPreco().toString());
	    JLabel qtdL = new JLabel("Quatidade: ");
	    qtd = new JTextField(3);
	    qtd.setText(String.valueOf(p.getQtd()));
	    JLabel dataL = new JLabel("Data de Cadastro: ");
	    JLabel dataCadastro = new JLabel(p.getSpf());
	    
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
	    
	    tela.add(toolbar,BorderLayout.CENTER);
	    tela.add(inserirPanel, BorderLayout.SOUTH);
	    setSize(900, 450);
	    setVisible(true);
	    temp = p;
	}
	//public Produto(Integer codigo, String categoria, String descricao, Double preco, int qtd, Date dataCadastro) {
	class TrataEventos implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento){
			Produto prod;
			if(evento.getSource() == gravar){
				prod = new Produto(Integer.parseInt(codigo.getText()),categoria.getText(),
						descricao.getText(),Double.parseDouble(preco.getText().replace(",", ".")),
						Integer.parseInt(qtd.getText()),temp.getDataCadastro());
//				prod.setCategoria(categoria.getText());
//				prod.setCodigo(Integer.parseInt(codigo.getText()));
//				prod.setDescricao(descricao.getText());
//				prod.setPreco(Double.parseDouble(preco.getText().replace(",", ".")));

				Principal.getConjunto().remove(temp);
				Principal.getConjunto().add(prod);
				System.out.println("Editado: " + prod.toString());
				
				prod = new Produto(); //limpa a variavel
				System.out.println("Gravar pressionado");
			}
			
			}  
			
		}

}
