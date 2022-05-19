package org.calma.etcboum73120107.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.calma.etcboum73120107.models.Departement;;

public class InMemoryDepartementRepository implements DepartementRepository{
    ObservableList<Departement> data;

    public InMemoryDepartementRepository() {
        data = FXCollections.observableArrayList();
        data.add(new Departement(0, "Administration"));
        data.add(new Departement(1, "Ressources humaine"));
        data.add(new Departement(2, "Marketing"));
        data.add(new Departement(3, "Logistique"));
    }

    @Override
    public ObservableList<Departement> getAll() {
        return data;
    }

    @Override
    public void add(Departement departement) {
        data.add(departement);
    }

    @Override
    public void remove(Departement departement) {
        data.remove(departement);
    }

    @Override
    public void addAll(DepartementRepository repository) {
        this.data.addAll(repository.getAll());
    }

    @Override
    public String toString() {
        return "département = " + data ;
    }
}
