package EjercicioPractico1.dao;


import EjercicioPractico1.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoDao extends JpaRepository<Evento, Long> {
}
