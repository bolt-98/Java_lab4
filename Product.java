package lab1;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Product implements Comparable<Product>{

	private double price;
	private int id_num;
	private String name;
	private  LocalDate timeToFalse;
	private final static String price_rg = "([0-9]){1,}([\\.]){1}([0-9]){1,}";
	private final static String name_rg = "([a-zA-Z]){1,15}";
	public Product () {
		price = 0.0;
		id_num = 0;
		name = "";
		timeToFalse = null;
	}
	
	
	public  Product(String n, double c, int a, LocalDate t) {
		name = n;
		price = c;
		id_num = a;
		timeToFalse = t;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId_num() {
		return id_num;
	}
	public void setId_num(int id_num) {
		this.id_num = id_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getTimeToFalse() {
		return timeToFalse;
	}
	public void setTimeToFalse(LocalDate timeToFalse) {
		this.timeToFalse = timeToFalse;
	}
	@Override
	public int compareTo(Product p) {
		if(this.name.charAt(0)>p.name.charAt(0)) {
			return 1;
		}
		else if(this.name.charAt(0)<p.name.charAt(0)) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product d = (Product) obj;
		return this.name.equals(d.name);
	}
	
	public boolean regular_pr() {
		Pattern pt = Pattern.compile(price_rg);
		Matcher m = pt.matcher(Double.toString(this.price));
		return m.matches();
	}
	public boolean regular_nm() {
		Pattern pt = Pattern.compile(name_rg);
		Matcher m = pt.matcher(this.name);
		return m.matches();
	}
	public  boolean dateOff() {
		return (LocalDate.now().compareTo(timeToFalse)==-1) ? true :  false;
		
	}
	 public static void main(String[] args) {
		 
			
	 }
	 /**регулярка для даты для цены и имени*/
	 /*для цены проверка на точку*/
	 /*для имени нормальные ли симвлы*/
}
