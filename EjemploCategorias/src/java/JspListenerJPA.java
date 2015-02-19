
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azu
 */
public class JspListenerJPA implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("______");
		sce.getServletContext().setAttribute("emf", emf);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce){
		EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
		emf.close();
	}
}