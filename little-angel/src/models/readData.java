/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author TRITUEVIET
 */
public class readData {
     
    public String read(int i){
        System.out.println("i: "+i);
        DataInputStream da=null;
        try{
        da = new DataInputStream(this.getClass().getResourceAsStream("/"+i+".dat"));
        }catch(Exception e){
            System.out.println(" not found");
        }
        String s=null;
        try {
            s = da.readUTF();
//            System.out.println(""+s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            da.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
            return s;
        
    }
}
