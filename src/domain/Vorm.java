package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class Vorm {
   private Color kleur = Color.WHITE;

   public Color getKleur() {
      return kleur;
   }

   public void setKleur(Color kleur) {
      if(kleur==null)
      {
         throw new IllegalArgumentException("kleur mag niet null zijn");
      }
      this.kleur = kleur;
   }

   public abstract Omhullende getOmhullende();

   public abstract String toString();

   public abstract void teken(Pane root);
}
