package core.dao.master;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstDealer;
import core.model.MstGlobalParam;
import core.model.MstGlobalParamPK;

public interface MstGlobalParamDao extends JpaRepository<MstGlobalParam, MstGlobalParamPK>{
	
	@Query("select b from MstGlobalParam b where b.condition = :condition")
	public List <MstGlobalParam> getDataLoadList(@Param("condition") String condition);

}
