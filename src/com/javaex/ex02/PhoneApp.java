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
	
	private static List<Person> pList;
	

	public static void main(String[] args) throws IOException {

		System.out.println("*********************************");
		System.out.println("*      전화번호 관리 프로그램   *");
		System.out.println("*********************************");
		System.out.println("");

		Scanner sc = new Scanner(System.in);
		
		loadList(); //파일 읽는 메소드

		

		boolean run = true;

		while (run) {

			System.out.println("1. 리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-------------------------------------");

			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();

			switch (num) {

			case 1:

				System.out.println("<1.리스트>");
				
				showList(); //리스트 출력 메소드

				

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

				saveList(); //저장메소드

				System.out.println("[등록되었습니다.]");

				break;

			case 3:

				System.out.println("<3.삭제>");

				System.out.print("번호 : ");

				int delNum = sc.nextInt();

				pList.remove(delNum - 1);

				saveList(); //저장메소드2

				break;

			case 4:

				System.out.println("<4. 찾기>");
				System.out.print(">이름: ");
				String keyword = sc.next();

				showList(keyword);

				break;

			case 5:

				run = false;

				break;

			default:

				System.out.println("다시 입력해 주세요.");

				break;

			}

		}

		sc.close();

		System.out.println("*********************************");
		System.out.println("*           감사합니다          *");
		System.out.println("*********************************");
		
	}
		
		//////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////중복 메소드 정리//////////////////////////////////
		
		public static void loadList() throws IOException {
			
			Reader fr = new FileReader("C:\\javastudy\\file\\PhoneDB.txt");
			BufferedReader br = new BufferedReader(fr);

			pList = new ArrayList<Person>();

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
			
			br.close();
		}
			
			public static void showList() {
				
				showList(""); // 키워드를 아무것도 없는 값으로 전달
				
			}
			
			public static void showList(String keyword) { //메소드 오버로딩
				
				for (int i = 0; i < pList.size(); i++) {

					System.out.println((i + 1) + "." + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t"
							+ pList.get(i).getCompany());
					System.out.println("");
				}
			}
			
			//리스트를 파라미터로 받아 저장
			
			public static void saveList() throws IOException {
					
				Writer fw = new FileWriter("C:\\javaStudy\\file\\newPhoneDB.txt");

				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < pList.size(); i++) {

					bw.write(pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany());
					bw.newLine();
				}

				bw.close();
				
				
				
				
			}
			
			
			
			
	}

