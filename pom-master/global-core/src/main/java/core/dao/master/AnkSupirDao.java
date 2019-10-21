package core.dao.master;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.AnkSupir;
import core.model.AnkSupirPK;

public interface AnkSupirDao extends JpaRepository<AnkSupir, AnkSupirPK>{
	
	@Query("select s from AnkSupir s where s.supirNama like :search or s.supirId like :search or s.supirAlamat like :search or s.harga like :search")
	public Page<AnkSupir> getDataloadList(@Param("search") String search, Pageable pageable);

}
