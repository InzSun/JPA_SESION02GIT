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
		
		Query query = pro.createNativeQuery("{call usp_ValidaAcceso(?,?)}", TbUsuario.class);
		query.setParameter(1, "U001@gmail.com");
		query.setParameter(2, "10001");
		
		TbUsuario u = (TbUsuario)query.getSingleResult();
		if(u!=null){
			System.out.println("Bienvenido: "+u.getNomUsua()+" "+u.getApeUsua());
		}else{
			System.out.println("El usuario no existe");
		}
		//List<TbProducto> lstpro = pro.createQuery("Select p From TbProducto p", TbProducto.class).getResultList();
		//System.out.println("Nro de Productos:´"+lstUsuarios.size());
		
		
	}

}
