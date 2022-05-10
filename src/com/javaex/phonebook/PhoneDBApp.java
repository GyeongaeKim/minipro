package com.javaex.phonebook;

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

public class PhoneDBApp {

	public static void main(String[] args) throws IOException{
		
		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		List<PhoneDB> dbList = new ArrayList<PhoneDB>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = br.readLine();
			if(str==null) {break;}
			String[] dbArray = str.split(",");
				String name = dbArray[0];
				String hp = dbArray[1];
				String company = dbArray[2];
			PhoneDB db = new PhoneDB(name, hp, company);
			dbList.add(db);
		}
		
		System.out.println("********************************");
		System.out.println("*    전화번호 관리 프로그램    *");
		System.out.println("********************************");
		
		
		while(true) {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("--------------------------------------");
			
			System.out.print(">메뉴번호: ");
			String menuNo = sc.nextLine();
			
			if(menuNo=="5") {break;}
			
			switch(menuNo) {
				case "1": 
					System.out.println("<1.리스트>");
					for(int i=0; i<dbList.size(); i++) {
						System.out.println((i+1) +".\t"+ dbList.get(i).getName() +"\t"+ dbList.get(i).getHp() +"\t"+ dbList.get(i).getCompany());
					}
					System.out.println("");
					break;
				case "2": 
					System.out.println("<2.등록>");
					int counter=0;
					PhoneDB newDB = new PhoneDB();
					newDB.setPno(++counter);
					
					System.out.print(">이름: ");
					newDB.setName(sc.nextLine());
					
					System.out.print(">휴대전화: ");
					newDB.setHp(sc.nextLine());
					
					System.out.print(">회사전화: ");
					newDB.setCompany(sc.nextLine());
					
					
					dbList.add(newDB);
					System.out.println("[등록되었습니다.]");
					System.out.println();
					break;
				case "3": 
					System.out.println("<3.삭제>");
					System.out.print(">번호: ");
					String delNo = sc.nextLine();
					dbList.remove((Integer.parseInt(delNo))-1);
					System.out.println("[삭제되었습니다.]");
					System.out.println();
					break; 
				case "4": 
					System.out.println("<4.검색>");
					System.out.print(">이름: ");
					String searchName = sc.nextLine();
					for(int i=0; i<dbList.size(); i++) {
						if(dbList.get(i).getName().contains(searchName)==true) {
							System.out.println((i+1) +".\t"+ dbList.get(i).getName() +"\t"+ dbList.get(i).getHp() +"\t"+ dbList.get(i).getCompany());
						}
					}
					System.out.println("");
					break;
				case "5": 
					System.out.println("");
					System.out.println("********************************");
					System.out.println("*          감사합니다          *");
					System.out.println("********************************");
					return;
				default : System.out.println("[다시 입력해 주세요.]\n"); 
			}
			
			Writer fw = new FileWriter("./PhoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(PhoneDB db : dbList) {
				String saveStr = db.getName() + "," + db.getHp() + "," + db.getCompany();
				
				bw.write(saveStr);
				bw.newLine();
				bw.flush();
			}
			bw.close();
		}

		br.close();
		sc.close();
	}
}
	
