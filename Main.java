/* Copyright 2021 UPM EDU MY. All rights reserved.
 * Author:  Li Jinghong, Mali Yulong, Li Runkai, Liang Zhaofeng
 * Matric Id: 209231, 209251, 208836, 208802
*/
package application;
	
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Main extends Application {
	public static int totalItem=10; //Adding an item requires a change here
	public static int[] ItemQty=new int[50];
	public static int[] ItemType=new int[50];
	public static Item[] item=new Item[50];
	
	@Override
	public void start(Stage primaryStage) {
		// Item information start
		for(int i=1;i<=3;i++) 	ItemType[i]=1;
		for(int i=4;i<=5;i++) 	ItemType[i]=2;
		for(int i=6;i<=8;i++) 	ItemType[i]=3;
		for(int i=9;i<=10;i++) 	ItemType[i]=4;
		item[1]=new MeatDishes("Fired Chicken",1,1,8);
		item[2]=new MeatDishes("Beef BBQ",1,2,5);
		item[3]=new MeatDishes("Steak",1,3,15);
		item[4]=new Dessert("Cheesecake",2,4,10);
		item[5]=new Dessert("Cream Cake",2,5,8);
		item[6]=new Vegetable("Vegetable BBQ1",3,6,5);
		item[7]=new Vegetable("Vegetable BBQ2",3,7,3);
		item[8]=new Vegetable("Vegetable BBQ3",3,8,5);
		item[9]=new Drink("Coke",4,9,3);
		item[10]=new Drink("Sprite",4,10,3);
		//Item information end
		String restaurant="Delicious Food Restaurant";//restaurant name
		//GUI start
		try {
			GridPane gpane1 = new GridPane();
			gpane1.setPadding(new Insets(50,50,50,50));
			gpane1.setAlignment(Pos.CENTER);
			
			Text title =new Text(restaurant);
			
			//title.setFont(Font.font(null, FontWeight.BOLD, 24));
			title.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
			title.setFill(Color.web("#4c6ef5"));
			gpane1.add(title, 3, 0, 1 ,1);
			
			
			//bt1
			final ToggleButton bt1 = new ToggleButton();
			bt1.getStylesheets().add(this.getClass().getResource("bt1.css").toExternalForm());
			bt1.setMinSize(320, 279); 
			bt1.setMaxSize(320, 279);
		    gpane1.add(bt1, 1, 2, 2, 1);
		    Handler1 bt1a=new Handler1();
			bt1.setOnAction(bt1a);
			//bt2
			final ToggleButton bt2 = new ToggleButton();
			bt2.getStylesheets().add(this.getClass().getResource("bt2.css").toExternalForm());
			bt2.setMinSize(320, 279); 
			bt2.setMaxSize(320, 279);
		    gpane1.add(bt2, 4, 2, 2, 1);
		    Handler2 bt2a=new Handler2();
			bt2.setOnAction(bt2a);
			
			//Placeholders
			Text tttt=new Text(" ");
			gpane1.add(tttt, 2, 3, 1, 1);
			Text ttttt=new Text(" ");
			gpane1.add(ttttt, 2, 4, 1, 1);
			
			//bt3
			final ToggleButton bt3 = new ToggleButton();
			bt3.getStylesheets().add(this.getClass().getResource("bt3.css").toExternalForm());
			bt3.setMinSize(320, 279); 
			bt3.setMaxSize(320, 279);
		    gpane1.add(bt3, 1, 5, 2, 1);
		    Handler3 bt3a=new Handler3();
			bt3.setOnAction(bt3a);
			//bt4
			final ToggleButton bt4 = new ToggleButton();
			bt4.getStylesheets().add(this.getClass().getResource("bt4.css").toExternalForm());
			bt4.setMinSize(320, 279); 
			bt4.setMaxSize(320, 279);
		    gpane1.add(bt4, 4, 5, 2, 1);
		    Handler4 bt4a=new Handler4();
			bt4.setOnAction(bt4a);
			
			//Bill button
			final ToggleButton pay = new ToggleButton("Pay Bill");
			gpane1.add(pay,6,7,2,2);
			HandlerPay paya=new HandlerPay();
			pay.setOnAction(paya);
			
			//Placeholders
			Text tttttt=new Text("  ");
			gpane1.add(tttttt, 8, 7, 1, 1);
			Text ttt=new Text("  ");
			gpane1.add(ttt, 8, 6, 1, 1);
			
			//Cancel button
			final ToggleButton cancel = new ToggleButton("Cancel Bill");
			gpane1.add(cancel,9,7,2,2);
			HandlerCancel cancela=new HandlerCancel();
			cancel.setOnAction(cancela);
			
			//Show()
			Scene scene = new Scene(gpane1,1280,756);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle(restaurant);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		//GUI end
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	//button catch start
	public class Handler1 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			int number=0;
			Object[] options ={ "Fired Chicken", "Beef BBQ","Steak" };  
			int m = JOptionPane.showOptionDialog(null, "Please select", "Delicious Food Restaurant - select",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			String string =JOptionPane.showInputDialog(null, "Please enter the quantity", "Delicious Food Restaurant - Quantity", JOptionPane.QUESTION_MESSAGE);
			try {
				number = Integer.parseInt(string);
				if(number<0) {
					throw new IllegalArgumentException();
				}
			}catch(NumberFormatException error){
				//error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please enter a positive integer as the quantity!", "Delicious Food Restaurant - Error",JOptionPane.ERROR_MESSAGE); 
				System.err.println("Please enter a positive integer as the quantity!");
			}catch(IllegalArgumentException error) {
				//error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Qty cannot be negative!", "Delicious Food Restaurant - Error",JOptionPane.ERROR_MESSAGE); 
				System.err.println("Qty cannot be negative!");
			}
			
			if(m==0) 
				set_ItemQty(1,number);
			if(m==1) 
				set_ItemQty(2,number);
			if(m==2) 
				set_ItemQty(3,number);
		}
	}
	public class Handler2 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			int number=0;
			Object[] options ={ "Cheesecake", "Cream Cake" };  
			int m = JOptionPane.showOptionDialog(null, "Please select", "Delicious Food Restaurant - select",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			String string =JOptionPane.showInputDialog(null, "Please enter the quantity", "Delicious Food Restaurant - Quantity", JOptionPane.QUESTION_MESSAGE);
			try {
				number = Integer.parseInt(string);
				if(number<0) {
					throw new IllegalArgumentException();
				}
			}catch(NumberFormatException error){
				//error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please enter a positive integer as the quantity!", "Delicious Food Restaurant - Error",JOptionPane.ERROR_MESSAGE); 
				System.err.println("Please enter a positive integer as the quantity!");
			}catch(IllegalArgumentException error) {
				//error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Qty cannot be negative!", "Delicious Food Restaurant - Error",JOptionPane.ERROR_MESSAGE); 
				System.err.println("Qty cannot be negative!");
			}
			if(m==0) {
				set_ItemQty(4,number);
			}
			if(m==1) {
				set_ItemQty(5,number);
			}
		}
	}
	public class Handler3 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			int number=0;
			Object[] options ={ "Vegetable BBQ1", "Vegetable BBQ2","Vegetable BBQ3" };  
			int m = JOptionPane.showOptionDialog(null, "Please select", "Delicious Food Restaurant",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			String string =JOptionPane.showInputDialog(null, "Please enter the quantity", "Delicious Food Restaurant - Quantity", JOptionPane.QUESTION_MESSAGE);
			try {
				number = Integer.parseInt(string);
				if(number<0) {
					throw new IllegalArgumentException();
				}
			}catch(NumberFormatException error){
				//error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please enter a positive integer as the quantity!", "Delicious Food Restaurant - Error",JOptionPane.ERROR_MESSAGE); 
				System.err.println("Please enter a positive integer as the quantity!");
			}catch(IllegalArgumentException error) {
				//error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Qty cannot be negative!", "Delicious Food Restaurant - Error",JOptionPane.ERROR_MESSAGE); 
				System.err.println("Qty cannot be negative!");
			}
			if(m==0) {
				set_ItemQty(6,number);
			}
			if(m==1) {
				set_ItemQty(7,number);
			}
			if(m==2) {
				set_ItemQty(8,number);
			}
		}
	}
	public class Handler4 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			int number=0;
			Object[] options ={ "Coke", "Sprite" };  
			int m = JOptionPane.showOptionDialog(null, "Please select", "Delicious Food Restaurant",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			String string =JOptionPane.showInputDialog(null, "Please enter the quantity", "Delicious Food Restaurant - Quantity", JOptionPane.QUESTION_MESSAGE);
			try {
				number = Integer.parseInt(string);
				if(number<0) {
					throw new IllegalArgumentException();
				}
			}catch(NumberFormatException error){
				//error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please enter a positive integer as the quantity!", "Delicious Food Restaurant - Error",JOptionPane.ERROR_MESSAGE); 
				System.err.println("Please enter a positive integer as the quantity!");
			}catch(IllegalArgumentException error) {
				//error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Qty cannot be negative!", "Delicious Food Restaurant - Error",JOptionPane.ERROR_MESSAGE); 
				System.err.println("Qty cannot be negative!");
			}
			if(m==0) {
				set_ItemQty(9,number);
			}
			if(m==1) {
				set_ItemQty(10,number);
			}
		}
	}
	public class HandlerPay implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			if(bill())
				CancelAll();
		}
	}
	public class HandlerCancel implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			CancelAll();
		}
	}
	//button catch end
	
	//ItemQty
	public static void set_ItemQty(int ItemNumber,int Qty) {
		ItemQty[ItemNumber]=Qty;
	}
	public static int get_ItemQty(int ItemNumber) {
		return ItemQty[ItemNumber];
	}
	public static boolean bill() {
		String billinfo=new String("\t\tBill\t\t\n");
		int number=0;
		String tempstring=null;
		double amount=0,amounttemp=1,total=0;
		for(int i=1;i<=totalItem;i++) {
			if(get_ItemQty(i)>0) {
				number++;
				billinfo+=(number+".  ");
				tempstring=item[i].getName();
				amounttemp=item[i].getPrice();
				billinfo+=(tempstring+"    "+get_ItemQty(i)+"     RM "+amounttemp+"\n");
				amount=((Double.valueOf(get_ItemQty(i)))*amounttemp);
				total+=amount;
			}
		}
		if(number==0) {
			JOptionPane.showMessageDialog(null, "The bill is empty, and no items have been selected yet.", "Delicious Food Restaurant - Bill",JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		billinfo+=("\n\nTotal price:     "+total);
		JOptionPane.showMessageDialog(null, billinfo, "Delicious Food Restaurant - Bill",JOptionPane.PLAIN_MESSAGE);
		return true;
	}
	public static boolean CancelAll() {
		for(int i=1;i<=totalItem;i++)set_ItemQty(i,0);
		return true;
	}
}
