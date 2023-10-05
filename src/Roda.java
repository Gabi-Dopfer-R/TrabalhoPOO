import java.util.Random;
import java.io.Serializable;

public class Roda implements Serializable{
   private boolean calibrado;

    public Roda(){
       Random aleatorio = new Random();
       this.calibrado = aleatorio.nextBoolean();
   }
   public void Calibrar(){
       this.calibrado = true;
    }
    public void Esvaziar(){
        this.calibrado = false;
    }
    public boolean getCalibragem(){
        return this.calibrado;
    }

    public String toString() {
       if (this.calibrado)
           return "Calibrado";
        else {
           return "Descalibrado";
       }
    }
}
