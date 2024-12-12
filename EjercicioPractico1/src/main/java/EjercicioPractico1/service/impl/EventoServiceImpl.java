package EjercicioPractico1.service.impl;



import EjercicioPractico1.domain.Evento;
import EjercicioPractico1.service.EventoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoServiceImpl implements EventoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> getEventos(boolean activo) {
        String query = "SELECT e FROM Evento e";
        return entityManager.createQuery(query, Evento.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Evento getEvento(Evento evento) {
        return entityManager.find(Evento.class, evento.getId());
    }

    @Override
    @Transactional
    public void save(Evento evento) {
        if (evento.getId() == null) {
            entityManager.persist(evento);
        } else {
            entityManager.merge(evento);
        }
    }

    @Override
    @Transactional
    public void delete(Evento evento) {
        Evento managedEvento = entityManager.find(Evento.class, evento.getId());
        if (managedEvento != null) {
            entityManager.remove(managedEvento);
        }
    }
}
