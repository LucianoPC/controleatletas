/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author luciano
 */
public class ControleTenistaDeMesa {
    
    public class Sexo{
        public static final char masculino = 'M';
        public static final char feminino = 'F';
    }
    
    public class Categoria{
        public static final char amador = 'A';
        public static final char profissional = 'p';
    }
    
    public class Estilo{
        public static final char ortodoxo = 'O';
        public static final char southpaw = 'S';
        public static final char destro = 'O';
        public static final char canhoto = 'S';
    }
    
    public class TenistaEndereco{
        public static final String logradouro = "Logradouro";
        public static final String numero = "Numero";
        public static final String complemento = "Complemento";
        public static final String bairro = "Bairro";
        public static final String cidade = "Cidade";
        public static final String estado = "Estado";
        public static final String pais = "Pais";
        public static final String cep = "CEP";        
    }
    
    public class Tenista{
        public static final String nome = "Nome";
        public static final String telefones = "Telefones";
        public static final String dataNascimento = "Data de Nascimento";
        public static final String altura = "Altura";
        public static final String peso = "Peso";
        public static final String nomePai = "Nome do Pai";
        public static final String nomeMae = "Nome da Mae";
        public static final String sexo = "Sexo";
        public static final String rg = "RG";
        public static final String cpf = "CPF";
        
        public static final String endereco = "Endereco";

        public static final String categoria = "Categoria";
        public static final String estilo = "Estilo";
        public static final String premiacoes = "Premiacoes";
        public static final String totalPartidas = "Total de Partidas";
        public static final String totalVitorias = "Total de Vitorias";
        public static final String totalDerrotas = "Total de Derrotas";
        public static final String totalDesistencias = "Total de Desistencias";
    }
    
    public static final int numero_caracteres_rg = 7;
    public static final int numero_caracteres_cpf = 11;
    public static final int numero_caracteres_cep = 8;
    
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
        
    
    private TenistaDeMesa instanciarTenistaDeMesa(HashMap<String, Object> informacoes_tenistaDeMesa) throws TenistaInvalidoException{
        TenistaDeMesa tenistaDeMesa = new TenistaDeMesa(null);
        
        atribuirValoresTenistaDeMesaInformacoesGerais(tenistaDeMesa, informacoes_tenistaDeMesa);
        atribuirValoresTenistaDeMesaEndereco(tenistaDeMesa, informacoes_tenistaDeMesa);
        atribuirValoresTenistaDeMesaFichaTecnica(tenistaDeMesa, informacoes_tenistaDeMesa);
        
        return tenistaDeMesa;
    }
    
    private void atribuirValoresTenistaDeMesaInformacoesGerais(TenistaDeMesa tenistaDeMesa, HashMap<String, Object> informacoes_tenistaDeMesa) throws TenistaInvalidoException{
        tenistaDeMesa.setNome(Validacao.validarNome(informacoes_tenistaDeMesa.get(Tenista.nome), Tenista.nome));
        tenistaDeMesa.setDataNascimento(Validacao.validarData(informacoes_tenistaDeMesa.get(Tenista.dataNascimento), Tenista.dataNascimento));
        tenistaDeMesa.setAltura(Validacao.validarDouble(informacoes_tenistaDeMesa.get(Tenista.altura), Tenista.altura));
        tenistaDeMesa.setPeso(Validacao.validarDouble(informacoes_tenistaDeMesa.get(Tenista.peso), Tenista.peso));
        
        String caracteres_validos_sexo = "" + ControleTenistaDeMesa.Sexo.masculino + ControleTenistaDeMesa.Sexo.feminino;
        tenistaDeMesa.setSexo(Validacao.validarCaractere(informacoes_tenistaDeMesa.get(Tenista.sexo), caracteres_validos_sexo, Tenista.sexo));
        
        tenistaDeMesa.setNomePai(Validacao.validarNome(informacoes_tenistaDeMesa.get(Tenista.nomePai), Tenista.nomePai));
        tenistaDeMesa.setNomeMae(Validacao.validarNome(informacoes_tenistaDeMesa.get(Tenista.nomeMae), Tenista.nomeMae));
        
        tenistaDeMesa.setRg(Validacao.validarStringDeInteiroComNumeroDeCaracteresFixo(informacoes_tenistaDeMesa.get(Tenista.rg), numero_caracteres_rg, Tenista.rg));
        tenistaDeMesa.setCpf(Validacao.validarStringDeInteiroComNumeroDeCaracteresFixo(informacoes_tenistaDeMesa.get(Tenista.cpf), numero_caracteres_cpf, Tenista.cpf));
        tenistaDeMesa.setTelefones((ArrayList<String>) informacoes_tenistaDeMesa.get(Tenista.telefones));
    }
    
    private void atribuirValoresTenistaDeMesaEndereco(TenistaDeMesa tenistaDeMesa, HashMap<String, Object> informacoes_tenistaDeMesa) throws TenistaInvalidoException{
        Endereco endereco = new Endereco();
        
        endereco.setLogradouro(Validacao.validarStringNaoNula(informacoes_tenistaDeMesa.get(TenistaEndereco.logradouro), TenistaEndereco.logradouro));
        endereco.setNumero(Validacao.validarStringDeInteiro(informacoes_tenistaDeMesa.get(TenistaEndereco.numero), TenistaEndereco.numero));
        endereco.setComplemento(Validacao.validarStringNaoNula(informacoes_tenistaDeMesa.get(TenistaEndereco.complemento), TenistaEndereco.complemento));
        endereco.setBairro(Validacao.validarStringNaoNula(informacoes_tenistaDeMesa.get(TenistaEndereco.bairro), TenistaEndereco.bairro));
        endereco.setCidade(Validacao.validarStringNaoNula(informacoes_tenistaDeMesa.get(TenistaEndereco.cidade), TenistaEndereco.cidade));
        endereco.setEstado(Validacao.validarStringNaoNula(informacoes_tenistaDeMesa.get(TenistaEndereco.estado), TenistaEndereco.estado));
        endereco.setPais(Validacao.validarStringNaoNula(informacoes_tenistaDeMesa.get(TenistaEndereco.pais), TenistaEndereco.pais));
        endereco.setCep(Validacao.validarStringDeInteiroComNumeroDeCaracteresFixo(informacoes_tenistaDeMesa.get(TenistaEndereco.cep), numero_caracteres_cep, TenistaEndereco.complemento));
        
        tenistaDeMesa.setEndereco(endereco);
    }
    
    private void atribuirValoresTenistaDeMesaFichaTecnica(TenistaDeMesa tenistaDeMesa, HashMap<String, Object> informacoes_tenistaDeMesa) throws TenistaInvalidoException{
        String caracteres_validos_categoria = "" + ControleTenistaDeMesa.Categoria.amador + ControleTenistaDeMesa.Categoria.profissional;
        tenistaDeMesa.setCategoria(Validacao.validarCaractere(informacoes_tenistaDeMesa.get(Tenista.categoria), caracteres_validos_categoria, Tenista.categoria));
        
        String caracteres_validos_estilo = "" + ControleTenistaDeMesa.Estilo.ortodoxo + ControleTenistaDeMesa.Estilo.southpaw;
        tenistaDeMesa.setEstilo(Validacao.validarCaractere(informacoes_tenistaDeMesa.get(Tenista.estilo), caracteres_validos_estilo, Tenista.estilo));
        
        tenistaDeMesa.setPremiacoes((ArrayList<Premiacao>) informacoes_tenistaDeMesa.get(Tenista.premiacoes));
        tenistaDeMesa.setTotalPartidas(Validacao.validarInteiroPositivo(informacoes_tenistaDeMesa.get(Tenista.totalPartidas), Tenista.totalPartidas));
        tenistaDeMesa.setTotalVitorias(Validacao.validarInteiroPositivo(informacoes_tenistaDeMesa.get(Tenista.totalVitorias), Tenista.totalVitorias));
        tenistaDeMesa.setTotalDerrotas(Validacao.validarInteiroPositivo(informacoes_tenistaDeMesa.get(Tenista.totalDerrotas), Tenista.totalDerrotas));
        tenistaDeMesa.setTotalDesistencias(Validacao.validarInteiroPositivo(informacoes_tenistaDeMesa.get(Tenista.totalDesistencias), Tenista.totalDesistencias));
        
    }
    
    private void validarSeTenistaDeMesaAindaNaoExiste(TenistaDeMesa tenistaDeMesa) throws TenistaInvalidoException{
        for(TenistaDeMesa tenista : tenistas){
            if(tenista.getNome().equals(tenistaDeMesa.getNome()))
                throw new TenistaInvalidoException("O Tenista de Mesa '" + tenistaDeMesa.getNome() + "' já está cadastrado");
        }
    }
    
}
