package addressbook;

import java.util.List;
import java.util.Scanner;

import dao.AddressBookDao;
import dto.AddressBookDto;

public class AddressBook {
	
	Scanner sc = new Scanner(System.in);
	
	// input
	public void add() {
		System.out.println("�����߰��Դϴ�.");
		
		System.out.println("�̸� >>");
		String name = sc.next();
		
		System.out.println("���� >>");
		int age = sc.nextInt();
		
		System.out.println("��ȭ��ȣ >>");
		String phone = sc.next();
		
		System.out.println("�ּ� >>");
		String address = sc.next();
		
		System.out.println("�޸� >>");
		String memo = sc.next();
		
		AddressBookDao dao = AddressBookDao.getInstance();
		
		boolean b = dao.insert(new AddressBookDto(name, age, phone, address, memo));
		if(!b) {
			System.out.println("������ �߰����� �ʾҽ��ϴ�.");
		}
		
		System.out.println("���������� �߰��߽��ϴ�.");
	}
	
	public void drop() {
		System.out.println("���λ����Դϴ�.");
		
		System.out.println("������ �̸� >>");
		String name = sc.next();
		
		AddressBookDao dao = AddressBookDao.getInstance();
		
		boolean b = dao.delete(name);
		if(!b) {
			System.out.println("������ �������� �ʾҽ��ϴ�.");
		}
		System.out.println("���������� �����Ǿ����ϴ�.");
		
	}
	
	public void search(int num) {
		System.out.println("���ΰ˻��Դϴ�.");
		
		switch (num) {
		case 3:
			System.out.println("�˻��� �̸�>>");
			break;
		case 4:
			System.out.println("�˻��� �ּ�>>");
			break;
		case 5:
			System.out.println("�˻��� �޸�>>");
			break;
		}
		
		String word = sc.next();			
		
		AddressBookDao dao = AddressBookDao.getInstance();
		List<AddressBookDto> list = dao.select(word, num);
		
		if(list.size() > 0) {
			for (AddressBookDto dto : list) {
				System.out.println(dto.toString());
			}
		} else {
			System.out.println("��ϵǾ��ִ� ������ �����ϴ�.");
		}
	}
	
	
	public void upgrade() {
		System.out.println("�������� �����Դϴ�.");
		System.out.println("������ ��� >>");
		String name = sc.next();
		
		System.out.println("������ ��ȣ >>");
		String phone = sc.next();
		
		AddressBookDao dao = AddressBookDao.getInstance();
		
		boolean b = dao.update(name, phone);
		if(!b) {
			System.out.println("������ �������� �ʾҽ��ϴ�.");
		}
		System.out.println("���������� �����Ǿ����ϴ�.");
	}
}
