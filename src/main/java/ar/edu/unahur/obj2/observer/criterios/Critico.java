package ar.edu.unahur.obj2.observer.criterios;
import java.util.List;
import ar.edu.unahur.obj2.observer.Alerta;

public class Critico implements Criterio{

    @Override
    public Double obtenerRiesgo(List<Alerta> alertasRecibidas) {
        return alertasRecibidas.getLast().esCritica() ? 10.0 : alertasRecibidas.getLast().getNivel();
    }
}