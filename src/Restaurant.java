import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	List<Menu> menu = new ArrayList<>();
	List<Order> order = new ArrayList<>();

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Restaurant(String menuFileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(menuFileName));
			String line = br.readLine();
			while (line != null) {
				String arr[] = line.split(",");
				Menu item = new Menu(arr[0], arr[1], Integer.parseInt(arr[2]));
				menu.add(item);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addOrder(int item_no, int item_num) {
		order.add(new Order(menu.get(item_no), item_num));
	}

	public void resetOrder() {
		order.clear();
	}

	public int getOrderTotal() {
		int total = 0;
		for (int i = 0; i < order.size(); i++) {
			total += order.get(i).getTotal();
		}
		return total;
	}

	public void printOrder() {
		if (order.size() == 0)
			return;
		for (int i = 0; i < order.size(); i++) {
			System.out.println(
					(i + 1) + "." + order.get(i).getItem().getName() + "\t" + order.get(i).getItem_num() + "份");
		}
	}

	public void printMenu() {
		for (int i = 0; i < menu.size(); i++) {
			Menu item = menu.get(i);
			System.out.println(item.getId() + ")" + item.getName() + "\t單價為" + item.getPrice() + "元");
		}
		System.out.println("0)結算");
	}
}
