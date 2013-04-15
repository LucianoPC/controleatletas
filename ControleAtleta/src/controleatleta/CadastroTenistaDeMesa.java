/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author luciano
 */
public class CadastroTenistaDeMesa extends JFrame{
    
    private JPanel painelPrincipal;
    private ControleTenistaDeMesa controleTenistaDeMesa;
    
    public CadastroTenistaDeMesa(){
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        painelPrincipal = new JPanel();
        controleTenistaDeMesa = new ControleTenistaDeMesa();
        
        this.add(new BarraDeFerramentas(painelPrincipal, this, controleTenistaDeMesa), BorderLayout.NORTH);
        this.add(painelPrincipal, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Definindo o tipo de desenho da interface como "NIMBUS"
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
            try {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(CadastroTenistaDeMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(CadastroTenistaDeMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(CadastroTenistaDeMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(CadastroTenistaDeMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            }
        }
        
        CadastroTenistaDeMesa telaPrincipal = new CadastroTenistaDeMesa();
        telaPrincipal.setMaximumSize(new Dimension(800, 600));
        telaPrincipal.setMinimumSize(new Dimension(800, 600));
        telaPrincipal.setVisible(true);
    }
    
}
