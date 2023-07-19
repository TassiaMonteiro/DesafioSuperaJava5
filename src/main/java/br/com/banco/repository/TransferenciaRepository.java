package br.com.banco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.entities.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
	
	List<Transferencia> findByNomeOperadorTransacao(String nomeOperadorTransacao);
	
	@Query("SELECT t FROM Transferencia t WHERE to_date(to_char(t.dataTransferencia, 'dd/MM/yyyy'), 'dd/MM/yyyy') > to_date(?1, 'dd/MM/yyyy') ")
	List<Transferencia> findByDataInicio(String dataInicio);
	
	@Query("SELECT t FROM Transferencia t WHERE to_date(to_char(t.dataTransferencia, 'dd/MM/yyyy'), 'dd/MM/yyyy') < to_date(?1, 'dd/MM/yyyy') ")
	List<Transferencia> findByDataFim(String dataFim);
	
	@Query("SELECT t FROM Transferencia t WHERE to_date(to_char(t.dataTransferencia, 'dd/MM/yyyy'), 'dd/MM/yyyy') between to_date(?1, 'dd/MM/yyyy') and to_date(?2, 'dd/MM/yyyy')")
	List<Transferencia> findByDataInicioFim(String dataInicio, String dataFim);

	@Query("SELECT t FROM Transferencia t WHERE to_date(to_char(t.dataTransferencia, 'dd/MM/yyyy'), 'dd/MM/yyyy') between to_date(?1, 'dd/MM/yyyy') and to_date(?2, 'dd/MM/yyyy') and t.nomeOperadorTransacao like ?3")
	List<Transferencia> findByDataInicioFimUsuario(String dataInicio, String dataFim, String nomeUsuario);

	@Query("SELECT t FROM Transferencia t WHERE to_date(to_char(t.dataTransferencia, 'dd/MM/yyyy'), 'dd/MM/yyyy') < to_date(?1, 'dd/MM/yyyy') and t.nomeOperadorTransacao like ?2")
	List<Transferencia> findByDataFimUsuario(String dataFim, String nomeUsuario);
	
	@Query("SELECT t FROM Transferencia t WHERE to_date(to_char(t.dataTransferencia, 'dd/MM/yyyy'), 'dd/MM/yyyy') > to_date(?1, 'dd/MM/yyyy') and t.nomeOperadorTransacao like ?2")
	List<Transferencia> findByDataInicioUsuario(String dataInicio, String nomeUsuario);

}
