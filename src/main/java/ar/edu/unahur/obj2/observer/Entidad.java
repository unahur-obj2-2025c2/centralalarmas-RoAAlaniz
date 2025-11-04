package ar.edu.unahur.obj2.observer;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.criterios.Criterio;
import ar.edu.unahur.obj2.observer.observer.IObserver;

public class Entidad implements IObserver{

    private final String nombre;
    private List<Alerta> alertasRecibidas = new ArrayList<>();
    private Criterio criterioRiesgo = new RiesgoCritico();

    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Alerta> getAlertasRecibidas() {
        return alertasRecibidas;
    }

    public void setAlertasRecibidas(List<Alerta> alertasRecibidas) {
        this.alertasRecibidas = alertasRecibidas;
    }

    public Criterio getCriterioRiesgo() {
        return criterioRiesgo;
    }

    public void setCriterioRiesgo(Criterio criterioRiesgo) {
        this.criterioRiesgo = criterioRiesgo;
    }

    @Override
    public void actualizar(Alerta alerta) {
        alertasRecibidas.add(alerta);
    }
}