package control;

import model.concreto.CinemaBean;
import view.Menu;

public class Principal {

    static CinemaBean cinema = new CinemaBean(" Jupiter");

    public static CinemaBean getCinema() {
        return cinema;
    }

    public static void main(String[] args) {
        Menu.getInstance().mostrar(cinema);
    }
}
