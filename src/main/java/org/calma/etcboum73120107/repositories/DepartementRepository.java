package org.calma.etcboum73120107.repositories;

import javafx.collections.ObservableList;
import org.calma.etcboum73120107.models.Departement;

public interface DepartementRepository {
    ObservableList<Departement> getAll();

    void add(Departement departement);

    void remove(Departement departement);

    void addAll(DepartementRepository repository);
}
