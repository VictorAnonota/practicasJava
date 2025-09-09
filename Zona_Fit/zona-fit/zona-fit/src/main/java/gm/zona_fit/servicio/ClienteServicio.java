package gm.zona_fit.servicio;

import  gm.zona_fit.datos.ClienteRepositorio;
import  gm.zona_fit.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes(){
        return (List<Cliente>) clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente){
        return clienteRepositorio.findById(idCliente).orElse(null);
    }

    @Override
    public void guardarCliente(Cliente cliente){
        clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente){
        clienteRepositorio.delete(cliente);
    }
}

