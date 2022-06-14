package applicationV1.modele.nourriture;

<<<<<<< HEAD
import applicationV1.modele.Acteur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;

public abstract class  Nourriture {

private int pvDonner;
private IntegerProperty quantiteProperty;
private int id;


	public Nourriture(int id, int pvD, int i) {
	this.id = id;
	this.pvDonner = pvD;
	this.quantiteProperty = new SimpleIntegerProperty(i);
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getDonnerPV() {
		return this.pvDonner;
	}
	
	public void setDonnerPV(int pvDonner) {
		this.pvDonner = pvDonner;
	}
	
	public final IntegerProperty quantiteProperty() {
	return this.quantiteProperty;
	}
	
	public int getQuantiteProperty() {
		return this.quantiteProperty.get();
	}
	
	public void setQuantiteProperty(int quantite) {
		this.quantiteProperty.setValue(quantite);
	}
	
	public int getX() {
		return (Integer) null;
	}
	public void setX(int x) {
		
	}
	public  int getY() {
		return (Integer) null;
	}
	public  void setY(int y) {
		
	}

	public Nourriture getPommeDeTerre2() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImageView img() {
		// TODO Auto-generated method stub
		return null;
	}

}
=======
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class  Nourriture {
	
	private int pvDonner;
	private IntegerProperty quantiteProperty;
	private int id;

	
	public Nourriture(int id, int pvD, int i) {
		this.id = id;
		this.pvDonner = pvD;
		this.quantiteProperty = new SimpleIntegerProperty(i);
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getDonnerPV() {
		return this.pvDonner;
	}
	
	public void setDonnerPV(int pvDonner) {
		this.pvDonner = pvDonner;
	}
	
	public final IntegerProperty quantiteProperty() {
		return this.quantiteProperty;
	}
	
	public int getQuantiteProperty() {
		return this.quantiteProperty.get();
	}
	
	public void setQuantiteProperty(int quantite) {
		this.quantiteProperty.setValue(quantite);
	}

}
>>>>>>> branch 'develop' of https://github.com/bseydi/Les-aventures-du-pirate-de-l-espace.git
