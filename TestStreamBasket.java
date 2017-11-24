package lab1;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import java.time.LocalDate;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class TestStreamBasket {
	Product Product_0,Product_1,Product_2,Product_3;
	Basket B;
	ArrayList<Product> k = new ArrayList<Product>();
	@BeforeTest
	void setup() {
		Product_0 = new Product("Chess", 23.5, 256, LocalDate.of(2015, 01, 15));
		Product_1 = new Product("Apple", 45.0, 3587, LocalDate.of(2018, 07, 17));
		Product_2 = new Product("Milk", 115.0, 8926, LocalDate.of(2010, 02, 14));
		Product_3 = new Product("Fish", 27.5, 21856, LocalDate.of(2017, 01, 01));
		k.add(Product_0);
		k.add(Product_1);
		k.add(Product_2);
		k.add(Product_3);
		B = new Basket(k, 2658, "Bogdan");
	}
	@DataProvider
	public Object[][] testForNaturalSortProvider() {
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(Product_1);
		products.add(Product_0);
		products.add(Product_3);
		products.add(Product_2);
		return new Object[][] { { B, products} };
	}
	
	@Test(dataProvider = "testForNaturalSortProvider")
	public void testForNaturalSort(Basket b, ArrayList<Product> p) {
		Assert.assertEquals(new StreamBasket().sortNameToHighest(b) ,p);
	}
	@DataProvider
	public Object[][] testCountPdr() {
		return new Object[][] { { B, 4 } };
	}
	@Test(dataProvider = "testCountPdr")
	public void testForCount(Basket b,int a) {
		Assert.assertEquals(new StreamBasket().countOfProducts(b), a);
	}
	@DataProvider
	public Object[][] testForReverseSortProvider() {
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(Product_2);
		products.add(Product_3);
		products.add(Product_0);
		products.add(Product_1);
		return new Object[][] { { B, products} };
	}
	
	@Test(dataProvider = "testForReverseSortProvider")
	public void testForReverseSort(Basket b, ArrayList<Product> p) {
		Assert.assertEquals(new StreamBasket().sortNameToLowest(b) ,p);
	}
	@DataProvider
	public Object[][]testTime(){
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(Product_1);
		return new Object[][] {{B, products}};
	}
	@Test(dataProvider = "testTime")
	public void testForTime(Basket b, ArrayList<Product> p) {
		Assert.assertEquals(new StreamBasket().timeToFasle(b), p);
	}
	
}
