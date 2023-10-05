import java.util.Random;
import java.io.Serializable;

public class Simulador implements Serializable{

    public Veiculo[] veiculo = new Veiculo[20];

    public Simulador(){
        for(int i=0; i<20; i++){
            veiculo[i] = null;
        }
    }

    //Criar veiculo.
    public void CriarVeiculo(String tipo) {
        int id;

        if (Veiculo.GetQtdVeiculos()== 20) {
            System.out.println("Quantidade Maxima de veiculos atingida");
            System.out.println(Veiculo.GetQtdVeiculos());
            return;
        }

        do {
            // Gera ID aleatório para o veículo
            Random aleatorio = new Random();
            id = aleatorio.nextInt(20);
            // Sai do while quando encontra um índice vazio
        } while (veiculo[id] != null);

        //cria um objeto do tipo indicado no menu.
        switch(tipo){
            case "B"://bicicleta
                veiculo[id] = new Bicicleta(id);
                Veiculo.AlterarQtdVeiculos(true);
                break;
            case "E"://esportivo
                veiculo[id] = new Esportivo(id);
                Veiculo.AlterarQtdVeiculos(true);
                break;
            case "M"://motocicleta
                veiculo[id] = new Motocicleta(id);
                Veiculo.AlterarQtdVeiculos(true);
                break;
            case "C"://carro de passeio
                veiculo[id] = new CarroPasseio(id);
                Veiculo.AlterarQtdVeiculos(true);
                break;
            default: System.out.println("Tipo incorreto.");
        }

        System.out.println("Quantidade de veiculos:" + Veiculo.GetQtdVeiculos());
    }

    //Remover um veículo
    public void RemoverVeiculo(int id){
        if(id < 0 || id >= 20 || veiculo[id] == null) {
            System.out.println("Veiculo Nao encontrado");
        }
        else {
            veiculo[id] = null;
            Veiculo.AlterarQtdVeiculos(false);
            System.out.printf("Veiculo %d removido com sucesso", id);
        }
    }

    //Mostrar as informações de todos os veículos
    public void MostrarInfoTodos() {
        int aux = 0;
        //Percorre o vetor de veículo
        System.out.print("\n");
        for (Veiculo c : veiculo) {
            if (c != null) {
                c.MostrarInfo();
                aux = 1;
            }
        }
        if(aux == 0){
            System.out.print("Nao ha veiculo na pista.");
        }
    }

    //Mostrar as informações de todos os veículos de um único tipo.
    public void MostrarInfoPorTipo(String tipo){
        //determina qual o tipo escolhido
        int aux = 0;
        System.out.print("\n");
        for(Veiculo c : veiculo){
            if(c != null){
                //determina qual o tipo.
                switch(tipo){
                    case "B"://bicicleta
                        if(c instanceof Bicicleta){
                            c.MostrarInfo();
                            aux = 1;
                        }
                        break;
                    case "E"://esportivo
                        if(c instanceof Esportivo){
                            c.MostrarInfo();
                            aux = 1;
                        }
                        break;
                    case "M"://motocicleta
                        if(c instanceof Motocicleta){
                            c.MostrarInfo();
                            aux = 1;
                        }
                        break;
                    case "C"://carro de passeio
                        if(c instanceof CarroPasseio){
                            c.MostrarInfo();
                            aux = 1;
                        }
                        break;
                    default:
                        System.out.println("Tipo nao existe.");
                        return;
                }
            }
        }
        if(aux == 0){
            System.out.print("Nao ha veiculo desse tipo.");
        }
    }

    //Mover todos os veículos de um único tipo
    public void MoverPorTipo(String tipo){
        int aux = 0;
        for(Veiculo c : veiculo){
            if(c != null){
                //determina qual o tipo escolhido e move apenas os veiculos do tipo.
                switch(tipo){
                    case "B"://bicicleta
                        if(c instanceof Bicicleta) {
                            c.Mover();
                            aux = 1;
                        }
                        break;
                    case "E"://esportivo
                        if(c instanceof Esportivo){
                            c.Mover();
                            aux = 1;
                        }
                        break;
                    case "M"://motocicleta
                        if(c instanceof Motocicleta){
                            c.Mover();
                            aux = 1;
                        }
                        break;
                    case "C"://carro de passeio
                        if(c instanceof CarroPasseio){
                            c.Mover();
                            aux = 1;
                        }
                        break;
                    default:
                        System.out.println("Tipo nao existe.");
                        return;
                }
            }
        }
        if(aux == 0){
            System.out.print("Nao ha nenhum veiculo desse tipo.");
        }
    }

    //Mover todos os veículos
    public void MoverTodos() {
        int aux = 0;
        for (int i=0; i < 20; i++) {
            if (veiculo[i] != null) {
                veiculo[i].Mover();
                aux = 1;
            }
        }
        if(aux == 0){
            System.out.print("Nao ha nenhum veiculo na pista.");
        }
    }

    //Mover um único veículo
    public void MoverUm(int id){
        if (id > 19 || id < 0 || veiculo[id] == null) {
            System.out.println("Veiculo nao encontrado");
        }
        else{
            veiculo[id].Mover();
        }
    }

    //Pista é responsável por printar todos os veículos que estão inclusos
    public void Pista() {
        int aux = 0;
        for (int i=0; i<20; i++) {
            if (veiculo[i] != null) {
                veiculo[i].ImprimirVeiculo();
                aux = 1;
            }
        }
        if(aux == 0){
            System.out.print("Nao ha veiculo na pista.");
        }
    }

    //validar se é possivel abastecer o veículo
    public void AbastecerVeiculo(int id, float gasolina){
        if (id < 0 || id > 19 || veiculo[id] == null) {
            System.out.println("Veiculo Nao encontrado");
        }
        else if(veiculo[id] instanceof Bicicleta){
            System.out.println("Veiculo nao utiliza combustivel.");
        }
        else{
            VeiculoMotorizado aux = (VeiculoMotorizado) veiculo[id];
            aux.Abastecer(gasolina);

            System.out.printf("Veiculo %d abastecido com %.2f litros", id, gasolina);
        }
    }

    //Esvaziar ou calibrar todas as rodas de um tipo de veículo
    public void EsvaziarCalibrarPorTipo(String tipo, boolean acao) {
        int aux = 0;
        for (Veiculo c : veiculo) {
            if (c != null) {
                //determina qual o tipo escolhido e move apenas os veiculos do tipo.
                switch (tipo) {
                    case "B"://bicicleta
                        if (c instanceof Bicicleta) {
                            c.TodasRodas(acao);
                            aux = 1;
                        }
                        break;
                    case "E"://esportivo
                        if (c instanceof Esportivo) {
                            c.TodasRodas(acao);
                            aux = 1;
                        }
                        break;
                    case "M"://motocicleta
                        if (c instanceof Motocicleta) {
                            c.TodasRodas(acao);
                            aux = 1;
                        }
                        break;
                    case "C"://carro de passeio
                        if (c instanceof CarroPasseio) {
                            c.TodasRodas(acao);
                            aux = 1;
                        }
                        break;
                    default:
                        System.out.println("Tipo nao existe.");
                        return;
                }
            }
        }
        if (aux == 0) {
            System.out.print("Nao ha nenhum veiculo desse tipo.");
        } else {
            if(acao){
                System.out.print("Pneus calibrados com sucesso.");
            }else{
                System.out.print("Pneus esvaziados com sucesso.");
            }
        }
    }
}
