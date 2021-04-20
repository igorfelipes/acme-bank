package br.com.bank.controller;

import java.io.IOException;

import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Client;
import br.com.bank.service.ClientServiceImpl;

@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientServiceImpl service;
	
	public ClientServlet() {
		this.service = new ClientServiceImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
//		if(action == null) {
//	       	response.getWriter().append("Response to client").append(request.getContextPath());	
//		}else {
//			RequestDispatcher rd = request.getRequestDispatcher("/list_client.jsp");
//			request.setAttribute("clients", this.service.getAll());
//			rd.forward(request, response);
//		}	
		
		RequestDispatcher rd = request.getRequestDispatcher("/list_client.jsp");
		
		switch (action) {
        case "list-client":
			request.setAttribute("clients", this.service.getAll());
			rd.forward(request, response);
            break;
        case "delete-client":
    		Long id = Long.parseLong(request.getParameter("id"));
    		this.service.deleteById(id);
    		request.setAttribute("clients", this.service.getAll());
			request.setAttribute("successDelete", "Client successfully removed");
			rd.forward(request, response);
            break;
        default:
        	response.getWriter().append("Response to client").append(request.getContextPath());
            break;
    }
		


	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//PEGA OS DADOS DO REQUEST
		String name  = request.getParameter("name"); 
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//MONTEI O MEU OBJETO CLIENT
		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		client.setPhone(phone);
		
		//SALVAR O MEU CLIENT
		try {
			
			this.service.save(client);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			request.setAttribute("sucessRegister", "successfully registered client");
			request.setAttribute("client", client);
			rd.forward(request, response);
			
		} catch (PersistenceException  e) {
			System.out.println(e);
	        System.out.println("User already exist");
	        
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", "E-mail or Phone already exists. Try again with other Email/Phone");
			rd.forward(request, response);
	    }	
		catch (Exception  e) {
			System.out.println(e);
	        System.out.println("Server error. Verify with support");
	        
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", "Server error. Verify with support");
			rd.forward(request, response);
	    }
	}
	
	
	
}
