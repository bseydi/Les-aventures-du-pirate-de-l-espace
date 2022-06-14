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
	private Pane paneGameOver;
	private ChoiceDialog choiceDialog;
	private Dialog<String> dialog;
	private HBox hbox;
	private Button button1,button2;
	
	public EstMort (Personnage p,Pane pane) {
		this.p=p;
		this.paneGameOver=pane;
		this.hbox=new HBox();
		this.hbox.setAlignment(Pos.CENTER);
		this.choiceDialog=new ChoiceDialog<>();
		this.dialog=new Dialog<String>();// creer dialog
		this.button1 = new Button("Rejouer");
	    this.button2 = new Button("Arreter");
	}

	@Override
	public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
		// TODO Auto-generated method stub
		if(p.getPointDeVie()==0) {
			paneGameOver.setVisible(true);
			dialog.setTitle("Game over");
			dialog.setContentText("Game over");
			Text txt = new Text("Tu n'as plus de vie, tu as perdu");
		    Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
		    txt.setFont(font);
		    button1.setOnAction(e -> showDialog1());
		    button2.setOnAction(e -> showDialog2());
		    

		}
	}
	
	private void showDialog1() {
		
	}
	
	private void showDialog2() {
	      
	}

}
