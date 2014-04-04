/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gamecrush;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author DanDesktop
 */
public class jTxtFldLimit extends PlainDocument {
    private int limit;
    
    public jTxtFldLimit(int limit){
        this.limit = limit;
    }
    
    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException{
        if(str == null){
            return;
        }else if((getLength() + str.length())<= limit){
            super.insertString(offset, str, set);
        }
    }
}
