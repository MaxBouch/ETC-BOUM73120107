package org.calma.etcboum73120107.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.calma.etcboum73120107.repositories.DepartementRepository;
import org.calma.etcboum73120107.repositories.EmptyInMemoryDepartementRepository;

import java.time.LocalDate;

public class Employe {
    private StringProperty id;
    private StringProperty prenom;
    private StringProperty nom;

    private ObjectProperty<LocalDate> dateNaissance;

    private StringProperty courriel;

    private ObjectProperty<DepartementRepository> departementsInclus;
    private ObjectProperty<DepartementRepository> departementsExclus;

    public Employe() {
        this.id = new SimpleStringProperty("");
        this.prenom = new SimpleStringProperty("");
        this.nom = new SimpleStringProperty("");

        this.dateNaissance = new SimpleObjectProperty<>();

        this.courriel = new SimpleStringProperty("");

        this.departementsInclus = new SimpleObjectProperty<>(new EmptyInMemoryDepartementRepository());
        this.departementsExclus = new SimpleObjectProperty<>(new EmptyInMemoryDepartementRepository());
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public LocalDate getDateNaissance() {
        return dateNaissance.get();
    }

    public ObjectProperty<LocalDate> dateNaissanceProperty() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance.set(dateNaissance);
    }

    public String getCourriel() {
        return courriel.get();
    }

    public StringProperty courrielProperty() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel.set(courriel);
    }

    public DepartementRepository getDepartementsInclus() {
        return departementsInclus.get();
    }

    public ObjectProperty<DepartementRepository> departementsInclusProperty() {
        return departementsInclus;
    }

    public void setDepartementsInclus(DepartementRepository departementsInclus) {
        this.departementsInclus.set(departementsInclus);
    }

    public DepartementRepository getDepartementsExclus() {
        return departementsExclus.get();
    }

    public ObjectProperty<DepartementRepository> departementsExclusProperty() {
        return departementsExclus;
    }

    public void setDepartementsExclus(DepartementRepository departementsExclus) {
        this.departementsExclus.set(departementsExclus);
    }
}
