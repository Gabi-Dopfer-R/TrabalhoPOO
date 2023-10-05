@echo off
set list=Roda Veiculo VeiculoMotorizado IPVA CarroPasseio Bicicleta Motocicleta Esportivo Simulador Corrida
(for %%a in (%list%) do (
    javac %%a.java
))
echo "JAVACADO"