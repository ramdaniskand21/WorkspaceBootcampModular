package core.control.master;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import share.MstDealerDto;
import share.MstGlobalParamDto;
import common.model.RestResponse;
import common.util.CommonConstants;
import core.service.master.MasterDealerSvc;
import core.service.master.MasterGlobalParamSvc;

@RestController
@RequestMapping("/MasterGlobalParam")
public class MasterGlobalParamCtl {
	
	@Autowired
	MasterGlobalParamSvc masterGlobalParamSvc;

	@RequestMapping(method = RequestMethod.POST)
	public RestResponse save(@RequestBody MstGlobalParamDto mstGlobalParamDto){	
		int status;
		String message;
		try {
			masterGlobalParamSvc.save(mstGlobalParamDto);
			status = CommonConstants.OK_REST_STATUS;
			message = "I001";
		} catch (Exception e) {
			// TODO: handle exception
			status = CommonConstants.ERROR_REST_STATUS;
			message = "E003";
		}
		return new RestResponse(status, message, new HashMap<String, Object>());
	};
	
	@RequestMapping(value = "/all/paging/{condition}", method = RequestMethod.GET)
	public RestResponse loadList(
			@PathVariable("condition") String condition) {

		Map<String, Object> map = masterGlobalParamSvc.loadList(condition);
		return new RestResponse(CommonConstants.OK_REST_STATUS, null,
				map.get("contentData"), (long) map.get("totalRecords"));

	};
}

