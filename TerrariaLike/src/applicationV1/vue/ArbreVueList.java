package applicationV1.vue;

import java.util.ArrayList;

import applicationV1.modele.Arbre;
import javafx.scene.layout.Pane;

public class ArbreVueList {

	private Pane panneauJeu;
	private Arbre arbre;
	private ArbreVue arbreVue;
	private ArrayList<ArbreVue> arbreVueList;
	
	public ArbreVueList(Arbre arbre) {
		this.arbre=arbre;
		this.arbreVueList=new ArrayList<ArbreVue>();
	}
	
	private void ajouterArbreDansList() {
		arbreVueList.add(arbreVue);
	}
	
	public void supprimmerAbreDansList() {
		arbreVueList.remove(arbreVue);
	}
}
