package cn.strutsdemo;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.TypeConversionException;

@Entity
public class HelloWorIdAction /*implements Action*/extends ActionSupport {
	private String name = "";
	private String message = "";
	private String password = "";
	
	public void validate(){
		if (this.getPassword()==null || this.getPassword().length()==0) {
			addFieldError("name", "用户名不能为空");
		}
		if (this.getPassword()==null || this.getPassword().length()==0) {
			addFieldError("pwd", "密码" +
					"为空");
		}
	}
	public String execute() throws Exception {// 根据用户输入的姓名，进行“hello”的封装
		if ("acc".equals(password)) {
			this.setMessage("hello," + this.getName() + "!");
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("sett", name);
			return "app";// 处理完毕，返回“app”
		} else {
			return "helloWorld";// 处理完毕，返回“helloWorld”
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
