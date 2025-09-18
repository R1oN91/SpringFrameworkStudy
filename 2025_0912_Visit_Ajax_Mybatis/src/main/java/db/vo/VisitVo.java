package db.vo;

//VO(Value Object)
//3위일체
//DB Column == VO Property == From PARAMETER

public class VisitVo {
	
	int	   idx;
	String name;
	String content;
	String pwd;
	String ip;
	String regdate;
	
	public VisitVo() {
		// TODO Auto-generated constructor stub
	}
	//insert
	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}
	
	//update (수정)
	
	public int getIdx() {
		return idx;
	}
	public VisitVo(int idx, String name, String content, String pwd, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

}
