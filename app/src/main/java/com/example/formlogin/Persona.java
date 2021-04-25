package com.example.formlogin;

import android.widget.TextView;

import java.io.Serializable;
import java.util.Calendar;

public class Persona implements Serializable {

    private String nome;
    private String cognome;
    private String email;
    private String password;


    private String genere;
    private int altezza, peso, circonferenzaPolso;
    private Calendar dataDiNascita;

    public Persona(){
        this.nome="";
        this.cognome="";
        this.email="";
        this.genere="";
        this.altezza=-1;
        this.peso=-1;
        this.circonferenzaPolso=-1;
        this.email="";
        this.password="";

    }

    public Persona(String nome, String cognome, String genere, int altezza, int peso, int circonferenzaPolso, String email, String password){
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.genere=genere;
        this.altezza=altezza;
        this.peso=-peso;
        this.circonferenzaPolso=circonferenzaPolso;
        this.email=email;
        this.password=password;


    }



    //Get e Set
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCirconferenzaPolso() {
        return circonferenzaPolso;
    }

    public void setCirconferenzaPolso(int circonferenzaPolso) {
        this.circonferenzaPolso = circonferenzaPolso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


    public Calendar getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Calendar dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}

