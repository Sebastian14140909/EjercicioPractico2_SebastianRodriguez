package EjercicioPractico1.service;


import EjercicioPractico1.domain.Evento;
import java.util.List;

public interface EventoService {

    // Se recupera la lista de Eventos 
    //de la tabla Evento dentro de un arrayList
    public List<Evento> getEventos(boolean activo);

    // Se obtiene un registro de evento 
    // objeto de tipo Evento
    public Evento getEvento(Evento evento);

    // Se crea un nuevo registro en la tabla Evento.
    // Se actualiza el registro en la tabla 
    public void save(Evento evento);

    // Se elimina el registro en la tabla
    public void delete(Evento evento);
}
