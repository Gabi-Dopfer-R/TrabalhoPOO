import java.io.Serializable;
import java.util.ArrayList;

public abstract class Veiculo implements Serializable {
    ArrayList<Roda> roda = new ArrayList<>();
    ArrayList<String> veiculo = new ArrayList<>();
    int id;
    double valorVenda;
    int qtdBlocos;
    int distPercorrida;
    private static int qtdVeiculos;

    public Veiculo(){
        this.distPercorrida = 0;
    }

    abstract public void Mover();

    //MostrarInfo é responsável por printar as informações sobre um veículo
    public void MostrarInfo() {
        System.out.println(
                "id: " + id + "\n" +
                "Distancia percorrida: " + distPercorrida
        );

        for(int i=0; i<roda.size() ; i++){
            System.out.println("Roda" + (i+1) + ": " + roda.get(i).toString());
        }
    }

    public static int GetQtdVeiculos() {
        return qtdVeiculos;
    }

    public static void AlterarQtdVeiculos(boolean aux) {
        if(aux) {
            qtdVeiculos++;
        } else {
            qtdVeiculos--;
        }
    }

    public static void ZerarQtdVeiculos(){
        qtdVeiculos = 0;
    }

    public int GetQtdRodas() {
        return roda.size();
    }

    //UmaRoda é responsável por modificar o estado(Calibrar/Esvaziar) da roda passada atráves do ID
    public void UmaRoda(int i,boolean acao) {
        if(acao) {
            this.roda.get(i).Calibrar();
        } else {
            this.roda.get(i).Esvaziar();
        }
    }

    //TodasRodas é responsável por modificar o estado(Calibrar/Esvaziar) de todas as rodas de um veículo
    public void TodasRodas(boolean acao) {
        for (Roda c : roda) {
            if(acao) {
                c.Calibrar();   
            } else {
                c.Esvaziar();
            }
        }
    }

    //RodasCalibradas verifica se todas a rodas do veiculo estão calibradas
    public boolean RodasCalibradas() {
        for (int i = 0; i<roda.size(); i++) {
             if (!this.roda.get(i).getCalibragem()) {
                return false;
             }
        }
        return true;
    }

    //ImprimirVeiculo é responsável por printar o desenho do carro
    public void ImprimirVeiculo() {
        String Bloco = " ";
        if (distPercorrida == 0) {
            System.out.println("\n" + id);
            for(int i=0; i<veiculo.size(); i++){
                System.out.print(veiculo.get(i) + "\n");
            }
        } else {
            System.out.println("\n" + id);
            for(int i=0; i<veiculo.size(); i++){
                System.out.print(Bloco.repeat(qtdBlocos) + veiculo.get(i) + "\n");
            }
        }
    }
}