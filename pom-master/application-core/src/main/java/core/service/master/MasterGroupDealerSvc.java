package core.service.master;

import java.util.Map;

import share.MstGroupDealerDto;

public interface MasterGroupDealerSvc {

	public abstract Map<String, Object> loadList(Map<String, Object> mapInput, String search, int pageSequence, int size, String direction, String orderBy);
}
