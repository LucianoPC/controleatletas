/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Luciano
 */
public class PnlAlterarTenistaDeMesa extends JPanel{
    
    private JFrame parent;
    private ControleTenistaDeMesa controleTenistaDeMesa;
    
    private PnlJComboBoxSelecionarTenistaDeMesa jComboBoxSelecionarTenistaDeMesa;
    
    public PnlAlterarTenistaDeMesa(JFrame parent, ControleTenistaDeMesa controleTenistaDeMesa){
        this.parent = parent;
        this.controleTenistaDeMesa = controleTenistaDeMesa;
        
        jComboBoxSelecionarTenistaDeMesa = new PnlJComboBoxSelecionarTenistaDeMesa();
        
        this.add(jComboBoxSelecionarTenistaDeMesa);
    }
    
}
