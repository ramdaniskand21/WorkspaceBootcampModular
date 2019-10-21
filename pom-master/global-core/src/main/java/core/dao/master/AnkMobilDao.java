package core.dao.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.AnkMobil;
import core.model.AnkMobilPK;

public interface AnkMobilDao extends JpaRepository<AnkMobil, AnkMobilPK> {
	@Query("select a from AnkMobil a where a.merk like :search or a.mobilId like :search or a.harga like :search or a.platPolisi like :search")
	public Page<AnkMobil> getDataLloadList (@Param("search") String search, Pageable page);

}
