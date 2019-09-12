package org.olddriver.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
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
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
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
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
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
		//Optional<Customer> temp = customerRepository.findById(1);
		//Customer customer = temp.get();
		//System.out.println(customer);
		
//		Customer customer = new Customer();
//		customer.setCity("Waltham");
//		
//		Example<Customer> example = Example.of(customer);
//		List<Customer> list = customerRepository.findAll(example);
//		System.out.println(list);
		
//		Admin admin = new Admin();
//		admin.setAdminName("superMan");
//		admin.setAdminPassword("asdf1234");
//		adminRepository.save(admin);
		
		/*ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("hello", "world");
		ListOperations<String, String> listOperations = redisTemplate.opsForList();
		listOperations.leftPush("helloList", "old");
		listOperations.leftPush("helloList", "driver");
		SetOperations<String, String> setOperations = redisTemplate.opsForSet();
		setOperations.add("helloSet", "old","driver","666");
		ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
		zSetOperations.add("helloZSet", "old", 3);
		zSetOperations.add("helloZSet", "driver", 1);
		zSetOperations.add("helloZSet", "666", 2);
		HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
		hashOperations.put("helloHash", "key1", "value1");
		hashOperations.put("helloHash", "key2", "value2");
		BoundValueOperations<String, String> boundValueOperations = redisTemplate.boundValueOps("");*/
		
		HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
		Admin admin = new Admin();
		admin.setAdminName("superman");
		hashOperations.put("hashMap", "superMan", admin);
		Map<String, String> temp = (Map<String, String>) hashOperations.get("hashMap", "superMan");
		System.out.println(temp);
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
