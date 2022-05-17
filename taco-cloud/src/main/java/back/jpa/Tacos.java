package src.main.java.back.jpa;
import lombok.data;
import java.util.List;
@Data 
public class Tacos{
	private String name; 
	private List<String> ingredients;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	private Date createdAt;
	@ManyToMany(targetEntity=Ingredient.class)
	@Size(min=1, message="You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;
	@PrePersist
	void createdAt() {
	this.createdAt = new Date();
	}
}
