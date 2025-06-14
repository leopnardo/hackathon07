package leonardo.barbosa.dao;

import java.util.List;

public interface DaoInterface {

    boolean salvar(Object entity);

    boolean atualizar (Object entity);

    List<Object> listar();

    Object buscarPorId(int id);

    boolean deletar(int id);

}
