import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	Matrice m;
	public static Circle[][] circles;
	int espace = 15;
	private int taille;
	private double densite;
	private int tempo;
	int r = espace / 2;

	void construireScenePourJeuDeLaVie(Stage primaryStage) {

		int largeur = (taille + 1) * (espace + 1);
		int hauteur = (taille + 1) * (espace + 1);
		Group root = new Group();
		Scene scene = new Scene(root, largeur, hauteur, Color.BLANCHEDALMOND);
		primaryStage.setTitle("Jeu de la vie");
		primaryStage.setScene(scene);
		m = new Matrice(taille, densite);
		circles = new Circle[taille][taille];
		creationTroupe(root);
		primaryStage.show();
		Timeline littleCycle = new Timeline(new KeyFrame(Duration.millis(tempo), event -> {
			this.m.animGrille();
		}));
		littleCycle.setCycleCount(Timeline.INDEFINITE);
		littleCycle.play();
	}
		
	/**
	 *  void creationTroupe(Group root)
  {
   int rayon = espace/2;
   for(int i=0; i<taille; i++)
    for(int j=0; j<taille; j++)
    {
     circles[i][j] = new Circle((i+.5)*espace, (j+.5)*espace, rayon);
     if (matrice[i][j]==1) circles[i][j].setFill(Color.ANTIQUEWHITE);
     else circles[i][j].setFill(Color.DARKSLATEGRAY);
     root.getChildren().add(circles[i][j]);
    }
  }
 
	 */

	void creationTroupe(Group root)

	{
		Cellule[][] grille = this.m.getGrille();

		int temp = espace + r;
		int a = this.taille;

		   for(int i=0; i<taille; i++)
			    for(int j=0; j<taille; j++) {

				Cellule g = grille[i][j];
				circles[i][j] =  new Circle((i+.5)*espace, (j+.5)*espace, r);
				g.setCercle(circles[i][j]);
                if (g.isVivante()) {circles[i][j].setFill(Color.GREEN);}
                else {circles[i][j].setFill(Color.TRANSPARENT);}
				root.getChildren().add(circles[i][j]);
				
			    }

			}
	
	 void evoluerMatrice()
	  {
	   for(int x=0; x<taille; x++)
	     for(int y=0; y<taille; y++)
	      evoluerMatrice();
	  }
	

	public void start(Stage primaryStage) {

		taille = 60;
		tempo = 60;
		espace = 16;
		densite = 0.2;
		construireScenePourJeuDeLaVie( primaryStage);

	}

	public static void main(String[] args) {

		launch(args);

	}

}
