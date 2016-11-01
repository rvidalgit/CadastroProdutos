package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Produto implements Comparable<Produto>{
	
	private Integer codigo;
	private String categoria;
	private String descricao;
	private Double preco=0.;
	private int qtd=0; //quantidade em estoque
	

	private Date dataCadastro;
	
	private String spf;
	
	public Produto() {
		//data em que o produto foi cadastrado no sistema, por segurança já vem preenchida
		this.dataCadastro = new GregorianCalendar().getTime();
		spf = new SimpleDateFormat("dd/MM/yyyy").format(dataCadastro);
	}
	
	//quando é cadastrado no sismte a data é automatica
	public Produto(Integer codigo, String categoria, String descricao, Double preco, int qtd) {
		this();
		this.codigo = codigo;
		this.categoria = categoria;
		this.descricao = descricao;
		this.preco = preco;
		this.qtd = qtd;
	}
	//quando vem do arquivo a data é inserida
	public Produto(Integer codigo, String categoria, String descricao, Double preco, int qtd, Date dataCadastro) {
		this.codigo = codigo;
		this.categoria = categoria;
		this.descricao = descricao;
		this.preco = preco;
		this.qtd = qtd;
		this.dataCadastro = dataCadastro;
		this.spf = new SimpleDateFormat("dd/MM/yyyy").format(dataCadastro);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	// get data formatada
	public String getSpf() {
		return spf;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	@Override
	public String toString() {
		return codigo + "," + categoria + "," + descricao + "," + preco
				+ "," + qtd + "," + spf;
	}

//	@Override
//	public int compareTo(Produto o) {
//		return this.descricao.compareTo(o.descricao);
//	}
	
	@Override
	public int compareTo(Produto o) {
		return this.codigo.compareTo(o.codigo);
	}

}
