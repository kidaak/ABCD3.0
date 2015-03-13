package cu.uci.abos.platform.util;

import org.eclipse.rap.rwt.RWT;

public class PlatformUtil {
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static String createUrl(String path) {
		StringBuffer url = new StringBuffer();
		url.append(RWT.getRequest().getContextPath());
		/*System.out.println("url " + RWT.getRequest().getContextPath());
		url.append(RWT.getRequest().getServletPath());
		System.out.println("url1 " + RWT.getRequest().getServletPath());*/
		url.append(path);
		return RWT.getResponse().encodeURL(url.toString());
	}
}
