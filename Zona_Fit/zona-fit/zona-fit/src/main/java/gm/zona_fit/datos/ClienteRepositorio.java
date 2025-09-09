package gm.zona_fit.datos;

import gm.zona_fit.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {
}
