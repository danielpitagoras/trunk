package floricultura.www;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.ArrayList;

import floricultura.endereco.*;
import floricultura.usuario.*;

@ManagedBean(name = "enderecoBean")
@RequestScoped

public class EnderecoBean {

	private Endereco endereco;
	private Usuario usuariologado = null;
	
	
}
