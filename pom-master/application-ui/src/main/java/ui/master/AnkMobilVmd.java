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

import share.AnkMobilDto;
import share.MstColorDto;
import common.model.RestResponse;
import common.ui.BaseVmd;
import common.ui.UIConstants;
import common.util.CommonConstants;
import common.util.JsonUtil;

@Init(superclass = true)
public class AnkMobilVmd extends BaseVmd implements Serializable{

private static final long serialVersionUID = 1L;
	
	private final String INDEX_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/AnkMobil/_index.zul";
	private final String DETAIL_PAGE_PATH = UIConstants.BASE_PAGE_PATH
			+ "/master/AnkMobil/_detail.zul";
	private final String WS_URI = "/AnkMobil";
	
	List<AnkMobilDto> ankMobilDtos = new ArrayList<AnkMobilDto>();
	private AnkMobilDto ankMobilDto = new AnkMobilDto();
	private AnkMobilDto ankMobilDtoSelected = new AnkMobilDto();
	private Form formMaster = new SimpleForm();
	
	public List<AnkMobilDto> getAnkMobilDtos() {
		return ankMobilDtos;
	}
	public void setAnkMobilDtos(List<AnkMobilDto> ankMobilDtos) {
		this.ankMobilDtos = ankMobilDtos;
	}
	public AnkMobilDto getAnkMobilDto() {
		return ankMobilDto;
	}
	public void setAnkMobilDto(AnkMobilDto ankMobilDto) {
		this.ankMobilDto = ankMobilDto;
	}
	public AnkMobilDto getAnkMobilDtoSelected() {
		return ankMobilDtoSelected;
	}
	public void setAnkMobilDtoSelected(AnkMobilDto ankMobilDtoSelected) {
		this.ankMobilDtoSelected = ankMobilDtoSelected;
	}
	
	@Override
	protected void loadList(){
		RestResponse rest = callWsWithPaging(WS_URI+"/all/paging", new HashMap<String, Object>(), HttpMethod.POST);
		try {
			ankMobilDtos = JsonUtil.mapJsonToListObject(rest.getContents(), AnkMobilDto.class);
			setTotalSize(rest.getTotalRecords());
			BindUtils.postNotifyChange(null, null, this, "ankMobilDtos");
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
		if(ankMobilDtoSelected == null || ankMobilDtoSelected.getMobilId()==null){
			showSmartMsgBox("W001");
			return;
		}
		
		Executions.getCurrent().setAttribute("obj", ankMobilDtoSelected);
		getPageInfo().setEditMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Override
	public void onEdit(){
		ankMobilDto = (AnkMobilDto) Executions.getCurrent().getAttribute("obj");
		BindUtils.postNotifyChange(null, null, this, "ankMobilDto");
	}
	
	@Command
	public void view(){
		if(ankMobilDtoSelected == null || ankMobilDtoSelected.getMobilId()==null){
			showSmartMsgBox("W001");
			return;
		}
		Executions.getCurrent().setAttribute("obj", ankMobilDtoSelected);
		getPageInfo().setViewMode(true);
		navigate(DETAIL_PAGE_PATH);
	}
	
	@Override
	public void onView(){
		ankMobilDto = (AnkMobilDto) Executions.getCurrent().getAttribute("obj");
		onEdit();
	}
	
	@Command
	public void save(){
		ankMobilDto.setCompanyCode(getCurrentUserSession().getCompanyCode());
		if(getPageInfo().isAddMode()){
			ankMobilDto.setCreatedBy(getCurrentUserSession().getUserId());
			ankMobilDto.setCreatedDate(new Date());
		}else{
			ankMobilDto.setUpdateBy(getCurrentUserSession().getUserId());
			ankMobilDto.setCreatedDate(new Date());
		}
		RestResponse rest = callCustomWs(WS_URI, ankMobilDto, HttpMethod.POST);
		
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
