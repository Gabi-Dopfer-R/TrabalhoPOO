public class Motocicleta extends VeiculoMotorizado {
    public Motocicleta(int id){
        this.cte = 0.75;
        this.qtdBlocos = 3;
        this.gastoCombustivel = 0.25F;
        this.id = id;
        this.valorIPVA = CalcularIPVA(cte);

        for (int i = 0; i < 2; i++) {
            roda.add(new Roda());
        }

        //Imagem da motocicleta
        veiculo.add("   ,_oo");
        veiculo.add(".-/c-//::");
        veiculo.add("(_)'==(_)");
    }

    public Motocicleta(int id, int valorVenda){
        this.cte = 0.75;
        this.qtdBlocos = 3;
        this.gastoCombustivel = 0.25;
        this.id = id;
        this.valorVenda = valorVenda;

        for (int i = 0; i < 2; i++) {
            roda.add(new Roda());
        }

        //Imagem da motocicleta
        veiculo.add("   ,_oo");
        veiculo.add(".-/c-//::");
        veiculo.add("(_)'==(_)");
    }

    public void MostrarInfo() {
        System.out.println("Tipo: Motocicleta.");
        super.MostrarInfo();
    }
}
