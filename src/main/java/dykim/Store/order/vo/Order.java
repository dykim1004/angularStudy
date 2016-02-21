package dykim.Store.order.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="store_order")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String orderId;
	
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	private boolean giftwrap;
	
	/** 
	 *  targetEntity : 관계를 맺을 엔티티를 정
	 *  cascade      : 현 Entity의 변경에 대해 관계를 맺은 Entity도 변경 전략을 결정
	 *  FetchType    : 관계 엔티티 데이터 읽기 전략 
	 *  mappedBy     : 양방향 관계 설정시 관계의 주체가 되는 쪽에서 정의
	 *  
	 *  FetchType.EAGER : 관계된 엔티티정보를 미리 읽음
	 *  FetchType.LAZY  : 실제요청시 읽
	 * */
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL) 
	private List<OrderProducts> products;
	
	public Order(){}
	
	public Order(String orderId, String name, String street, String city, 
			     String state, String zip, String country, boolean giftwrap){
		this.orderId = orderId;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.giftwrap = giftwrap;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the giftwrap
	 */
	public boolean isGiftwrap() {
		return giftwrap;
	}
	/**
	 * @param giftwrap the giftwrap to set
	 */
	public void setGiftwrap(boolean giftwrap) {
		this.giftwrap = giftwrap;
	}
	
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the products
	 */
	public List<OrderProducts> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<OrderProducts> products) {
		this.products = products;
	}
	
	
	
}
