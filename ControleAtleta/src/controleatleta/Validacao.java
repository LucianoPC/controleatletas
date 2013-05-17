/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controleatleta;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author luciano
 */
public class Validacao {
    
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final String caracteres_validos_para_nome = "qwertyuiopasdfghjklzxcvbnm ";
    private static final String numeros_decimais = "0123456789";
    
    public static String validarNome(Object nome_object, String nome_campo) throws TenistaInvalidoException{
        
        verificarSeObjetoNaoEhNulo(nome_object, nome_campo);
        
        String nome = (String)nome_object;
        nome = nome.trim();
                
        if(nome.length() < 2)
            throw new TenistaInvalidoException(nome_campo + " Invalido: Deve conter no minimo 2 caracteres");
        
        for(int i = 0; i < nome.length(); i++){
            if(!caracteres_validos_para_nome.contains(""+nome.toLowerCase().charAt(i)))
                throw new TenistaInvalidoException(nome_campo + " Invalido: Deve conter apenas letras");
        }
        
        return nome;
    }
    
    public static Date validarData(Object data_object, String nome_campo) throws TenistaInvalidoException{
        
        verificarSeObjetoNaoEhNulo(data_object, nome_campo);
        
        try{
            String data_string = (String)data_object;
            Date data_formatada = dateFormat.parse(data_string);
            return data_formatada;
        } catch(ParseException e){
            throw new TenistaInvalidoException(nome_campo + " Invalido: Formato "
                    + "da data deve ser dd/mm/aaaa");
        }
    }
    
    public static Double validarDouble(Object numero_object, String nome_campo) throws TenistaInvalidoException{
        verificarSeObjetoNaoEhNulo(numero_object, nome_campo);
        
        return converterObjectEmDouble(numero_object, nome_campo);        
    }
        
    public static char validarCaractere(Object caractere_object, String caracteres_validos, String nome_campo) throws TenistaInvalidoException{
        char caractere_char = converterObjectEmChar(caractere_object, nome_campo);
        
        if(!caracteres_validos.contains(""+caractere_char))
            throw new TenistaInvalidoException(nome_campo + " Invalido: deve ser um desses [" + caracteres_validos + "]");
        
        return caractere_char;
    }
    
    private static char converterObjectEmChar(Object caractere_object, String nome_campo) throws TenistaInvalidoException{
        
        verificarSeObjetoNaoEhNulo(caractere_object, nome_campo);
        
        try{
            String caractere_string = String.valueOf(caractere_object);
            char caractere_char = caractere_string.charAt(0);
            return caractere_char;
        } catch(Exception e){
            throw new TenistaInvalidoException(nome_campo + " Invalido: Deve conter apenas um caractere");
        }
    }
    
    public static String validarStringDeInteiroComNumeroDeCaracteresFixo
            (Object numero_object, int numero_caracteres_fixo,  String nome_campo) throws TenistaInvalidoException{
        
        verificarSeObjetoNaoEhNulo(numero_object, nome_campo);
        
        String numero_string = validarStringDeInteiro(numero_object, nome_campo);
        
        if(numero_string.length() != numero_caracteres_fixo)
            throw new TenistaInvalidoException(nome_campo + " Invalido: O campo deve ter " +
                    numero_caracteres_fixo + " digitos");
        
        return numero_string;
    }
    
    public static String validarStringDeInteiro(Object numero_object, String nome_campo) throws TenistaInvalidoException{
        
        verificarSeObjetoNaoEhNulo(numero_object, nome_campo);
        
        String caracteres_validos = numeros_decimais;
        String numero_string = String.valueOf(numero_object);
        
        for(int indice = 0; indice < numero_string.length(); indice++){
            if(!caracteres_validos.contains(""+numero_string.charAt(indice)))
                throw new TenistaInvalidoException(nome_campo + " Invalido: O campo deve conter apenas numeros");
        }
        
        return numero_string;
    }
    
    public static int validarInteiroPositivo(Object numero_object, String nome_campo) throws TenistaInvalidoException{
        
        verificarSeObjetoNaoEhNulo(numero_object, nome_campo);
        
        return converterObjectEmInt(numero_object, nome_campo);
    }
    
    public static String validarStringNaoNula(Object palavra_object, String nome_campo) throws TenistaInvalidoException{
        
        verificarSeObjetoNaoEhNulo(palavra_object, nome_campo);
        
        try{
            String palavra_string = String.valueOf(palavra_object);
            
            if(palavra_string.trim().length() == 0)
                throw new TenistaInvalidoException(nome_campo + " Invalido: Campo Vazio");
            
            return palavra_string;
        } catch(Exception e){
            throw new TenistaInvalidoException(nome_campo + " Invalido");
        }
    }
        
    private static Double converterObjectEmDouble(Object numero_object, String nome_campo) throws TenistaInvalidoException{
        
        verificarSeObjetoNaoEhNulo(numero_object, nome_campo);
        
        try{
            String numero_string = String.valueOf(numero_object);
            Double numero_double = Double.parseDouble(numero_string);
            return numero_double;
        } catch(NumberFormatException e){
            throw new TenistaInvalidoException(nome_campo + " Invalido: Informe um numero real");
        }
    }
    
    private static void verificarSeObjetoNaoEhNulo(Object objeto, String nome_campo) throws TenistaInvalidoException{
        if(objeto == null)
            throw new TenistaInvalidoException(nome_campo + " Invalido: Campo Nulo");
    }
    
    
    private static int converterObjectEmInt(Object numero_object, String nome_campo) throws TenistaInvalidoException{
        try{
            String numero_string = String.valueOf(numero_object);
            int numero_int = Integer.parseInt(numero_string);
            return numero_int;
        } catch(NumberFormatException e){
            throw new TenistaInvalidoException(nome_campo + " Invalido: Informe um numero inteiro");
        }
    }
    
}
