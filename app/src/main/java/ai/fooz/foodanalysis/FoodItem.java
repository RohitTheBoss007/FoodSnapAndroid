package ai.fooz.foodanalysis;

public class FoodItem {

    private String name, image, calories, carbs, fats, proteins;
    private Long id;

    public FoodItem() {
    }

    public FoodItem(Long id, String name, String image) {
        this.name = name;
        this.image = image;
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCalories() {
        return calories;
    }
    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getCarbs() {
        return carbs;
    }
    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getFats() {
        return fats;
    }
    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getProteins() {
        return proteins;
    }
    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
