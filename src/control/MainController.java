/*
 * MainController.java
 */
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import model.*;

/**
 *
 * @author Sandro
 */
public class MainController implements Initializable {

    boolean isPlaying;
    Play play;
    private int newrecord, oldrecord = 0;
    
    @FXML private AnchorPane anchorPane;
    @FXML private Button btnExit;
    @FXML private Button btnPlay;
    @FXML private Label lblMessage, lblPercentage, lblWLRatio, lblWin, lblRecord, lblLoose;
    @FXML private ImageView imgOne, imgTwo, imgThree;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        play = new Play();
        playCards();
        lblRecord.setText("0");
    }    

    /*
     * imposta una nuova mano della partita
     */
    private void playCards() {
        lblWin.setText(String.valueOf(play.getWin()));
        lblLoose.setText(String.valueOf(play.getLoose()));
        Image b = new Image(play.getBackImg());
        imgOne.setImage(b);
        imgTwo.setImage(b);
        imgThree.setImage(b);
        isPlaying = true;
        lblMessage.setText("TROVA L'ASSO, É FACILE");
        anchorPane.setStyle("-fx-base: #E6E6E6;");
        btnExit.setStyle("-fx-base: #575757;");
        btnPlay.setStyle("-fx-base: #575757;");
    }
    
    /*
     * mostra il valore delle tre carte della partita corrente
     * indicando se quella scelta è la vincente o no
     */
    private void showCards(int choosen) {
        Image f1 = new Image(play.getCard(0).getFrontImg());
        Image f2 = new Image(play.getCard(1).getFrontImg());
        Image f3 = new Image(play.getCard(2).getFrontImg());
        imgOne.setImage(f1);
        imgTwo.setImage(f2);
        imgThree.setImage(f3);
        if ( play.isWinner(choosen) ) {
            lblWin.setText(String.valueOf(play.getWin()));
            newrecord++;
            oldrecord = Integer.valueOf(lblRecord.getText());
            if (newrecord > oldrecord) {
                lblRecord.setText(String.valueOf(newrecord));
                lblMessage.setText("COMPLIMENTI, HAI VINTO!");
                anchorPane.setStyle("-fx-base: #5EFFA1;");
            }
            lblMessage.setText("COMPLIMENTI, HAI VINTO!");
            anchorPane.setStyle("-fx-base: #5EFFA1;");
        } else {
            play.getWin();
            newrecord = 0;
            lblLoose.setText(String.valueOf(play.getLoose()));
            lblMessage.setText("NON HAI VINTO, RITENTA");
            anchorPane.setStyle("-fx-base: #FF715E;");
        }
        lblPercentage.setText( play.getPercentage() + " %" );
        lblWLRatio.setText(String.valueOf(play.getWLRatio()).substring(0,3));
        isPlaying = false;
    }

    @FXML
    private void handleBtnPlayAction(ActionEvent event) {
        if (isPlaying) return;
        play.newHand();
        playCards();
    }

    @FXML
    private void handleBtnExitAction(ActionEvent event) {
        System.out.println("Game over: bye bye.");
        Platform.exit();
    }

    @FXML
    private void handleImgOneClick(MouseEvent event) {
        if (!isPlaying) return;
        showCards(0);
    }
    
    @FXML
    private void handleImgTwoClick(MouseEvent event) {
        if (!isPlaying) return;
        showCards(1);
    }
    
    @FXML
    private void handleImgThreeClick(MouseEvent event) {
        if (!isPlaying) return;
        showCards(2);
    }
    
}
