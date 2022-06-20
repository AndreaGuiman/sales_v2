package com.gad.sales_v2.category;

import java.util.List;

public class CategoryConfig {
    public static void createAndSaveCategories(CategoryRepository categoryRepository){
        categoryRepository.saveAll(List.of(
                new Category("Neurologie", getImagePath("Neurologie"),true),
                new Category("Cardiologie", getImagePath("Cardiologie"),true),
                new Category("Consumabile", getImagePath("Consumabile"),true),
                new Category("Ecografie", getImagePath("Ecografie"),true),
                new Category("Ginecologie", getImagePath("Ginecologie"),true),
                new Category("Fizioterapie", getImagePath("Fizioterapie"),true),
                new Category("Kinetoterapie", getImagePath("Kinetoterapie"),true),
                new Category("Pneumologie", getImagePath("Pneumologie"),true),
                new Category("Gastro", getImagePath("Gastro"),true),
                new Category("Instrumentar", getImagePath("Instrumentar"),true)
        ));
    }

    private static String getImagePath(String agentPhoto){
        return String.format(
                "C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\category-photos\\%s.png",
                agentPhoto);
    }
}
