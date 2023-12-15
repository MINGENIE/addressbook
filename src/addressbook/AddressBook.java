package addressbook;

import java.util.List;
import java.util.Scanner;

import dao.AddressBookDao;
import dto.AddressBookDto;

public class AddressBook {
	
	Scanner sc = new Scanner(System.in);
	
	// input
	public void add() {
		System.out.println("지인추가입니다.");
		
		System.out.println("이름 >>");
		String name = sc.next();
		
		System.out.println("나이 >>");
		int age = sc.nextInt();
		
		System.out.println("전화번호 >>");
		String phone = sc.next();
		
		System.out.println("주소 >>");
		String address = sc.next();
		
		System.out.println("메모 >>");
		String memo = sc.next();
		
		AddressBookDao dao = AddressBookDao.getInstance();
		
		boolean b = dao.insert(new AddressBookDto(name, age, phone, address, memo));
		if(!b) {
			System.out.println("지인이 추가되지 않았습니다.");
		}
		
		System.out.println("성공적으로 추가했습니다.");
	}
	
	public void drop() {
		System.out.println("지인삭제입니다.");
		
		System.out.println("삭제할 이름 >>");
		String name = sc.next();
		
		AddressBookDao dao = AddressBookDao.getInstance();
		
		boolean b = dao.delete(name);
		if(!b) {
			System.out.println("지인이 삭제되지 않았습니다.");
		}
		System.out.println("성공적으로 삭제되었습니다.");
		
	}
	
	public void search(int num) {
		System.out.println("지인검색입니다.");
		
		switch (num) {
		case 3:
			System.out.println("검색할 이름>>");
			break;
		case 4:
			System.out.println("검색할 주소>>");
			break;
		case 5:
			System.out.println("검색할 메모>>");
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
			System.out.println("등록되어있는 정보가 없습니다.");
		}
	}
	
	
	public void upgrade() {
		System.out.println("지인정보 수정입니다.");
		System.out.println("수정할 사람 >>");
		String name = sc.next();
		
		System.out.println("수정할 번호 >>");
		String phone = sc.next();
		
		AddressBookDao dao = AddressBookDao.getInstance();
		
		boolean b = dao.update(name, phone);
		if(!b) {
			System.out.println("지인이 수정되지 않았습니다.");
		}
		System.out.println("성공적으로 수정되었습니다.");
	}
}
