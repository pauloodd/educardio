package util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class FiltroLimparSessao extends HttpServlet implements Filter {
	private FilterConfig filterConfig;
	private static final long serialVersionUID = 1L;
	// Handle the passed-in FilterConfig
	/**
	 * <<Descri��o do m�todo>>
	 * 
	 * @param filterConfig
	 *            Descri��o do par�metro
	 */
	public void init(FilterConfig filterConfig) {
		setFilterConfig(filterConfig);
	}

	// Process the request/response pair
	/**
	 * <<Descri��o do m�todo>>
	 * 
	 * @param request
	 *            Descri��o do par�metro
	 * @param response
	 *            Descri��o do par�metro
	 * @param filterChain
	 *            Descri��o do par�metro
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		try {
			String url = ((HttpServletRequest) request).getServletPath();

			if (/*(url.startsWith("/Exibir") || url.startsWith("/exibir")) && */url.endsWith(".do")) {
				HttpServletRequest requestPagina = ((HttpServletRequest) request);
				HttpSession sessao = requestPagina.getSession(false);

				if (requestPagina.getParameter("method") != null
						&& (requestPagina.getParameter("method").startsWith("mostrar") || 
								requestPagina.getParameter("method").startsWith("atendimentoEdit")
								|| requestPagina.getParameter("method").startsWith("novo"))) {
					Enumeration parametrosSessao = requestPagina.getSession(false)
							.getAttributeNames();

					while (parametrosSessao.hasMoreElements()) {
						String nomeParametro = (String) parametrosSessao
								.nextElement();

						if (nomeParametro.equalsIgnoreCase("usuario")
								|| nomeParametro
										.equalsIgnoreCase("paciente")
								|| nomeParametro
										.equalsIgnoreCase("atendimento")
								|| nomeParametro
										.equalsIgnoreCase("org.apache.struts.action.LOCALE")) {

							continue;
						} else {
							sessao.removeAttribute(nomeParametro);
						}
					}
				}
			}

			filterChain.doFilter(request, response);
		} catch (ServletException sx) {
			throw sx;
		} catch (IOException iox) {
			throw iox;
		}
	}

	// Clean up resources
	/**
	 * <<Descri��o do m�todo>>
	 */
	public void destroy() {
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
}
