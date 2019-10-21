package core.dao.master;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstDealer;
import core.model.MstDealerPK;

public interface MstDealerDao extends JpaRepository<MstDealer, MstDealerPK>{
	
	@Query("select b from MstDealer b where b.dealerName like :search")
	public Page <MstDealer> getDataLoadList(@Param("search") String search,
			Pageable page);
}
