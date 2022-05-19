package org.calma.etcboum73120107.models;

public class Departement extends AbstractObject {
    public Departement(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Departement() {
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
