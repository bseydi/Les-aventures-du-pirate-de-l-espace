package applicationV1.vue;

import applicationV1.modele.Personnage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.Pane;

public class EstMort implements ChangeListener<Number>{
	
	private Personnage p;
	private Pane paneGameOver;
	private ChoiceDialog choiceDialog;
	
	public EstMort (Personnage p,Pane pane) {
		this.p=p;
		this.paneGameOver=pane;
		this.choiceDialog=new ChoiceDialog<>();
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		// TODO Auto-generated method stub
		if(p.getPointDeVie()==0) {
			paneGameOver.setVisible(false);

		}
	}

}
