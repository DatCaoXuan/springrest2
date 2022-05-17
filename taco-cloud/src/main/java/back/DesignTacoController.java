package src.main.java.back;
	

private RestTemplate res= new RestTemplate();
@ModelAttribute 
public void addIngredientsToModel(Model model) {
	List<Ingredient> ingredients =
			Arrays.asList(rest.getForObject("http://localhost:8080/ingredients",Ingredient[].class));
	Type[] types = Ingredient.Type.values();
	for (Type type : types) {
		model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients, type));
	}
}