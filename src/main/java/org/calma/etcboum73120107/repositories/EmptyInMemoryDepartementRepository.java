package org.calma.etcboum73120107.repositories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.calma.etcboum73120107.models.Departement;

public class EmptyInMemoryDepartementRepository implements DepartementRepository{
    ObservableList<Departement> data;

    public EmptyInMemoryDepartementRepository() {
        data = FXCollections.observableArrayList();
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
        return "departement = " + data;
    }
}
