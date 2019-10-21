package core.dao.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.AnkSewa;
import core.model.AnkSewaPK;

public interface AnkSewaDao extends JpaRepository<AnkSewa, AnkSewaPK>{
	@Query("select a from AnkSewa a where a.sewaNama like :search or a.sewaAlamat like :search or a.sewaId like :search or a.tglSewa like :search or a.tglAkhir like :search or a.harga like :search")
	public Page <AnkSewa> getDataloadList(@Param("search")String search, Pageable page);

}
