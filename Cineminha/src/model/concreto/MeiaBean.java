package model.concreto;

import model.abstrato.IngressoAbstract;

public class MeiaBean extends IngressoAbstract {

    public MeiaBean(int identificador) {
        super(identificador);
        this.valor = 10;
    }

    public MeiaBean() {
        this.valor = 10;
    }

}
