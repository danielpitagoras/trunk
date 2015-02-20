package floricultura.endereco;

import java.util.*;
import floricultura.usuario.Usuario;
import floricultura.util.DAOFactory;

public class EnderecoRN {

	private EnderecoDAO enderecoDAO;
	
	public EnderecoRN() {
		this.enderecoDAO = DAOFactory.criarEnderecoDAO();
	}
	
	public List<Endereco> listar() {
		return this.enderecoDAO.listar();
	}
	
	public List<Endereco> listarPorUsuario(Usuario usuario) {
		return this.enderecoDAO.listarPorUsuario(usuario);
	}
	
	public Endereco carregar(Integer codigo) {
		return this.enderecoDAO.carregar(codigo);
	}
	
	public void salvar(Endereco endereco) {
		this.enderecoDAO.salvar(endereco);
	}
	
	public void excluir(Endereco endereco) {
		this.enderecoDAO.excluir(endereco);
	}
	
}
