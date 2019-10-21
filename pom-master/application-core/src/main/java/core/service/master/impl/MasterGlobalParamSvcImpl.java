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
import share.MstDealerDto;
import share.MstGlobalParamDto;
import core.dao.master.MstDealerDao;
import core.dao.master.MstGlobalParamDao;
import core.model.MstDealer;
import core.model.MstGlobalParam;
import core.service.NumberGeneratorSvc;
import core.service.master.MasterGlobalParamSvc;

@Service
@Transactional
public class MasterGlobalParamSvcImpl implements MasterGlobalParamSvc {
	
	@Autowired
	MstGlobalParamDao mstGlobalParamDao;
	
	@Autowired
	NumberGeneratorSvc numberGenerator;
	
	@Autowired
	MapperFacade mapperFacade;
	
	Paging page = new Paging();


	@Override
	public void save(MstGlobalParamDto mstGlobalParamDto) {
		String condition = "";
		if(mstGlobalParamDto.getCondition()==null)
			condition = numberGenerator.getNextNumericNumber(mstGlobalParamDto.getCondition(), "GL02", mstGlobalParamDto.getCreatedBy());
		else
			condition = mstGlobalParamDto.getCondition();
		
		MstGlobalParam mstGlobalParam = mapperFacade.map(mstGlobalParamDto, MstGlobalParam.class);
		mstGlobalParamDto.setCondition(condition);
		mstGlobalParamDao.save(mstGlobalParam);

	}

	@Override
	public Map<String, Object> loadList(String condition) {
		
		List<MstGlobalParam> datas = mstGlobalParamDao.getDataLoadList(StringUtil.nevl(condition, "%%"));
		List<MstGlobalParamDto> dtos = new ArrayList<MstGlobalParamDto>();
		
		for(MstGlobalParam o : datas){
			dtos.add(mapperFacade.map(o, MstGlobalParamDto.class));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalRecords", new Long(dtos.size()));
		map.put("contentData", dtos);
		return map;
	}

}
