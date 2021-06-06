/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controllers.controllerPrincipal;
import java.awt.Color;
import static javax.swing.UIManager.put;

/**
 *
 * @author davidf
 */
public class App_guerras_final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //////Necesario estableces el tema de la UI de windows, GTK o Metal, para que se puedan PINTAR LOS HEADERS DE LA TABLA
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            //Seteando colores de la PROGRESSBAR
            put("ProgressBar.background", Color.WHITE);
            put("ProgressBar.foreground", Color.GREEN);
            put("ProgressBar.selectionBackground", Color.BLACK);
            put("ProgressBar.selectionForeground", Color.BLACK);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (InstantiationException ex) {
            System.out.println(ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println(ex.getMessage());
        }

        controllerPrincipal ctrlWar = new controllerPrincipal();

    }

}
