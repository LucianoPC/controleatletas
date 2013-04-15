/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

/**
 *
 * @author luciano
 */
public class CampoInvalidoException extends Exception {

    /**
     * Creates a new instance of <code>CampoInvalidoException</code> without detail message.
     */
    public CampoInvalidoException() {
    }

    /**
     * Constructs an instance of <code>CampoInvalidoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CampoInvalidoException(String msg) {
        super(msg);
    }
}
