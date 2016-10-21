package web;
import javax.persistence.*;

@Entity @Table(name="coffee")
public class Coffee {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String name;
	public Character size;
	public Double price;
}
