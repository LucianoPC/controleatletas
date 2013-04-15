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
    private JToggleButton btnAlterar;
    private JToggleButton btnDeletar;
    private JToggleButton btnPesquisar;
    
    public BarraDeFerramentas(JPanel painel, JFrame telaPrincipal, ControleTenistaDeMesa controleTenistaDeMesa){
        this.painel = painel;
        this.telaPrincipal = telaPrincipal;
        this.controleTenistaDeMesa = controleTenistaDeMesa;
        
        this.setSize(10, 10);
        
        btnCadastrar = new JToggleButton("Cadastrar");
        btnAlterar = new JToggleButton("Alterar");
        btnDeletar = new JToggleButton("Deletar");
        btnPesquisar = new JToggleButton("Visualizar");
        
        ButtonGroup grpBotoes = new ButtonGroup();
        grpBotoes.add(btnCadastrar);
        grpBotoes.add(btnAlterar);
        grpBotoes.add(btnDeletar);
        grpBotoes.add(btnPesquisar);
        
        btnCadastrar.addActionListener(this);
        btnAlterar.addActionListener(this);
        btnDeletar.addActionListener(this);
        btnPesquisar.addActionListener(this);
        
        this.add(btnCadastrar);
        this.add(btnAlterar);
        this.add(btnDeletar);
        this.add(btnPesquisar);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object origem = event.getSource();
        
        if(origem.equals(btnCadastrar)){
            alterarPainel(painel, new PnlCadastrarTenistaDeMesa(telaPrincipal, controleTenistaDeMesa));
        }
        if(origem.equals(btnAlterar)){
            alterarPainel(painel, new PnlAlterarTenistaDeMesa(telaPrincipal, controleTenistaDeMesa));
        }
        if(origem.equals(btnPesquisar)){
            alterarPainel(painel, new PnlPesquisarTenistaDeMesa(controleTenistaDeMesa));
        }
    }
    
    private void alterarPainel(JPanel painelPrincipal, JPanel novoPainel){
        painelPrincipal.removeAll();
        painelPrincipal.add(novoPainel);
        painelPrincipal.validate();
        painelPrincipal.repaint();
    }
    
}
