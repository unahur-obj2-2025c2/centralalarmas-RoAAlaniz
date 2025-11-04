package ar.edu.unahur.obj2.observer.criterios;
import java.util.List;
import ar.edu.unahur.obj2.observer.Alerta;

public class Acumulativo implements Criterio{

    @Override
    public Double obtenerRiesgo(List<Alerta> alertasRecibidas) {
        return alertasRecibidas.stream().mapToDouble(Alerta::getNivel).sum();
    }

}
