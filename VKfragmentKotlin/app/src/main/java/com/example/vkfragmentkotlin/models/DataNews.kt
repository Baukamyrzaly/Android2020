package com.example.vkfragmentkotlin.models

import com.example.vkfragmentkotlin.R

object DataNews {
    //DATABASE FOR LIST OF NEWS
    val newsBIG : MutableList<News> = ArrayList()

    init {
        val imageNames = arrayListOf<String>()
        val timeName = arrayListOf<String>()
        val contentNames = arrayListOf<String>()
        val images = arrayListOf<Int>()
        val contentImages = arrayListOf<Int>()

        imageNames.add("Илон Маск")
        timeName.add("15 минут назад")
        contentNames.add("Tesla — американская компания, производитель электромобилей и решений для хранения электрической энергии. Компания была основана в июле 2003 года Мартином Эберхардом и Марком Тарпеннингом, но сама компания считает Илона Маска, Джеффри Брайана Штробеля и Иэна Райта её сооснователями.")
        images.add(R.drawable.logo1)
        contentImages.add(R.drawable.contentlogo1)

        imageNames.add("Nature")
        timeName.add("47 минут назад")
        contentNames.add("Nature (в переводе с англ. — «Природа») — один из самых старых и авторитетных общенаучных журналов. Публикует исследования, посвящённые широкому кругу вопросов, в основном естественно-научной тематики")
        images.add(R.drawable.naturelogo)
        contentImages.add(R.drawable.naturecontent)

        imageNames.add("Илон маск SPACEX")
        timeName.add("30 минут назад")
        contentNames.add("Space Exploration Technologies Corporation — американская компания, производитель космической техники со штаб-квартирой в городе Хоторн, Калифорния, США. Основана в 2002 году прежним акционером PayPal и CEO Tesla Motors Илоном Маском с целью сократить расходы на полёты в космос и для открытия пути к колонизации Марса.")
        images.add(R.drawable.logo1)
        contentImages.add(R.drawable.spacex)

        imageNames.add("Nature")
        timeName.add("30 минут назад")
        contentNames.add("Вершина находится в Гималаях в хребте Махалангур-Химал, по которому проходит граница Непала и Тибетского автономного района (Китай).\n" +
                "\n" +
                "Эверест имеет форму трёхгранной пирамиды, южный склон более крутой. На южном склоне и рёбрах снег и фирн не удерживаются, вследствие чего они обнажены. Высота Северо-восточного плеча — 8393 м. Высота от подножия до вершины — около 3550 м. Вершина состоит в основном из осадочных отложений.")
        images.add(R.drawable.naturelogo)
        contentImages.add(R.drawable.mountaincontent)

        imageNames.add("Nature")
        timeName.add("25.02.2020")
        contentNames.add("Лучше всего наблюдать сияние в высоких широтах: 67–70°. В Северном полушарии это территория от Аляски до севера Скандинавского полуострова. Иногда сполохи можно увидеть и южнее: при сильной солнечной активности явление наблюдали и в Шотландии, и даже в центральной части России, но это сияние лишь бледное подобие северного.")
        images.add(R.drawable.naturelogo)
        contentImages.add(R.drawable.northernlights)

        imageNames.add("Кино")
        timeName.add("пол года назад")
        contentNames.add("Знаменитый автор детективов Харлан Тромби умирает во время празднования своего 85-летия, в котором участвуют его работники и родственники. На место событий прибывают детективы. Все указывает на убийство, а значит, следователям предстоит вычислить преступника, прячущегося среди гостей.")
        images.add(R.drawable.kinopoisklogo)
        contentImages.add(R.drawable.nozhicontent)

        imageNames.add("Илон Маск HYPERLOOP")
        timeName.add("Год назад")
        contentNames.add("Hyperloóp — проект вакуумного поезда, предложенный в 2013 году американским венчурным предпринимателем Илоном Маском. До конца не реализован. На сегодняшний день построены испытательные полигоны в Хоторне и Лас-Вегасе. Возводится также полигон в Тулузе.")
        images.add(R.drawable.logo1)
        contentImages.add(R.drawable.hyperloop)

        imageNames.add("Илон Маск NEURALINK")
        timeName.add("2 года назад")
        contentNames.add("Neuralink — американская нейротехнологическая компания, основанная Илоном Маском, планирующая заниматься разработкой и производством имплантируемых нейрокомпьютерных интерфейсов. Штаб-квартира компании расположена в Сан-Франциско..")
        images.add(R.drawable.logo1)
        contentImages.add(R.drawable.ai)

        imageNames.add("Nature")
        timeName.add("3 года назад")
        contentNames.add("Tesla — американская компания, производитель электромобилей и решений для хранения электрической энергии. Компания была основана в июле 2003 года Мартином Эберхардом и Марком Тарпеннингом, но сама компания считает Илона Маска, Джеффри Брайана Штробеля и Иэна Райта её сооснователями.")
        images.add(R.drawable.naturelogo)
        contentImages.add(R.drawable.bh)

        imageNames.add("Илон Маск")
        timeName.add("27.03.2015")
        contentNames.add("В силу относительно небольшого расстояния до нашей планеты и природных характеристик, Марс, наряду с Луной является самым вероятным кандидатом на основание колонии людей в обозримом будущем. Путешествие к Марсу с Земли требует наименьших энергетических затрат, если не считать Венеры")
        images.add(R.drawable.logo1)
        contentImages.add(R.drawable.mars)

        for (i in  0..imageNames.size-1){
            val news =  News(
                imageNames.get(i),
                timeName.get(i),
                contentNames.get(i),
                images.get(i),
                contentImages.get(i),
                i,
                i,
                i,
                i,
                0,
                R.drawable.ic_favorite_black
            )
            newsBIG.add(news)
        }
    }
}