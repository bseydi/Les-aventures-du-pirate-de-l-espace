package applicationV1.vue;

import applicationV1.modele.Personnage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EstMort implements ChangeListener<Number>{
	
	private Personnage p;
private Pane popUpFinJeu;
	
	public EstMort (Personnage p,Pane pane) {
		this.p=p;
		this.popUpFinJeu=pane;
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		// TODO Auto-generated method stub
		if(p.getPointDeVie()==0) {
			popUpFinJeu.setVisible(true);
		}
	}
	
}
