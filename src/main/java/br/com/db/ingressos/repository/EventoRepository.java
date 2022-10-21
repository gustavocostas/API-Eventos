package br.com.db.ingressos.repository;

import br.com.db.ingressos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
