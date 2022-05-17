package applicationV1.modele;

public class PommeDeTerre extends Ressources{
	
	private int pv;
	private int donnerPV;
	
	public PommeDeTerre() { //pomme de terre cuite dans craftable
		super(1);
		this.donnerPV=5;
	}
}
