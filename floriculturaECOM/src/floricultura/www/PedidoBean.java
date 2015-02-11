package floricultura.www;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "pedidoBean")
@RequestScoped

public class PedidoBean {

	public String redirecionaUsuario(){ 
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("ƒ necess‡rio cadastro no sistema.");
		context.addMessage(null, facesMessage);
		
		return "redirecionaRestrito";
		
	}
	
	
}
