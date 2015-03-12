
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

import model.*;

public class MainController implements Initializable {

    boolean isPlaying;
    Play play;
    
    @FXML private Button btnExit;
    @FXML private Button btnPlay;
    @FXML private Label lblMessage, lblPercentage,lblWinLoose,lblWin,lblLoose;
    @FXML private ImageView imgOne, imgTwo, imgThree;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        play = new Play();
        playCards();
    }    

    /*
     * imposta una nuova mano della partita
     */
    private void playCards() {
        Image b = new Image(play.getBackImg());
        imgOne.setImage(b);
        imgTwo.setImage(b);
        imgThree.setImage(b);
        lblMessage.setText("L'asso di coppe è quello che vince. - Indovina dov'è l'Asso di Coppe ...");
        isPlaying = true;
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
            lblMessage.setText("Complimenti. HAI VINTO!!!");
        } else {
            lblMessage.setText("Non ha vinto, ritenta!");
        }
        lblPercentage.setText( play.getPercentage() + " %" );
        lblWinLoose.setText("Vincite/Perdite: "  + play.winloose ());
        lblWin.setText("Vincite: "  + play.playWin ());
        lblLoose.setText("Perdite: "  + play.playLoose());
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
