package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.TbProducto;
import model.TbUsuario;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase01x");
		EntityManager pro = fabrica.createEntityManager();
		
		Query query = pro.createNativeQuery("{call findAll_usuarios()}", TbUsuario.class);
		
		List<TbUsuario> lstUsuarios = query.getResultList();
		
		//Vista
		//List<TbProducto> lstpro = pro.createQuery("Select p From TbProducto p", TbProducto.class).getResultList();
		System.out.println("Nro de Productos:´"+lstUsuarios.size());
	}

}
