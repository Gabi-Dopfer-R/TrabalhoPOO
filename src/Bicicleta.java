public class Bicicleta extends Veiculo{

    public Bicicleta(int id){
        this.qtdBlocos = 2;
        this.id = id;

        for (int i = 0; i < 2; i++) {
            roda.add(new Roda());
        }

        //Imagem da bicicleta
        veiculo.add("    __o");
        veiculo.add("  _`\\<,_");
        veiculo.add(" (*)/ (*)");
    }

    //mover bicicleta conferindo rodas calibradas
    public void Mover(){
        if(RodasCalibradas()) {
            this.distPercorrida += qtdBlocos;
            System.out.printf("\nVeiculo %d se movimentou\n", this.id);
        } else {
            System.out.printf("\nVeiculo %d nao se movimentou devido a problemas\n", this.id);
        }
    }

    //mostrar informações da bicicleta
    public void MostrarInfo() {
        System.out.println("Tipo: Bicicleta.");
        super.MostrarInfo();
        System.out.print("\n");
    }
}
