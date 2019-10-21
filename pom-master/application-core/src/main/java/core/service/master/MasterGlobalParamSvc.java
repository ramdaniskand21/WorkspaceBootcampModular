package core.service.master;

import java.util.Map;

import share.MstGlobalParamDto;

public interface MasterGlobalParamSvc {

	public abstract void save(MstGlobalParamDto mstGlobalParamDto);
	
	public abstract Map<String, Object> loadList(String condition);
}
