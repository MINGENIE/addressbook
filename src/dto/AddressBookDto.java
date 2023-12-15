package dto;

// model
public class AddressBookDto {
	private String name;
	private int age;
	private String phone;
	private String address;
	private String memo;
	
	public AddressBookDto() {
		//기본생성자
	}

	public AddressBookDto(String name, int age, String phone, String address, String memo) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "AddressBookDto [name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + ", memo="
				+ memo + "]";
	}
	
	

}
