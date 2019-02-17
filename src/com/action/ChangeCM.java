package com.action;

import com.dao.ChangeCMDao;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 修改病历和药物
 */
@SuppressWarnings("serial")
public class ChangeCM  extends ActionSupport{
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	private String doctor;
	private String type;
	private String id;
	private String text;
	private String preDoctor;
	private String createTime;


	public String execute() throws ParseException {
		System.out.println(String.format("接受到的数据为：1->%s\t2->%s\t3->%s",id,type,text));
		ChangeCMDao ccmd=new ChangeCMDao();
		if(type.equals("case")) {
			if (doctor==null){
				ccmd.changeCase(id, text,preDoctor);
				return SUCCESS;
			}
			//允许医生进行更换，但只允许修改当日病历，不允许修改历史病历
			if (!preDoctor.equals(doctor)){
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String presentTime=sdf.format(date);
				if (!presentTime.equals(createTime)){
					return INPUT;
				}else{
					ccmd.changeCase(id, text,doctor);
					return SUCCESS;
				}
			}else{
				ccmd.changeCase(id, text,doctor);
				return SUCCESS;
			}
		}else if(type.equals("medicine")) {
			ccmd.changeMedicine(id, text);
		}else {
			return INPUT;
		}
		if(ccmd.getChackSql()>0) {
			return SUCCESS;
		}else {
			return INPUT;
		}
	}


	public String getPreDoctor() {
		return preDoctor;
	}

	public void setPreDoctor(String preDoctor) {
		this.preDoctor = preDoctor;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
