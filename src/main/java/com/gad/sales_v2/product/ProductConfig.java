package com.gad.sales_v2.product;

import com.gad.sales_v2.category.CategoryRepository;

import java.util.List;

public class ProductConfig {
    public static void createAndSaveProductsWithCategory(ProductRepository productService, CategoryRepository categoryService){
        List<Product> products = List.of(
                new Product(
                        getImagePath("Casca EEG"),
                        "Casca EEG",
                        520.0,
                        163,
                        "Sistem 21 electrozi de captare, auriculari si GND",
                        true,
                        categoryService.getByName("Neurologie")),
                new Product(getImagePath("Electromiografe"),
                        "Electromiografe",
                        6331.0,
                        10,
                        "97% dintre testele EMG sunt realizate folosindu-se doar doua canale.",
                        true,
                        categoryService.getByName("Neurologie")),
                new Product(getImagePath("Accesorii EEG"),
                        "Accesorii EEG",
                        18.0,
                        112,
                        "Electrod. Diametru: 8mm, Lungime cablu: 5m",
                        true,
                        categoryService.getByName("Neurologie")),
                new Product(getImagePath("Accesorii EMG"),
                        "Accesorii EMG",
                        37.0,
                        160,
                        "Adaptop tip cleste. Lungime cablu: 20cm",
                        true,
                        categoryService.getByName("Neurologie")),
                new Product(getImagePath("Holter ECG"),
                        "Holter ECG",
                        3000.0,
                        12,
                        "Inregistrarea frecventei cardiace, a traseelor ECG pe 2 canale, a elevatiei, depresiei si pantei segmentului ST",
                        true,
                        categoryService.getByName("Cardiologie")),
                new Product(getImagePath("Holter TA"),
                        "Holter TA",
                        290.0,
                        92,
                        "Metoda de masurare: oscilometrica",
                        true,
                        categoryService.getByName("Cardiologie")),
                new Product(getImagePath("Accesorii Holter ECG"),
                        "Accesorii Holter ECG",
                        30.0,
                        120,
                        "Cablu holter TLC 10 fire",
                        true,
                        categoryService.getByName("Cardiologie")),
                new Product(getImagePath("Cablu alimentare MESI ECG"),
                        "Cablu alimentare MESI ECG",
                        19.0,
                        40,
                        "Lungime: 1 metru",
                        true,
                        categoryService.getByName("Cardiologie")),
                new Product(getImagePath("Accesorii MESI ECG"),
                        "Accesorii MESI ECG",
                        100.0,
                        120,
                        "",
                        true,
                        categoryService.getByName("Cardiologie")),
                new Product(getImagePath("Gel ECG"),
                        "Gel ECG",
                        4.43,
                        120,
                        "Spray pentru toate aplicatiile ECG",
                        true,
                        categoryService.getByName("Consumabile")),
                new Product(getImagePath("Hartie ECG"),
                        "Hartie ECG",
                        5.21,
                        106,
                        "Hartie rola. Dimensiuni: 210mm * 25mm",
                        true,
                        categoryService.getByName("Consumabile")),
                new Product(getImagePath("Hartie Monitoare FV"),
                        "Hartie Monitoare FV",
                        0.79,
                        113,
                        "Hartie necaroiata. Dimensiuni: 57mm * 25mm",
                        true,
                        categoryService.getByName("Consumabile")),
                new Product(getImagePath("Hartie CTG"),
                        "Hartie CTG",
                        5.23,
                        112,
                        "Hartie caroiaj verde. Dimensiuni 215mm * 23mm",
                        true,
                        categoryService.getByName("Consumabile")),
                new Product(getImagePath("Gel ecografie"),
                        "Gel ecografie",
                        3.12,
                        240,
                        "Hipoalergic. Nu irita pielea",
                        true,
                        categoryService.getByName("Consumabile")),
                new Product(getImagePath("Hartie videoprinter"),
                        "Hartie videoprinter",
                        40.0,
                        10,
                        "Dimensiuni: 110mm * 22mm",
                        true,
                        categoryService.getByName("Consumabile")),
                new Product(getImagePath("Gel si crema fizioterapie"),
                        "Gel si crema fizioterapie",
                        600,
                        320,
                        "",
                        true,
                        categoryService.getByName("Consumabile")),
                 new Product(getImagePath("Pedala freeze"),
                        "Pedala freeze",
                        40.43,
                        168,
                        "Rezistenta si practica\n" +
                                "Suprafata anti-alunecare\n" +
                                "Posibilitate actionare freeze si print",
                        true,
                        categoryService.getByName("Ecografie")),
                new Product(getImagePath("Extensie cu 3 porturi"),
                        "Extensie cu 3 porturi",
                        4000,
                        200,
                        "",
                        true,
                        categoryService.getByName("Ecografie")),
                new Product(getImagePath("Cablu ECG ecografe"),
                        "Cablu ECG ecografe",
                        250,
                        1000,
                        "",
                        true,
                        categoryService.getByName("Ecografie")),
                new Product(getImagePath("Ac anestezie de SonoTap single"),
                        "Ac anestezie de SonoTap single",
                        230, 45,
                        "Varful fatetat, slefuit, cu 2 unghiuri de inclinare imbunatateste vizibilitatea varfului acului la ultrasunete.\n" +
                                "\n" +
                                "- Reflectoarele Cornerstone pe primii 20 mm, 360 grade",
                        true,
                        categoryService.getByName("Ecografie")),
                new Product(getImagePath("Masa ginecologica mecanica"),
                        "Masa ginecologica mecanica",
                        2100, 25,
                        "\n" +
                                "Descriere\n" +
                                "Cadru din otel cromat\n" +
                                "Spatar si suport pentru picioare reglabile\n" +
                                "Tapiterie din piele ecologica\n" +
                                "Suporti de picioare reglabili pe inaltime\n" +
                                "Livrat cu bazin din otel inoxidabil diam. 32 cm \n" +
                                "Dimensiuni:180x61x78cm\n" +
                                "\n" +
                                "Saltea din poliuretan capitonata\n" +
                                "\n" +
                                "Accesorii: bazin din otel inoxidabil, 2 x suport pentru picioare, 2 x cleme prindere suporti",
                        true,
                        categoryService.getByName("Ginecologie")),
                new Product(getImagePath("Masa ginecologica hidraulica"),
                        "Masa ginecologica hidraulica",
                        2500, 20,
                        "Sectiunile pentru spate si picioare reglabile \n" +
                                "Inaltime reglabila hidraulic prin cele 2 pedale dispuse pe laterale \n" +
                                "Inaltime reglabila: 48-87cm \n" +
                                "Cadrul metalic inferior acoperit cu ABS \n" +
                                "Tavita din otel inoxidabil \n" +
                                "Suporti pentru picioare",
                        true,
                        categoryService.getByName("Ginecologie")),
                new Product(getImagePath("Sonda US FC-700"),
                        "Sonda US FC-700",
                        1399, 45,
                        "\n" +
                                "Descriere\n" +
                                "Pentru masurarea ritmului cardiac al fatului \n" +
                                "Compatibila cu monitorul fetal FC-700",
                        true,
                        categoryService.getByName("Ginecologie")),
                new Product(getImagePath("Sonda TOCO FC-1400"),
                        "Sonda TOCO FC-1400",
                        1880, 15,
                        "Rezistenta la apa\n" +
                                "Pentru masurare contractie uterina.\n" +
                                "Compatibila cu monitorul fetal FC-1400",
                        true,
                        categoryService.getByName("Ginecologie")),
                new Product(getImagePath("Sonda TOCO FC-700"),
                        "Sonda TOCO FC-700",
                        1560, 25,
                        "Rezistenta la apa\n" +
                                "Pentru masurare contractie uterina.\n" +
                                "Compatibila cu monitorul fetal FC-700",
                        true,
                        categoryService.getByName("Ginecologie")),
                new Product(getImagePath("Colposcop_AC_1100"),
                        "Colposcop_AC_1100",
                        6200, 12,
                        "AC-1110 cu LED-uri 5.9V/5W \n" +
                                "Nivel de iluminare: 15.000 lux\n" +
                                "Dioptrii ajustabile individual 12.5x",
                        true,
                        categoryService.getByName("Ginecologie")),
                new Product(getImagePath("Reductor pentru oxigen"),
                        "Reductor pentru oxigen",
                        1200, 40,
                        "",
                        true,
                        categoryService.getByName("Fizioterapie")),
                new Product(getImagePath("Duza pentru ajustare"),
                        "Duza pentru ajustare",
                        89, 1200,
                        "\n" +
                                "Descriere\n" +
                                "Consultati manualul de utilizare; \n" +
                                "Conectati strans tubul in iesirea de oxigen; \n" +
                                "Nu folositi lubrifianti de origine vegetala sau animala la conectarea la tubul de oxigen; ",
                        true,
                        categoryService.getByName("Fizioterapie")),
                new Product(getImagePath("Specul pentru colonhidroterapie"),
                        "Specul pentru colonhidroterapie",
                        20, 2012,
                        "Furtun striat si furtun apa curata 1,20 m\n" +
                                "Ambalate in cutie cate 60 buc",
                        true,
                        categoryService.getByName("Fizioterapie")),
                new Product(getImagePath("Specul pentru colonhidroterapie pediatric"),
                        "Specul pentru colonhidroterapie pediatric",
                        20, 1280,
                        "Furtun striat;\n" +
                                "Furtun pentru apa curata 1,50 m;\n" +
                                "Ambalate in cutie cate 60 buc",
                        true,
                        categoryService.getByName("Fizioterapie")),
        new Product(getImagePath("Ham pentru transfer"),
                "Ham pentru transfer",
                1480, 60,
                "Realizat din nylon.\n" +
                        "Are suport pentru sustinerea picioarelor.\n" +
                        "Lavabil la o temperatura de max 60 grade C. ",
                true,
                categoryService.getByName("Kinetoterapie")),
        new Product(getImagePath("Targa pliabila"),
                "Targa pliabila",
                20, 3700,
                "Prevazut cu clipsuri de prindere rapida \n" +
                        "Dimensiuni: 65 x 180 cm \n" +
                        "Capacitate sustinere: 160 Kg",
                true,
                categoryService.getByName("Kinetoterapie")),
        new Product(getImagePath("Masa rabatabila"),
                "Masa rabatabila",
                1520, 890,
                "\n" +
                        "Descriere\n" +
                        "Recomandata pentru sustinerea confortabila a mainilor.\n" +
                        "Se poate regla pe inaltime si distanta fata de canapea.\n" +
                        "Dimensiuni: 70 x 56 cm",
                true,
                categoryService.getByName("Kinetoterapie")),
        new Product(getImagePath("Centura pentru abdomen"),
                "Centura pentru abdomen",
                220, 1600,
                "",
                true,
                categoryService.getByName("Kinetoterapie")),
                new Product(getImagePath("Valva de biopsie"),
                        "Valva de biopsie",
                        130, 1400,
                        "",
                        true,
                        categoryService.getByName("Pneumologie")),
                new Product(getImagePath("Valva de aspiratie"),
                        "Valva de aspiratie",
                        220, 1200,
                        "",
                        true,
                        categoryService.getByName("Pneumologie")),
                new Product(getImagePath("Suport mobil pentru sistem de endoscopie"),
                        "Suport mobil pentru sistem de endoscopie",
                        220, 1600,
                        "\n" +
                                "Descriere\n" +
                                "-Inaltime: 1,5 m\n" +
                                "\n" +
                                "-Suporturi pentru 2 endoscoape.",
                        true,
                        categoryService.getByName("Pneumologie")),
                new Product(getImagePath("Set 8 duze"),
                        "Set 8 duze",
                        2150, 48,
                        "Descriere\n" +
                                "1.Pentru seringi si canule cu conector RECORD; \n" +
                                "2.Pentru pipete; \n" +
                                "3.Pentru catetere, ventile, supape si endoscoape;",
                        true,
                        categoryService.getByName("Gastro")),
                new Product(getImagePath("Maner anse"),
                        "Maner anse",
                        430, 60,
                        "Lungime: 100 mm\n" +
                                "Inel rotativ cu sistem de blocare\n" +
                                "Autoclavabil: 136°C\n" +
                                "Compatibil cu electrocauterele, pin HF 3 m.",
                        true,
                        categoryService.getByName("Gastro")),
                new Product(getImagePath("Sistem de lentile Zoom"),
                        "Sistem de lentile Zoom",
                        340, 70,
                        "-Datorita setului de lentile parfocale, sistemul  poate sa mentina focalizarea atunci cand utilizatorul modifica distanta focala;\n" +
                                "-Distanta focala: 16-32 mm cu Wide Angle.",
                        true,
                        categoryService.getByName("Gastro"))
        );

        productService.saveAll(products);
    }

    private static String getImagePath(String productName){
        return String.format(
                "C:\\Users\\Andrea\\Desktop\\Licenta\\resources\\product-images\\%s.png",
                productName);
    }
}
