package ar.edu.unahur.obj2.observer.observer;

import ar.edu.unahur.obj2.observer.Alerta;

public interface IObservable {

    void agregarObserver(IObserver observer);

    void eliminarObserver(IObserver observer);

    void notificarObservers(Alerta alerta);
}
