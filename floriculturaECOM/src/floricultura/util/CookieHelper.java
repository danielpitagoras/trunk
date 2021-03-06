package floricultura.util;

import javax.faces.context.*;
import javax.servlet.http.*;

public class CookieHelper {

	public void setCookie(String name, String value, int expiry, FacesContext instance) {
	
		HttpServletRequest request = (HttpServletRequest) instance.getExternalContext().getRequest();
		Cookie cookie = null;
		Cookie[] userCookies = request.getCookies();
		
		if (userCookies != null && userCookies.length > 0) {
		
			for(int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals(name)) {
					cookie = userCookies[i];
					break;
				}
			}
		}
		if (cookie != null) {
			cookie.setValue(value);
		} else {
			cookie = new Cookie(name, value);
			cookie.setPath(request.getContextPath());
		}
		cookie.setMaxAge(expiry);
		HttpServletResponse response = (HttpServletResponse) instance.getExternalContext().getResponse();
		response.addCookie(cookie);
	}
	
	public Cookie getCookie(String name, FacesContext instance){
		
		//FacesContext facesContext = FacesContext.getCurrentInstance();
		
		HttpServletRequest request = (HttpServletRequest) instance.getExternalContext().getRequest();
		Cookie cookie = null;
		
		Cookie[] userCookies = request.getCookies();
		if(userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals(name)) {
					cookie = userCookies[i];
					return cookie;
				}	
			}
		}
		return null;
	}
}