package model.concreto;

import java.util.ArrayList;
import model.abstrato.IngressoAbstract;

public class IngressoDAO {

    private static IngressoDAO instance;

    public static IngressoDAO getInstance() {
        if (instance == null) {
            instance = new IngressoDAO();
        }
        return instance;
    }
    ArrayList<IngressoAbstract> listaIngresso = new ArrayList<>();

    public ArrayList<IngressoAbstract> getListaIngresso() {
        return listaIngresso;
    }

    public int create(IngressoAbstract ingresso) {
        this.listaIngresso.add(ingresso);
        return this.listaIngresso.size();
    }
}
