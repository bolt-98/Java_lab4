package lab1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class StreamBasket {
	
	public List<Product> sortNameToHighest(Basket b){
		return b.getPdr().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
	}
	public List<Product> sortNameToLowest(Basket b){
		return b.getPdr().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}
	public int countOfProducts(Basket b) {
		 return (int)b.getPdr().stream().count();
	}
	public  List<Product> timeToFasle(Basket b){
		List<Product> products = b.getPdr().stream().filter(x->x.dateOff()).collect(Collectors.toList());
		return products;
	}
}
