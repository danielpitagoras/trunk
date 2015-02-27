package floricultura.www;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;	
import floricultura.endereco.*;

@FacesConverter(value = "conversorEnderecos")

public class ConversorEnderecos implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
		
		FacesContext context = FacesContext.getCurrentInstance();
        EnderecoBean enderecoBean = (EnderecoBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "enderecoBean");
        //return enderecoBean.buscarPorCodigo(Integer.parseInt(key));
        return enderecoBean.buscarPorDesc(key);
        //return (Endereco) enderecoBean.buscarPorCodigo(Integer.parseInt(key));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		//return null;
		return arg2.toString();
		
	}

}
