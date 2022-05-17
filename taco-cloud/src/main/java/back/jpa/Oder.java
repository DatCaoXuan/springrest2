package src.main.java.back.jpa;

public class Oder {

	@Entity
	@Table(name="Taco_Order")
	public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date placedAt;
	...
	@ManyToMany(targetEntity=Taco.class)
	private List<Taco> tacos = new ArrayList<>();
	public void addDesign(Taco design){this.tacos.add(design);}
	@PrePersist
	void placedAt() {
	this.placedAt = new Date();
	}
	}
}
