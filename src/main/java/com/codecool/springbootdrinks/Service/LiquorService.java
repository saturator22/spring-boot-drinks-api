package com.codecool.springbootdrinks.Service;

public class LiquorService {
    public void addData() {
        Liquor liquor = new Liquor("Whisky", "Johnny Walker");
        Liquor liquor2 = new Liquor("Whisky", "Ballantines");
        Liquor liquor1 = new Liquor("Martini", "Bianco");
        Recipe recipe = new Recipe("Whisky Sour", "Whisky 50 ml,\nEggWhite,\nLemon Juice");
        Recipe recipe1 = new Recipe("Vodka Martini", "Martini Bianco 80 ml\nVodka 50 ml\nLemon or Olive");
        Type type = new Type("Short");
        Type type1 = new Type("Tini");

        typeRepository.save(type);
        typeRepository.save(type1);
//		Type type2 = new Type("Long");

        liquor.getRecipeList().add(recipe);
        liquor2.getRecipeList().add(recipe);
        liquor1.getRecipeList().add(recipe1);
        recipe.getLiquorList().add(liquor);
        recipe.getLiquorList().add(liquor2);
        recipe1.getLiquorList().add(liquor1);
        recipe.setType(type);
        recipe1.setType(type1);

        liquorRepository.save(liquor);
        liquorRepository.save(liquor1);
        liquorRepository.save(liquor2);
    }
}
