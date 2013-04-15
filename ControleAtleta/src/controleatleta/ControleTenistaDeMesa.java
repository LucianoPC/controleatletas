/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author luciano
 */
public class ControleTenistaDeMesa {
    
    public interface ControleTenistaDeMesaChangeListener{
        public void onControleTenistaDeMesaChange(ControleTenistaDeMesa controleTenistaDeMesa);
    }
    
    private ArrayList<TenistaDeMesa> tenistas;
    private List<TenistaDeMesa> safeTenistas;
    private ControleTenistaDeMesaChangeListener controleTenistaDeMesaChangeListener;
    
    public ControleTenistaDeMesa(){
        tenistas = new ArrayList<TenistaDeMesa>();
        safeTenistas = Collections.unmodifiableList(tenistas);
    }
    
    public void adicionar(TenistaDeMesa tenistaDeMesa) throws TenistaInvalidoException{
        validarSeTenistaDeMesaAindaNaoExiste(tenistaDeMesa);
        tenistas.add(tenistaDeMesa);
        notifyListener();
    }
    
    public void remover(TenistaDeMesa tenistaDeMesa){
        tenistas.remove(tenistaDeMesa);
        notifyListener();
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
    
    private void notifyListener(){
        if(controleTenistaDeMesaChangeListener != null)
            controleTenistaDeMesaChangeListener.onControleTenistaDeMesaChange(this);
    }
    
    private void validarSeTenistaDeMesaAindaNaoExiste(TenistaDeMesa tenistaDeMesa) throws TenistaInvalidoException{
        for(TenistaDeMesa tenista : tenistas){
            if(tenista.getNome().equals(tenistaDeMesa.getNome()))
                throw new TenistaInvalidoException("O Tenista de Mesa '" + tenistaDeMesa.getNome() + "' já está cadastrado");
        }
    }
    
}
