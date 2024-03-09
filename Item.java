/* Copyright 2021 UPM EDU MY. All rights reserved.
 * Author:  Li Jinghong, Mali Yulong, Li Runkai, Liang Zhaofeng
 * Matric Id: 209231, 209251, 208836, 208802
*/
package application;

public class Item {

	protected String name;
	protected int type;
	protected int itemNumber;
	protected double price;

	public Item() {
	}
	public Item(String name,int type,int itemNumber, double price) {
		this.name = name;
		this.type = type;
		this.itemNumber = itemNumber;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

}