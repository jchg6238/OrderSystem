
public class Order {
	Menu item;
	int item_num;

	public Order(Menu item, int item_num) {
		this.item = item;
		this.item_num = item_num;
	}

	public Menu getItem() {
		return item;
	}

	public void setItem(Menu item) {
		this.item = item;
	}

	public int getItem_num() {
		return item_num;
	}

	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getTotal() {
		return item.getPrice()*item_num;
	}
}
