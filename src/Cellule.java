import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Cellule {
	
	
	private boolean vivante;
	private boolean etatChange;
	private Cellule[][] grille;
	private Circle cercle;
	private int x,y;
	
	public Cellule (Cellule[][] grille, int x, int y, boolean vivante) 
	
	{
		super();
		this.setVivante(vivante);
		this.setGrille(grille);
		this.setNextEtat(true);
		this.setX(x);
		this.setY(y); }
	
	
	

	
	public void evoluer() {
	
		int nbVoisinesActives = 0;
		int grille = this.getGrille().length; 
		int xx = 0;
		int yy = 0;
	    for(int i=-1; i<=1; i++)
	     for(int j=-1; j<=1; j++)
	     {
	      if(i==0 && j==0) continue;
	      xx = ((this.getX() + i) + grille) % grille;
	      yy = ((y + j) + grille) % grille; 
	      nbVoisinesActives++;     
	     }
	    if(this.grille[xx][yy].vivante)
	    {
	     if(nbVoisinesActives > 3 || nbVoisinesActives < 2)
	      {setNextEtat(false);}
	    }
	    else
	    {
	     if(nbVoisinesActives == 3)
	      {setNextEtat(true);}
	      
	  
	   }
	    
	}

	
	
    public void clear() {
    	
        this.setVivante(false);
        this.setNextEtat(false);
        this.getCercle().setFill(Color.TRANSPARENT);
    }
    

  

	public boolean isVivante() {
		return vivante;
	}

	public void setVivante(boolean vivante) {
		this.vivante = vivante;
	}

	public boolean isNextEtat() {
		return etatChange;
	}

	public void setNextEtat(boolean nextEtat) {
		this.etatChange = nextEtat;
	}

	public Cellule[][] getGrille() {
		return grille;
	}

	public void setGrille(Cellule[][] grille) {
		this.grille = grille;
	}

	public Circle getCercle() {
		return cercle;
	}

	public void setCercle(Circle cercle) {
		this.cercle = cercle;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		
	}
	
	
	public void delete() {
        this.vivante = false;
        this.cercle.setFill(Color.TRANSPARENT);
    }

  

  
    
}


		
	
   