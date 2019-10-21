package core.service.master.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.spring.Paging;
import common.util.StringUtil;
import share.AnkSewaDto;
import core.dao.master.AnkSewaDao;
import core.model.AnkSewa;
import core.service.NumberGeneratorSvc;
import core.service.master.AnkSewaSvc;

@Service
@Transactional
public class AnkSewaSvcImpl implements AnkSewaSvc{

	@Autowired
	AnkSewaDao ankSewaDao;
	
	@Autowired
	NumberGeneratorSvc numberGeneratorSvc;
	
	@Autowired
	MapperFacade mapperFacade;
	
	Paging page = new Paging();
	
	@Override
	public void save(AnkSewaDto ankSewaDto) {
		String sewaId = "";
		if(ankSewaDto.getSewaId()==null)
			sewaId = numberGeneratorSvc.getNextNumericNumber(ankSewaDto.getCompanyCode(), "GL02", ankSewaDto.getCreatedBy());
		else
			sewaId = ankSewaDto.getSewaId();
		
		AnkSewa ankSewa = mapperFacade.map(ankSewaDto, AnkSewa.class);
		ankSewa.setSewaId(sewaId);
		ankSewaDao.save(ankSewa);
		
	}

	@Override
	public Map<String, Object> loadList(Map<String, Object> mapInput,
			String search, int pageSequence, int size, String direction,
			String orderBy) {
		if(orderBy.isEmpty()){
		orderBy = "sewaId";
		}
		direction = "asc";
		Page<AnkSewa> datas = ankSewaDao.getDataloadList(StringUtil.nevl("%"+search+"%", "%%"), page.getPageable(pageSequence, size, direction, orderBy));
		List<AnkSewaDto> dtos = new ArrayList<AnkSewaDto>();
		
		for(AnkSewa o : datas){
			dtos.add(mapperFacade.map(o, AnkSewaDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", datas.getTotalElements());
		map.put("contentData", dtos);
		return map;
	}

}
