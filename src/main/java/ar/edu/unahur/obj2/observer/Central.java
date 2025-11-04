package ar.edu.unahur.obj2.observer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import ar.edu.unahur.obj2.observer.exception.NivelAlertaException;
import ar.edu.unahur.obj2.observer.observer.IObservable;
import ar.edu.unahur.obj2.observer.observer.IObserver;

public class Central implements IObservable{

    private Set<IObserver> observadores = new HashSet<>();
    private Map<Alerta, Integer> registro = new HashMap<>();

    public Central(Set<IObserver> observadores, Map<Alerta, Integer> registro) {
        this.observadores = observadores;
        this.registro = registro;
    }

    public Set<IObserver> getObservadores() {
        return observadores;
    }

    public void setObservadores(Set<IObserver> observadores) {
        this.observadores = observadores;
    }

    public Map<Alerta, Integer> getAlertasRecibidas() {
        return registro;
    }

    public void setAlertasRecibidas(Map<Alerta, Integer> registro) {
        this.registro = registro;
    }

    public void emitirAlerta(String tipo, Integer nivel){
        if (nivel < 1 || nivel > 10) {
            throw new NivelAlertaException("El nivel de alerta incorrecto");
        }
        Alerta alerta = new Alerta(tipo, nivel);
        registro.put(alerta, observadores.size());
        notificarObservers(alerta);
    }

    @Override
    public void agregarObserver(IObserver observer) {
        observadores.add(observer);
    }

    @Override
    public void eliminarObserver(IObserver observer) {
        observadores.remove(observer);
    }

    @Override
    public void notificarObservers(Alerta alerta) {
        observadores.forEach(observer -> observer.actualizar(alerta));
    }

    public Integer cantidadNotificacionesEnviadas() {
        return registro.values().stream().mapToInt(Integer::intValue).sum();
    }
}