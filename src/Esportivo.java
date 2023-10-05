public class Esportivo extends VeiculoMotorizado {

    public Esportivo(int id){
        this.cte = 3.15;
        this.qtdBlocos = 10;
        this.gastoCombustivel = 2.3F;
        this.id = id;
        this.valorIPVA = CalcularIPVA(cte);

        for (int i = 0; i < 4; i++) {
            roda.add(new Roda());
        }

        //Imagem do carro esportivo
        veiculo.add("        __");
        veiculo.add("      ~( @\\ \\");
        veiculo.add("   _____]_[_/_>__");
        veiculo.add("  / __ \\<> |  __ \\");
        veiculo.add("=\\_/__\\_\\__|_/__\\_D");
        veiculo.add("   (__)      (__)");
    }

    public Esportivo(int id, int valorVenda){
        this.cte = 3.15;
        this.qtdBlocos = 10;
        this.gastoCombustivel = 2.3;
        this.id = id;
        this.valorVenda = valorVenda;

        for (int i = 0; i < 4; i++) {
            roda.add(new Roda());
        }

        //Imagem do carro esportivo
        veiculo.add("        __");
        veiculo.add("      ~( @\\ \\");
        veiculo.add("   _____]_[_/_>__");
        veiculo.add("  / __ \\<> |  __ \\");
        veiculo.add("=\\_/__\\_\\__|_/__\\_D");
        veiculo.add("   (__)      (__)");
    }

    public void MostrarInfo() {
        System.out.println("Tipo: Esportivo.");
        super.MostrarInfo();
    }
}
