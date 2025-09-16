package vo;

public class PersonVo {

	String name;
	int	   age;
	String tel;
	
	public PersonVo() {
		// TODO Auto-generated constructor stub
		System.out.println("--PersonVo()--");
	}
	
	
	
	
	public PersonVo(String name, int age, String tel) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
		
		System.out.println("--PersonVo(name,age,tel)--");
	}




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
		System.out.println("--setName(name)--");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
