package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import entity.Produto;

public class Dao {

	public void gravar(Set<Produto> conjunto, String nomeArq) {    
        File fArquivo = null;  
        FileWriter fwArquivo = null;  
        BufferedWriter bw = null;  
 
        try {
            fArquivo = new File(nomeArq + ".txt"); 

            fwArquivo = new FileWriter(fArquivo);
            
            bw = new BufferedWriter(fwArquivo);
            
            for (Produto prod:conjunto) {
            	bw.write(prod.toString() + "\n");
            }

            bw.close();
            fwArquivo.close();
        }
        catch (Exception e) {
            System.err.println("Erro ao inserir linhas no arquivo: " + fArquivo);
        }  
    }

    public Set<Produto> lerArquivoTexto(String nomeArq) throws IOException{
        BufferedReader br = null;
        String registro = null;
        File arquivo = null;
        Set<Produto> setProd = new TreeSet<Produto>();
        int qtd, dia, mes, ano;
        Integer id;
        String categoria, descricao;
        Double preco;
        GregorianCalendar dataCadastro;
        try {
            arquivo = new File(nomeArq);
            br = new BufferedReader(new FileReader(arquivo));
            String[] campos;
            while ((registro = br.readLine()) != null) {
                campos = registro.split(","); 
                id = Integer.parseInt(campos[0].trim());
                categoria = campos[1].trim();
                descricao = campos[2].trim();
                preco = Double.parseDouble(campos[3].trim());
                qtd = Integer.parseInt(campos[4].trim());
                dia = Integer.parseInt(campos[5].trim().substring(0,2));
                mes = Integer.parseInt(campos[5].trim().substring(3,5));
                ano = Integer.parseInt(campos[5].trim().substring(6,10));
                dataCadastro = new GregorianCalendar(ano,mes,dia);
                setProd.add(new Produto(id,categoria,descricao,preco,qtd,dataCadastro.getTime()));
            	}
        } 
        catch (FileNotFoundException e) { // tratando quando o arquivo nao existe
            System.err.println("Erro: arquivo não encontrado. " + arquivo);        }
        catch (IOException e) { // tratando quando há erro no readLine()
            System.err.println("Erro: na leitura do arquivo " + arquivo);        }
        finally {
            try {
                if (br != null)
                    br.close();
            }
            catch (IOException e) {}    
        }
        return setProd;
    }  
    
    public static void main(String[] args)throws Exception{
    	Set<Produto> conjunto = new TreeSet<>();
    	
//    	Produto teste = new Produto(123,"Camisa","Camisa Azul Lacoste Tamanho P",120.9,10);
//		Produto teste2 = new Produto(129,"Calça","Calça Fórum 38",150.9,5);
		
		//conjunto.add(new Produto(123,"Camisa","Camisa Azul Lacoste Tamanho P",120.9,10));
		//conjunto.add(new Produto(129,"Calça","Calça Fórum 38",150.9,5));
    	
		Dao dao = new Dao();
		
		//dao.gravar(conjunto, "teste3"); OK
//		try {
//			
//		} catch (Exception e) {
//			System.out.println("Erro: " + e.getMessage());
//		}
		
		conjunto = dao.lerArquivoTexto("teste3.txt");
		
		for (Produto prod : conjunto) {
			System.out.println(prod);
		}
		
	}

}