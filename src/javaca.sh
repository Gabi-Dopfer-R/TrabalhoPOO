#!/Bin/bash
list=(Roda Veiculo VeiculoMotorizado IPVA CarroPasseio Bicicleta Motocicleta Esportivo Simulador Corrida)
for i in "${list[@]}"; do
    javac "$i".java
done
echo "JAVACADO"