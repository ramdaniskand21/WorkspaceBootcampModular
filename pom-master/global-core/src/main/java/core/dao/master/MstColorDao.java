package core.dao.master;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import core.model.MstColor;
import core.model.MstColorPK;

public interface MstColorDao extends JpaRepository<MstColor, MstColorPK> {
	
	@Query("select a from MstColor a where a.colorDescrip like :search")
	public Page<MstColor> getDataLoadList(@Param("search") String search,
			Pageable page);
}
