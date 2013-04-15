/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

/**
 *
 * @author luciano
 */
public class TenistaInvalidoException extends Exception {

    /**
     * Creates a new instance of <code>TenistaInvalidoException</code> without detail message.
     */
    public TenistaInvalidoException() {
    }

    /**
     * Constructs an instance of <code>TenistaInvalidoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public TenistaInvalidoException(String msg) {
        super(msg);
    }
}
