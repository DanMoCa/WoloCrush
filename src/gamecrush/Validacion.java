/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamecrush;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DanDesktop
 */
public class Validacion extends JPanel {
    
    public void validateIdPuesto(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(c!='2' && c!='1'){
                    getToolkit().beep();
                    e.consume();
                }
        }
        });
    }
    
    
}
