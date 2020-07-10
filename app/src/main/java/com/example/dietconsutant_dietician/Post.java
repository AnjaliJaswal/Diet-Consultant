package com.example.dietconsutant_dietician;

public class Post {
   String Food_name;
   String Carbohydrates;
    String Fats;
    String Proteins;
    String Consumed_By;
    String Consumed_For;
     public Post()
     { }

    @Override
    public String toString() {
        return "Post{" +
                "Food_name='" + Food_name + '\'' +
                ", Carbohydrates='" + Carbohydrates + '\'' +
                ", Fats='" + Fats + '\'' +
                ", Proteins='" + Proteins + '\'' +
                ", Consumed_By='" + Consumed_By + '\'' +
                ", Consumed_For='" + Consumed_For + '\'' +
                '}';
    }

    public String getFood_name() {
        return Food_name;
    }

    public void setFood_name(String food_name) {
        Food_name = food_name;
    }

    public String getCarbohydrates() {
        return Carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
        Carbohydrates = carbohydrates;
    }

    public String getFats() {
        return Fats;
    }

    public void setFats(String fats) {
        Fats = fats;
    }

    public String getProteins() {
        return Proteins;
    }

    public void setProteins(String proteins) {
        Proteins = proteins;
    }

    public String getConsumed_By() {
        return Consumed_By;
    }

    public void setConsumed_By(String consumed_By) {
        Consumed_By = consumed_By;
    }

    public String getConsumed_For() {
        return Consumed_For;
    }

    public void setConsumed_For(String consumed_For) {
        Consumed_For = consumed_For;
    }
}
