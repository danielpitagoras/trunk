package floricultura.util.www;

import org.apache.myfaces.custom.fileupload.UploadedFile;
import javax.faces.bean.*;

@ManagedBean(name = "graphicImageDynamicBean")
@RequestScoped

public class GraphicImageDynamicBean {

	private UploadedFile _upImage;


    public UploadedFile getUpImage()
    {
        return _upImage;
    }

    public void setUpImage(UploadedFile upImage)
    {
        this._upImage = upImage;
    }

    public boolean isUploaded()
    {
        return _upImage != null;
    }
    
    public Class getImageRenderer()
    {
        return UploadedImageRenderer.class;
    }
	
}
