package floricultura.www;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import floricultura.endereco.Endereco;

@FacesConverter(value = "conversorEnd", forClass = Endereco.class)

public class ConversorEnd implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Endereco) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof Endereco) {
			Endereco endereco = (Endereco) value;
			if (endereco != null && endereco instanceof Endereco && endereco.getCodigo() != null) {
				uiComponent.getAttributes().put( endereco.getCodigo().toString(), endereco);
				return endereco.getCodigo().toString();
			}
		}
		return "";
	}

}
