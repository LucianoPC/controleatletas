/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.util.ArrayList;

/**
 *
 * @author luciano
 */
public class TenistaDeMesa extends Atleta implements Comparable<TenistaDeMesa> {
    
    private char categoria; // A=Amador P=Profissional
    private char estilo; // O=Ortodoxo(destro) S=Southpaw(canhoto)
    private ArrayList<Premiacao> premiacoes;
    private int totalPartidas;
    private int totalVitorias;
    private int totalDerrotas;
    private int totalDesistencias;
    
    public TenistaDeMesa(String nome) throws TenistaInvalidoException{
        super(nome);
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public char getEstilo() {
        return estilo;
    }

    public void setEstilo(char estilo) {
        this.estilo = estilo;
    }

    public ArrayList<Premiacao> getPremiacoes() {
        return premiacoes;
    }

    public void setPremiacoes(ArrayList<Premiacao> premiacoes) {
        this.premiacoes = premiacoes;
    }

    public int getTotalDerrotas() {
        return totalDerrotas;
    }

    public void setTotalDerrotas(int totalDerrotas) {
        this.totalDerrotas = totalDerrotas;
    }
    
    public int getTotalPartidas() {
        return totalPartidas;
    }

    public void setTotalPartidas(int totalPartidas) {
        this.totalPartidas = totalPartidas;
    }

    public int getTotalVitorias() {
        return totalVitorias;
    }

    public void setTotalVitorias(int totalVitorias) {
        this.totalVitorias = totalVitorias;
    }

    public int getTotalDesistencias() {
        return totalDesistencias;
    }

    public void setTotalDesistencias(int totalDesistencias) {
        this.totalDesistencias = totalDesistencias;
    }
    

    @Override
    public int compareTo(TenistaDeMesa outroTenista) {
        return this.getNome().compareTo(outroTenista.getNome());
    }
    
}
