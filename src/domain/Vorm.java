package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class Vorm implements Drawable{
   private Color kleur = Color.WHITE;
   private boolean isZichtbaar=true;

   public Color getKleur() {
      return kleur;
   }

   public void setKleur(Color kleur) {
      if(kleur==null)
      {
         throw new DomainException("kleur mag niet null zijn");

      }
      this.kleur = kleur;
   }

   public boolean isZichtbaar()
   {
      return this.isZichtbaar;
   }

   public void setZichtbaar(boolean b)
   {
      this.isZichtbaar=b;
   }

   public abstract Omhullende getOmhullende();

}
