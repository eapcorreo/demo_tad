/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_tad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eperez50
 */
public class tad_cuit {
    
    private String cuit;
    private boolean valido;
    private int LARGO=11;

    public tad_cuit() {
        this.setValido(false);
    }

    public tad_cuit(String cuit) {
        this.cuit = cuit;
        this.setValido(false);
    }
    
    public String getCuit() {
        return cuit;
    }

    public boolean getValido() {
        return valido;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
    public void esValido() {
        
        // debemos separar el cuit en cifras
        // debemos tener una lista de multiplicadores
        // necesitamos un acumulador de la suma
        // necesitamos el modulo de la division
        // necesitamos el resultado de la resta
        // extraer el digito del cuit interno
        // obtener el digito calculado
        
        String digito="";
        String digito_calculado="";
        Float acumula = new Float(0);
        Float modulo = new Float(0);
        Float resta = new Float(0);
        Float divisor = new Float(11);
        Float fonce = new Float(11);
        Float fdiez = new Float(10);
        
        if (!this.validaLargo()) {
            this.setValido(false);
        }
        
        // lista de multiplicadores
        List <Integer> multipli = new ArrayList<Integer>();
        multipli.add(0, new Integer(5));
        multipli.add(1, new Integer(4));
        multipli.add(2, new Integer(3));
        multipli.add(3, new Integer(2));
        multipli.add(4, new Integer(7));
        multipli.add(5, new Integer(6));
        multipli.add(6, new Integer(5));
        multipli.add(7, new Integer(4));
        multipli.add(8, new Integer(3));
        multipli.add(9, new Integer(2));
        
        // digitos del cuit
        digito = this.getCuit().substring(this.LARGO-1);
        for (int x=0; x<this.LARGO-1; x++) {
            String undigito = this.getCuit().substring(x,x+1);
            System.out.println(undigito);
            Float multi = new Float(multipli.get(x));
            Float cuenta1 = new Float(undigito) * multi;
            acumula = acumula + cuenta1;
        }

        System.out.println(acumula);
        
        modulo = acumula % divisor;

        System.out.println(modulo);
        
        resta = divisor - modulo;
        
        System.out.println(resta);
        
        if (resta.compareTo(fonce)==0) {
            digito_calculado = "0";
        }
        else if (resta.compareTo(fdiez)==0) {
            digito_calculado = "9";
        } 
        else {
            digito_calculado = new Integer(resta.intValue()).toString();
        }

        System.out.println(digito);
        System.out.println(digito_calculado);
        
        if (digito.compareTo(digito_calculado)==0) {
            this.setValido(true);
        }
        else {
            this.setValido(false);
        }

        System.out.println(this.getValido());
        
    }
    
    private boolean validaLargo() {
        
        if (this.getCuit().length() != this.LARGO) {
            return false;
        }
        return true;
    }
}
