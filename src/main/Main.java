package main;

import java.util.Scanner;

import addressbook.AddressBook;

public class Main {

	public static void main(String[] args) {
		// menu
		// 1.지인추가
		
		// 2.지인삭제
		// 지인검색 - 3.이름, 4.주소, 5.memo
		// 6. 지인수정
		
		Scanner sc = new Scanner(System.in);
		AddressBook book = new AddressBook();
		
		while (true) {
		
			System.out.println("======주소록추가=======");
			System.out.println("1. 지인추가");
			System.out.println("2. 지인삭제");
			System.out.println("3. 이름검색");
			System.out.println("4. 주소검색");
			System.out.println("5. 메모검색");
			System.out.println("6. 지인수정");
			System.out.println("7. 종   료");
			System.out.println("===================");
			System.out.print("메뉴선택 >>");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				book.add();
				break;
			case 2:
				book.drop();
				break;
			case 3:
				book.search(num);
				break;
			case 4:
				book.search(num);
				break;
			case 5:
				book.search(num);
				break;
			case 6:
				book.upgrade();
				break;
			case 7:
				return;
			}
			
		}

	}

}
