package edu.msg.ro.access;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Browser filter to prevent using the application with not supported browsers.
 * 
 * @author laszll
 *
 */
@WebFilter(filterName = "BrowserFilter", urlPatterns = { "*.xhtml" })
public class BrowserFilter implements Filter {

	/**
	 * Init method(not userd).
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Do nothing because of implemented Filter but not used.
	}

	/**
	 * Filter method for redirrecting to login page.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession httpSession = httpRequest.getSession(false);

		String requestUrl = httpRequest.getRequestURI();

		boolean isBrowserPage = requestUrl.indexOf("/browser.xhtml") >= 0;

		boolean isWrongBrowserOrVersion = true;

		String browserData = httpRequest.getHeader("User-Agent");
		int browserIndex = browserData.indexOf("Firefox");
		if (browserIndex >= 0) {
			String browser = browserData.substring(browserIndex);
			String version = browser.replace("Firefox/", "").split(" ")[0];
			int bigVersion = Integer.valueOf(version.split("\\.")[0]);
			if (bigVersion > 30) {
				isWrongBrowserOrVersion = false;
			}
		}

		browserIndex = browserData.indexOf("Chrome");
		if (browserIndex >= 0) {
			String browser = browserData.substring(browserIndex);
			String version = browser.replace("Chrome/", "").split(" ")[0];
			int bigVersion = Integer.valueOf(version.split("\\.")[0]);
			if (bigVersion > 35) {
				isWrongBrowserOrVersion = false;
			}
		}

		if (isWrongBrowserOrVersion && !isBrowserPage) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/browser.xhtml");
		} else {
			if (isBrowserPage && httpSession != null && httpSession.getAttribute("username") != null) {
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/bugManagment.xhtml");
			} else {
				chain.doFilter(request, response);
			}
		}

	}

	/**
	 * Destroy method(not used).
	 */
	@Override
	public void destroy() {
		// Do nothing because of implemented Filter but not used.
	}
}
