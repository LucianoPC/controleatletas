/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author luciano
 */
public class ControleTenistaDeMesa {
    
    public class Estilo{
        public static final char ortodoxo = 'O';
        public static final char southpaw = 'S';
        public static final char destro = 'O';
        public static final char canhoto = 'S';
    }
    
    public class Categoria{
        public static final char amador = 'A';
        public static final char profissional = 'P';
    }
    
    public static final String nome = "Nome";
    public static final String telefones = "Telefones";
    public static final String dataNascimento = "Data de Nascimento";
    public static final String endereco = "Endereco";
    public static final String altura = "Altura";
    public static final String peso = "Peso";
    public static final String nomePai = "Nome do Pai";
    public static final String nomeMae = "Nome da Mae";
    public static final String sexo = "Sexo";
    public static final String rg = "RG";
    public static final String cpf = "CPF";
    
    public static final String categoria = "Categoria";
    public static final String estilo = "Estilo";
    public static final String premiacoes = "Premiacoes";
    public static final String totalPartidas = "Total de Partidas";
    public static final String totalVitorias = "Total de Vitorias";
    public static final String totalDerrotas = "Total de Derrotas";
    public static final String totalDesistencias = "Total de Desistencias";
    
    
    private ArrayList<TenistaDeMesa> tenistas;
    private List<TenistaDeMesa> safeTenistas;
    
    public ControleTenistaDeMesa(){
        tenistas = new ArrayList<TenistaDeMesa>();
        safeTenistas = Collections.unmodifiableList(tenistas);
    }
    
    public void adicionar(HashMap<String, Object> informacoes_tenistaDeMesa) throws TenistaInvalidoException{
        TenistaDeMesa tenistaDeMesa = instanciarTenistaDeMesa(informacoes_tenistaDeMesa);
        validarSeTenistaDeMesaAindaNaoExiste(tenistaDeMesa);
        tenistas.add(tenistaDeMesa);
        
        ordenarTenistasPorNome();
    }
    
    public void remover(String nome) throws TenistaInvalidoException{
        TenistaDeMesa tenistaDeMesa = pesquisar(nome);
        tenistas.remove(tenistaDeMesa);
    }
    
    public TenistaDeMesa pesquisar(String nome) throws TenistaInvalidoException{
        for(TenistaDeMesa tenista : tenistas){
            if(tenista.getNome().equals(nome))
                return tenista;
        }
        throw new TenistaInvalidoException("Tenista '" + nome + "' não está cadastrado");
    }
    
    public List<TenistaDeMesa> getTenistas(){
        return safeTenistas;
    }
    
    public void ordenarTenistasPorNome(){
        Collections.sort(tenistas);
    }
        
    
    private TenistaDeMesa instanciarTenistaDeMesa(HashMap<String, Object> informacoes_tenistaDeMesa){
        TenistaDeMesa tenistaDeMesa = new TenistaDeMesa((String) informacoes_tenistaDeMesa.get(nome));
        tenistaDeMesa.setTelefones((ArrayList<String>) informacoes_tenistaDeMesa.get(telefones));
        tenistaDeMesa.setDataNascimento((Date)informacoes_tenistaDeMesa.get(dataNascimento));
        tenistaDeMesa.setEndereco((Endereco) informacoes_tenistaDeMesa.get(endereco));
        tenistaDeMesa.setAltura((Double) informacoes_tenistaDeMesa.get(altura));
        tenistaDeMesa.setPeso((Double) informacoes_tenistaDeMesa.get(peso));
        tenistaDeMesa.setNomePai((String) informacoes_tenistaDeMesa.get(nomePai));
        tenistaDeMesa.setNomeMae((String) informacoes_tenistaDeMesa.get(nomeMae));
        tenistaDeMesa.setSexo((Character) informacoes_tenistaDeMesa.get(sexo));
        tenistaDeMesa.setRg((String) informacoes_tenistaDeMesa.get(rg));
        tenistaDeMesa.setCpf((String) informacoes_tenistaDeMesa.get(cpf));
        
        tenistaDeMesa.setCategoria((Character) informacoes_tenistaDeMesa.get(categoria));
        tenistaDeMesa.setEstilo((Character) informacoes_tenistaDeMesa.get(estilo));
        tenistaDeMesa.setPremiacoes((ArrayList<Premiacao>) informacoes_tenistaDeMesa.get(premiacoes));
        tenistaDeMesa.setTotalPartidas((Integer) informacoes_tenistaDeMesa.get(totalPartidas));
        tenistaDeMesa.setTotalVitorias((Integer) informacoes_tenistaDeMesa.get(totalVitorias));
        tenistaDeMesa.setTotalDerrotas((Integer) informacoes_tenistaDeMesa.get(totalDerrotas));
        tenistaDeMesa.setTotalDesistencias((Integer) informacoes_tenistaDeMesa.get(totalDesistencias));
        
        return tenistaDeMesa;
    }
    
    private void validarSeTenistaDeMesaAindaNaoExiste(TenistaDeMesa tenistaDeMesa) throws TenistaInvalidoException{
        for(TenistaDeMesa tenista : tenistas){
            if(tenista.getNome().equals(tenistaDeMesa.getNome()))
                throw new TenistaInvalidoException("O Tenista de Mesa '" + tenistaDeMesa.getNome() + "' já está cadastrado");
        }
    }
        
}
