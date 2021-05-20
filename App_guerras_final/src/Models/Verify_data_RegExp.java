
//package Models;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// *
// * @author grupo1
// */
//public class Verify_data_RegExp {
//
//    boolean option = true;
//    int seleccion = 0;
//    String input;
//    
//    public Verify_data_RegExp() {
//        
//    }
//    
//    //Patron para validar fechas
//    Pattern patronFechas = Pattern.compile("^([0][1-9]|[1][0-9]|[3][0-1])+[\\\\-]+([0][1-9]|[1][0-2])+[\\\\-]+(\\d{4})$");
//    
//    //Patron para validar años
//    Pattern patronAños = Pattern.compile("([0-9]{2,4})");
//    
//    //Patron para validar NOMBRES (Guerras, paises, contendientes)
//    Pattern patronNombres = Pattern.compile("[a-zA-Z|\\\\.|\\\\-|\\s]{1,}");
//    
//    Matcher m;    
//
//    public void validarFechas() {
//
//        m = patronFechas.matcher(input);
//            
//        if (m.matches()) {
//              seleccion = Integer.parseInt(input);
//              option = false;
//                
//        } else {
//             System.out.println("ERROR fecha incorrecta");
//             option = true;
//        }//Fin del if-else      
//        
//    }
//    
//    public void validarAños() {
//        m = patronAños.matcher(input);
//            
//        if (m.matches()) {
//              seleccion = Integer.parseInt(input);
//              option = false;
//                
//        } else {
//             System.out.println("ERROR año incorrecto");
//             option = true;
//        }//Fin del if-else     
//    }
//    
//    public void validarNombres() {
//        m = patronNombres.matcher(input);
//            
//        if (m.matches()) {
//              seleccion = Integer.parseInt(input);
//              option = false;
//                
//        } else {
//             System.out.println("ERROR nombre incorrecto");
//             option = true;
//        }//Fin del if-else     
//    }    
//    
//}