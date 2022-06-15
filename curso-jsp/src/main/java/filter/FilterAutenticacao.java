package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/principal/*"})/*Intercepta todas as requisições que vierem do projeto ou mapeamento */
public class FilterAutenticacao implements Filter{
        
    public FilterAutenticacao() {
        
    }
	
    /*Encerra os processo quando o servidor é parado*/
    /*Mataria os processos de conexão com banco*/
	public void destroy() {
	}
	
	/*Intercepta as requisições e da as respostas no sistema*/
	/*Tudo que fizer no sistema vai passar por ele*/
	/*Exemplo: validação de autenticação*/
	/*Dar commit e rolback de transações do banco*/
	/*Validar e fazer redirecionamento de paginas*/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req =  (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlParaAutenticar = req.getServletPath();/*url que esta sendo acessada*/
		
		/*Validar se esta logado, senao redireciona ara a tela de login*/

		if(usuarioLogado == null &&	!urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {/*Não esta logado*/
			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por favor realize o login");
			redireciona.forward(request, response);
		
			return;/*Para a execução redireciona para o login*/
		}else {
			chain.doFilter(request, response);
		}
		
		
	}
	/*Inicia os processos ou recursos quando o servidor sobe o projeto*/
	//Iniciar a conexão com o banco
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}