package com.laboratorio2p3.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laboratorio2p3.entidades.*;
import com.laboratorio2p3.negocio.ClsLogin;

/**
 * Servlet implementation class ControllerAcceso
 */
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAcceso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession sesion = request.getSession(true);
		String btnCerrar= request.getParameter("btncerrar");
		if(btnCerrar!=null) {
			response.sendRedirect("index.jsp");
			sesion.invalidate();
		}else {
			String user= request.getParameter("user");
			String pass = request.getParameter("pass");
			String tipo= request.getParameter("tipo");
			//Asignar al objeto
			Login log = new Login();
			log.setUser(user);
			log.setPass(pass);
			if(tipo==null) {
				log.setTipo("2");
			}else if(tipo.equals("on")) {
				log.setTipo("1");
			}
			//System.out.println("Usuario:"+log.getUser()+" Pass:"+log.getPass()+" Tipo:"+log.getTipo());
			//Enlazar con la capa de negocio
			ClsLogin clsLogin= new ClsLogin();
			int valoracceso=clsLogin.Acceso(log);
			
			//Evaluar lo que traer el metodo
			if (valoracceso==1) {
				sesion.setAttribute("log", log);
				response.sendRedirect("main.jsp");
			}else {
				System.out.println("Error en los Datos");
				response.sendRedirect("error.jsp");
			}
		}////
	}

}
