package model.abstrato;

import control.IngressoControl;
import control.Principal;
import model.concreto.CinemaBean;

public abstract class IngressoAbstract {

    protected int identificador;
    protected double valor;
    protected CinemaBean cinema;

    public IngressoAbstract(int identificador) {
        this.identificador = identificador;
        this.cinema = Principal.getCinema();
    }

    public IngressoAbstract() {
        this.cinema = Principal.getCinema();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getValor() {
        return valor;
    }
}
