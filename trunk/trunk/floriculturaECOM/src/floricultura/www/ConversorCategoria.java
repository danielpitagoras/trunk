package floricultura.www;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;	
import floricultura.categoria.*;

@FacesConverter(value = "conversorCategoria")

public class ConversorCategoria implements Converter {
	
	@Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String key) {
        
		FacesContext context = FacesContext.getCurrentInstance();
        CategoriaBean categoriaBean = (CategoriaBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "categoriaBean");
        //Categoria categoria = new Categoria();
        
        return categoriaBean.buscarPorNome(key);
        //System.out.println(categoria.getCodigo());
        //return categoria.getCodigo();
         
        
        	
        
        //CategoriaDAOHibernate categoriaDAOHibernate = new CategoriaDAOHibernate();
        //return categoriaDAOHibernate.buscarPorCodigo(Integer.valueOf(key));
	
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
      
    	return arg2.toString();
    	//Categoria categoria = (Categoria) arg2;
    	//return String.valueOf(categoria.getCodigo());
        
    }
	
}
