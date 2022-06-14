package controleur;

import applicationV1.modele.Personnage;
import applicationV1.modele.nourriture.PommeDeTerreList;
import applicationV1.vue.PommeDeTerreVue;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ControleurClickPommeDeTerre implements EventHandler<MouseEvent>{
	
	private Personnage personnage;
	private PommeDeTerreVue pommeDeTerreVue;
	private PommeDeTerreList pommeDeTerreList;
	
	public ControleurClickPommeDeTerre(Personnage p, PommeDeTerreVue pommeDeTerreVue,PommeDeTerreList pommeDeTerreList) {
		this.personnage=p;
		this.pommeDeTerreVue=pommeDeTerreVue;
		this.pommeDeTerreList=pommeDeTerreList;
	}

	@Override
	public void handle(MouseEvent event) {
		ImageView img =(ImageView) event.getSource();
		if(event.getButton() == MouseButton.SECONDARY) {
			event.getSource();
			System.out.println(event.getSource());
		}
		
	}

}
