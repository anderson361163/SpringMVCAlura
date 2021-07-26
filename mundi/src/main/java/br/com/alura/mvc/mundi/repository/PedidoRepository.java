package br.com.alura.mvc.mundi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.StatusPedido;

//@Repository
//public class PedidoRepository {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public List<Pedido> recuperaTodosOsPedidos(){
//		Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);
//		return query.getResultList();
//	}
//	
//}

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	//public List<Pedido> findAll();
	List<Pedido> findByStatus(StatusPedido aguardando);
}