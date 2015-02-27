package floricultura.endereco;

import java.util.List;
import floricultura.usuario.Usuario;

public interface EnderecoDAO {

	public void salvar(Endereco endereco);
	public void atualizar(Endereco endereco);
	public void excluir(Endereco endereco);
	public Endereco carregar(Integer codigo);
	public Endereco buscarPorDesc(String desc);
	public Endereco buscarPorDescEUsuario(String desc, int codigo);
	public Endereco buscarPorCodigo(int codigo);
	public List<Endereco> listar();
	public List<Endereco> listarPorUsuario(Usuario usuario);
	
}
