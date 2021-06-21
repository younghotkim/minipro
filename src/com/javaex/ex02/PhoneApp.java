package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		System.out.println("*********************************");
		System.out.println("*      전화번호 관리 프로그램   *");
		System.out.println("*********************************");
		System.out.println("");

		Scanner sc = new Scanner(System.in);

		Reader fr = new FileReader("C:\\javastudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		List<Person> pList = new ArrayList<Person>();

		String line = "";

		while (true) {

			line = br.readLine();

			if (line == null) {
				break;
			}

			String[] pInfo = line.split(",");

			String name = pInfo[0];
			String hp = pInfo[1];
			String company = pInfo[2];

			Person p = new Person(name, hp, company);

			pList.add(p);

		}

		while (true) {

			System.out.println("1. 리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-------------------------------------");

			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();

			if (num == 5) {

				System.out.println("*********************************");
				System.out.println("*           감사합니다          *");
				System.out.println("*********************************");

				break;

			}

			switch (num) {

			case 1:

				System.out.println("<1.리스트>");

				for (int i = 0; i < pList.size(); i++) {

					System.out.println((i + 1) + "." + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t"
							+ pList.get(i).getCompany());
				}

				break;

			case 2:

				System.out.println("<2.등록>");

				System.out.print(">이름: ");
				String pname = sc.next();

				System.out.print(">휴대전화: ");
				String php = sc.next();

				System.out.print(">회사전화: ");
				String pcompany = sc.next();

				Person person = new Person(pname, php, pcompany);

				pList.add(person);

				Writer fw = new FileWriter("C:\\javaStudy\\file\\newPhoneDB.txt");

				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < pList.size(); i++) {

					bw.write(pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany());
					bw.newLine();
				}

				bw.close();

				System.out.println("[등록되었습니다.]");

				break;

			case 3:

				System.out.println("<3.삭제>");

				System.out.print("번호 : ");

				int delNum = sc.nextInt();

				pList.remove(delNum - 1);

				break;

			case 4:

				System.out.println("<4. 찾기>");
				System.out.print(">이름: ");
				String sName = sc.next();

				for (int i = 0; i < pList.size(); i++) {

					if (pList.get(i).getName().contains(sName)) {

						System.out.println((i + 1) + "." + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t"
								+ pList.get(i).getCompany());
					}

				}

				break;

			default:

				System.out.println("다시 입력해 주세요.");

				break;

			}

		}

		sc.close();
	}

}