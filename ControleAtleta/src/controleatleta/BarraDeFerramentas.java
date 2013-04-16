/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 *
 * @author luciano
 */
public class BarraDeFerramentas extends JToolBar implements ActionListener{
    
    private JPanel painel;
    private JFrame telaPrincipal;
    private ControleTenistaDeMesa controleTenistaDeMesa;
    
    private JToggleButton btnCadastrar;
    private JToggleButton btnAlterarVisualizarDeletar;
    
    public BarraDeFerramentas(JPanel painel, JFrame telaPrincipal, ControleTenistaDeMesa controleTenistaDeMesa){
        this.painel = painel;
        this.telaPrincipal = telaPrincipal;
        this.controleTenistaDeMesa = controleTenistaDeMesa;
                
        btnCadastrar = new JToggleButton("Cadastrar");
        btnAlterarVisualizarDeletar = new JToggleButton("Alterar / Visualizar / Deletar");
        
        ButtonGroup grpBotoes = new ButtonGroup();
        grpBotoes.add(btnCadastrar);
        grpBotoes.add(btnAlterarVisualizarDeletar);
        
        btnCadastrar.addActionListener(this);
        btnAlterarVisualizarDeletar.addActionListener(this);
        
        this.add(btnCadastrar);
        this.add(btnAlterarVisualizarDeletar);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object origem = event.getSource();
        
        if(origem.equals(btnCadastrar)){
            alterarPainel(painel, new PnlCadastrarTenistaDeMesa(telaPrincipal, controleTenistaDeMesa, true));
        }
        if(origem.equals(btnAlterarVisualizarDeletar)){
            alterarPainel(painel, new PnlAlterarDeletarPesquisarTenistaDeMesa(controleTenistaDeMesa));
        }
    }
    
    private void alterarPainel(JPanel painelPrincipal, JPanel novoPainel){
        painelPrincipal.removeAll();
        painelPrincipal.add(novoPainel);
        painelPrincipal.validate();
        painelPrincipal.repaint();
    }
    
}
