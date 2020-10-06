import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Matrice {
	
	private Cellule[][] grille;
	private Cellule[][] grilleAncienne;
	private int taille ;
	private double densite;
	int tempo;
	 
	
	public Matrice(int taille, double densite) {
		super();
		this.taille = taille;
		this.densite = densite;
		this.setGrille(new Cellule[taille][taille]);
		this.setGrilleAncienne(new Cellule[taille][taille]);
		this.init();
		this.initHasard();
	}
	

	//qui cree des cellules inactives dans la grille et les recopie dans la grilleAncinne
	public void init() {
		
		for(int x = 0; x < this.getGrille().length; x++) {
			  for(int y = 0; y < this.getGrille()[x].length; y++) {
				  this.getGrille()[x][y] = new Cellule(this.grille, x, y, false);
			}
		}
		this.copieGrilles();
	}

	
	//qui active densité% de cellule dans la grille et dans la grilleAncienne
	
		public void initHasard() 
		{
			for (Cellule[] l : this.getGrille()) {
				for (Cellule c : l) {
					  Random r = new Random();
					  double dr = r.nextDouble();
					if (dr < this.getDensite()) { 
						c.setNextEtat(true);
						c.setVivante(true);
			    		
			    	} else { 
			    		c.setNextEtat(false);
			    		c.setVivante(false);
			    		
			    	}
					}
			 }
			
		    }

	public void copieGrilles() {
		int tk = this.getGrille().length;
		for(int x = 0; x < tk; x++) {
        for(int y = 0; y < this.getGrille()[x].length; y++) {
			   
				  this.getGrilleAncienne()[x][y] = this.getGrille()[x][y]; 
			    
			  }
	      
		}
		
	}
	public void animGrille() {
		
		for (Cellule[] fx : this.getGrille()) {
            for (Cellule cel : fx) {
		 Timeline littleCycle = new Timeline(new KeyFrame(Duration.millis(tempo),
			      event-> {
			        //à chaque top, lancer une evolution
			         cel.evoluer();
			        //puis effectuer une copie de la matrice
			         copieGrilles();
			       } ));
			   //animation en boucle
			   littleCycle.setCycleCount(Timeline.INDEFINITE);
			   littleCycle.play();
	}
            
		}
	}


	
	
    public void clear() {
        for (Cellule[] c : this.getGrille()) {
            for (Cellule cellule : c ) {
                cellule.clear(); 
            }
        }
    }
    
    

	public int getTaille() {
		return taille;
	}


	public void setTaille(int taille) {
		this.taille = taille;
	}


	public double getDensite() {
		return densite;
	}


	public void setDensite(double densite) {
		this.densite = densite;
	}


	public Cellule[][] getGrille() {
		return grille;
	}


	public void setGrille(Cellule[][] grille) {
		this.grille = grille;
	}


	public Cellule[][] getGrilleAncienne() {
		return grilleAncienne;
	}


	public void setGrilleAncienne(Cellule[][] grilleAncienne) {
		this.grilleAncienne = grilleAncienne;
	

	}
	
}
	
	
	