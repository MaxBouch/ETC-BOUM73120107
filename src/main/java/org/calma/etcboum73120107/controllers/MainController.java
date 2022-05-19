package org.calma.etcboum73120107.controllers;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.calma.etcboum73120107.models.Departement;
import org.calma.etcboum73120107.models.Employe;
import org.calma.etcboum73120107.repositories.DepartementRepository;
import org.calma.etcboum73120107.repositories.InMemoryDepartementRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Employe employe;

    private Employe model;

    @FXML
    private TextField Id;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private DatePicker dateNaissance;

    @FXML
    private TextField courriel;

    @FXML
    private ListView<Departement> departementsInclus;

    @FXML
    private ListView<Departement> departementsExclus;

    @FXML
    private ImageView iconeMailVerif;

    @FXML
    private Button btnValider;

    public MainController() {
        this.employe = new Employe();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bindModel(employe);
    }

    public void bindModel(Employe model) {
        this.model = model;
        initialiserListe();
        bind();
    }


    private void initialiserListe() {
        DepartementRepository departementsDispos = new InMemoryDepartementRepository();
        departementsInclus.getItems().addAll(departementsDispos.getAll());
    }

    private void bind() {
        model.idProperty().bindBidirectional(this.Id.textProperty());
        model.prenomProperty().bindBidirectional(this.prenom.textProperty());
        model.nomProperty().bindBidirectional(this.nom.textProperty());

        model.dateNaissanceProperty().bindBidirectional(this.dateNaissance.valueProperty());

        model.courrielProperty().bindBidirectional(this.courriel.textProperty());

        Bindings.bindContentBidirectional(model.getDepartementsInclus().getAll(), this.departementsInclus.getItems());
        Bindings.bindContentBidirectional(model.getDepartementsExclus().getAll(), this.departementsExclus.getItems());

        this.prenom.textProperty().addListener((observableValue, s, t1) -> {
            updateId();
            valider();
        });
        this.nom.textProperty().addListener((observableValue, s, t1) -> {
            updateId();
            valider();
        });

        this.dateNaissance.valueProperty().addListener((observableValue, s, t1) -> {
            updateId();
            valider();
        });

        this.courriel.textProperty().addListener((observableValue, s, t1) -> valider());

        updateId();
        valider();
    }

    private void updateId() {
        String idTemp = "";
        String SEPARATEUR = "-";

        idTemp += model.getNom().length() <= 3 ? model.getNom() : model.getNom().substring(0, 3);

        idTemp += SEPARATEUR;

        idTemp += model.getPrenom().length() <= 3 ? model.getPrenom() : model.getPrenom().substring(0, 3);

        idTemp += SEPARATEUR;

        idTemp += model.getDateNaissance() != null ? String.format("%tm", model.getDateNaissance()) : "";

        idTemp += SEPARATEUR;

        idTemp += model.getDateNaissance() != null ? String.format("%ty", model.getDateNaissance()) : "";

        idTemp = idTemp.toLowerCase();

        model.setId(idTemp);
    }

    public void valider() {
        btnValider.setDisable(!(
                validerMail() &&
                        model.prenomProperty().get().length() >= 3 &&
                        model.nomProperty().get().length() >= 3 &&
                        model.dateNaissanceProperty().get() != null
        ));
    }

    public boolean validerMail() {
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\" +
                "x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?" +
                ":[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4]" +
                "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:" +
                "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x" +
                "7f])+)\\])";
        if (model.getCourriel().matches(regex)) {
            //iconeMailVerif.setImage(new Image(getClass().getResourceAsStream("/images/email_valid.png")));
            return true;
        }
        else {
            //iconeMailVerif.setImage(new Image(getClass().getResourceAsStream("/images/email_valid.png")));
            return false;
        }
    }

    public void moveToInclus(MouseEvent mouseEvent) {
        Departement departement = this.departementsExclus.getSelectionModel().getSelectedItem();

        if (departement != null) {
            model.getDepartementsExclus().remove(departement);

            model.getDepartementsInclus().add(departement);
        }
    }

    public void moveToExclus(MouseEvent mouseEvent) {
        Departement departement = this.departementsInclus.getSelectionModel().getSelectedItem();

        if (departement != null) {
            model.getDepartementsInclus().remove(departement);

            model.getDepartementsExclus().add(departement);
        }

    }

    public void logger(MouseEvent mouseEvent) {
        System.out.println("Identification: " + model.idProperty().get());
        System.out.println("Prenom: " + model.prenomProperty().get());
        System.out.println("Nom: " + model.nomProperty().get());
        System.out.println("Date de naissance: " + model.dateNaissanceProperty().get());
        System.out.println("Courriel: " + model.courrielProperty().get());
        System.out.println("Inclus: " + model.departementsInclusProperty().get());
        System.out.println("Exclus: " + model.departementsExclusProperty().get());
    }
}
