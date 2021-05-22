package com.laboratorio2p3.negocio;

import com.laboratorio2p3.dao.UsuarioDao;
import com.laboratorio2p3.entidades.*;

public class ClsLogin {
	public int Acceso(Login log) {
		int acceso=0;
		/*if(log.getUser().equals("Mauri") && log.getPass().equals("123")) {
			acceso=1;
		}*/
		
		UsuarioDao usuDao = new UsuarioDao();
		Usuario usu= new Usuario();
		usu=usuDao.Login(log);
		if(usu.getUsuario()!=null) {
			acceso=1;
		}else {
			acceso=0;
		}
		return acceso;
	}
}
