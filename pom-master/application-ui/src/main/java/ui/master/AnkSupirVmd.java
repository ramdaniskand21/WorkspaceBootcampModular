package ui.master;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Form;
import org.zkoss.bind.SimpleForm;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import share.AnkSupirDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.CommonConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class AnkSupirVmd extends BaseVmd implements Serializable{
private static final long serialVersionUID = 1L;
	
	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/AnkSupir/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/AnkSupir/_detail.zul";
	private final String WS_URI = "/AnkSupir";
	
	List<AnkSupirDto> ankSupirDtos = new ArrayList<>();
	private AnkSupirDto ankSupirDto = new AnkSupirDto();
	
	private Form formMaster = new SimpleForm();

	public List<AnkSupirDto> getAnkSupirDtos() {
		return ankSupirDtos;
	}
	public void setAnkSupirDtos(List<AnkSupirDto> ankSupirDtos) {
		this.ankSupirDtos = ankSupirDtos;
	}
	public AnkSupirDto getAnkSupirDto() {
		return ankSupirDto;
	}
	public void setAnkSupirDto(AnkSupirDto ankSupirDto) {
		this.ankSupirDto = ankSupirDto;
	}
	public AnkSupirDto getAnkSupirDtoSelected() {
		return ankSupirDtoSelected;
	}
	public void setAnkSupirDtoSelected(AnkSupirDto ankSupirDtoSelected) {
		this.ankSupirDtoSelected = ankSupirDtoSelected;
	}
	private AnkSupirDto ankSupirDtoSelected = new AnkSupirDto();

	
	@Override
	protected void loadList(){
		RestResponse rest = callWsWithPaging(WS_URI+"/all/paging", new HashMap<String, Object>(), HttpMethod.POST);
		try {
			ankSupirDtos = JsonUtil.mapJsonToListObject(rest.getContents(), AnkSupirDto.class);
			setTotalSize(rest.getTotalRecords());
			BindUtils.postNotifyChange(null, null, this, "ankSupirDtos");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Command("refresh")
	public void refresh() {
		navigate("");
		getPageInfo().setListMode(true);
		navigate(INDEX_PAGE_PATH);
	}
	
	@Command
	public void add(){
		getPageInfo().setAddMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Command
	public void edit(){
		if(ankSupirDtoSelected == null || ankSupirDtoSelected.getSupirAlamat()==null){
			showSmartMsgBox("W001");
			return;
		}
		
		getPageInfo().setEditMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Override
	public void onEdit(){
		ankSupirDto = (AnkSupirDto) Executions.getCurrent().getAttribute("obj");
		BindUtils.postNotifyChange(null, null, this, "ankSupirDtos");
	}
	
	@Command
	public void view(){
		if(ankSupirDtoSelected == null || ankSupirDtoSelected.getSupirId()==null){
			showSmartMsgBox("W001");
			return;
		}
		Executions.getCurrent().setAttribute("obj", ankSupirDtoSelected);
		getPageInfo().setViewMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Override
	public void onView(){
		ankSupirDto = (AnkSupirDto) Executions.getCurrent().getAttribute("obj");
		onEdit();
	}
	
	@Command
	public void save(){
		ankSupirDto.setCompanyCode(getCurrentUserSession().getCompanyCode());
		if(getPageInfo().isAddMode()){
			ankSupirDto.setCreatedBy(getCurrentUserSession().getUserId());
			ankSupirDto.setCreatedDate(new Date());
		}else{
			ankSupirDto.setUpdateBy(getCurrentUserSession().getUserId());
			ankSupirDto.setCreatedDate(new Date());
		}
		RestResponse rest = callCustomWs(WS_URI, ankSupirDto, HttpMethod.POST);
		
		if(rest.getStatus()==CommonConstants.OK_REST_STATUS){
			showSmartMsgBox(rest.getMessage());
			back();
		}else{
			showSmartMsgBox(rest.getMessage());
		}
		
	}
	
	@Command
	public void back(){
		getPageInfo().setListMode(true);
		navigate(INDEX_PAGE_PATH);
	}
	public Form getFormMaster() {
		return formMaster;
	}
	public void setFormMaster(Form formMaster) {
		this.formMaster = formMaster;
	}
}
