package main;

import java.util.Scanner;

import addressbook.AddressBook;

public class Main {

	public static void main(String[] args) {
		// menu
		// 1.�����߰�
		
		// 2.���λ���
		// ���ΰ˻� - 3.�̸�, 4.�ּ�, 5.memo
		// 6. ���μ���
		
		Scanner sc = new Scanner(System.in);
		AddressBook book = new AddressBook();
		
		while (true) {
		
			System.out.println("======�ּҷ��߰�=======");
			System.out.println("1. �����߰�");
			System.out.println("2. ���λ���");
			System.out.println("3. �̸��˻�");
			System.out.println("4. �ּҰ˻�");
			System.out.println("5. �޸�˻�");
			System.out.println("6. ���μ���");
			System.out.println("7. ��   ��");
			System.out.println("===================");
			System.out.print("�޴����� >>");
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
