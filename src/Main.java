import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant("menu.txt");

		int item_no = -1;
		while (item_no != 0) {
			//印出菜單
			System.out.println("=========="+"\n歡迎使用點餐系統!"+"\n==========");
			restaurant.printMenu();
			Scanner scn = new Scanner(System.in);
			System.out.print("\n輸入餐點號碼:");
			item_no = scn.nextInt();
			if (item_no == 0) {
				//印出點餐紀錄
				System.out.println();
				restaurant.printOrder();
				System.out.println("\n合計" + restaurant.getOrderTotal() + "元"+"\n=============");
				System.out.println("謝謝光臨!(點擊Enter重新點餐)");
				try {
					System.in.read();
					restaurant.resetOrder();
					item_no = -1;
				} catch (IOException e) {
					e.printStackTrace();
				}
				continue;
			}
			System.out.print("輸入餐點數量:");
			int item_num = scn.nextInt();
			restaurant.addOrder(item_no - 1, item_num);
			System.out.println("----------");
			restaurant.printOrder();
		}
	}
}
