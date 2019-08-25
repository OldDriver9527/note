package org.olddriver.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.olddriver.spring.bean.Admin;
import org.olddriver.spring.bean.Customer;
import org.olddriver.spring.bean.ExampleBean;
import org.olddriver.spring.bean.Individual;
import org.olddriver.spring.repository.AdminRepository;
import org.olddriver.spring.repository.CustomerRepository;
import org.olddriver.spring.repository.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorld")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ExampleBean exampleBean;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private IndividualRepository individualRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
    @Override
	public void init() throws ServletException {
    	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		//System.out.println(exampleBean);
		//Optional<Admin> admin = adminRepository.findById(5);
		//System.out.println(admin);
		
		//Optional<Individual> temp = individualRepository.findById(1);
		//Individual individual = temp.get();
		//System.out.println(individual);
		Optional<Customer> temp = customerRepository.findById(1);
		Customer customer = temp.get();
		System.out.println(customer);
		request.getRequestDispatcher("/WEB-INF/jsp/learnjsp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
