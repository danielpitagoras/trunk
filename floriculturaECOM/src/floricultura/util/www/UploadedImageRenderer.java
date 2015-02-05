package floricultura.util.www;

import java.io.IOException;
import java.io.InputStream;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.el.ValueBinding;
import org.apache.myfaces.custom.dynamicResources.ResourceContext;
import org.apache.myfaces.custom.graphicimagedynamic.util.ImageRenderer;

@SuppressWarnings("deprecation")
public class UploadedImageRenderer implements ImageRenderer {

	private GraphicImageDynamicBean _graphicImageDynamicBean;

    public void setContext(FacesContext facesContext, ResourceContext imageContext) throws IOException
    {
        ValueBinding vb = facesContext.getApplication().createValueBinding(
                "#{graphicImageDynamicBean}");
        GraphicImageDynamicBean value = (GraphicImageDynamicBean) vb.getValue(facesContext);
        if (value == null)
        {
            throw new IllegalStateException("managed bean graphicImageDynamicBean not found");
        }
        _graphicImageDynamicBean = value;
    }
    
    public int getContentLength() {
        return _graphicImageDynamicBean.isUploaded() ? (int)_graphicImageDynamicBean.getUpImage().getSize() : -1;
    }

    public String getContentType()
    {
        return _graphicImageDynamicBean.isUploaded() ? _graphicImageDynamicBean.getUpImage()
                .getContentType() : null;
    }

    public void renderResource(ResponseStream out)
            throws IOException
    {
        if (_graphicImageDynamicBean.isUploaded())
        {
            InputStream is = _graphicImageDynamicBean.getUpImage().getInputStream();
            try
            {
                byte[] buffer = new byte[1024];
                int len = is.read(buffer);
                while (len != -1)
                {
                    out.write(buffer, 0, len);
                    len = is.read(buffer);
                }
            }
            finally
            {
                is.close();
            }
        }
    }
	
	
}
