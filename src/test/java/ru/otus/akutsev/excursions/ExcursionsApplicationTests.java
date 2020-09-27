package ru.otus.akutsev.excursions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.akutsev.excursions.model.Attraction;
import ru.otus.akutsev.excursions.model.City;
import ru.otus.akutsev.excursions.model.Excursion;
import ru.otus.akutsev.excursions.service.ExcursionService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Тест сформированной детской экскурсии по Европе")
@SpringBootTest
class ExcursionsApplicationTests {
    @Autowired
    private ExcursionService excursionService;

    @Value("${messages.go_seaside}")
    private  String GO_TO_SEASIDE;
    @Value("${messages.stay_babysiter}")
    private String STAY_WITH_BABYSITER;

    @DisplayName("Замена недетских достопримечательностей")
    @Test
    void getChildExcursion() {
        City paris = new City(1, "Paris", false);
        City monaco = new City(2, "Monaco", true);
        City amsterdam = new City(3, "Amsterdam", false);
        City barcelona = new City(4, "Barcelona", true);

        Attraction attraction1 = new Attraction(1, "Eiffel Tower", paris, true);
        Attraction attraction2 = new Attraction(2, STAY_WITH_BABYSITER, paris, true);
        Attraction attraction3 = new Attraction(3, GO_TO_SEASIDE, monaco, true);
        Attraction attraction4 = new Attraction(4, STAY_WITH_BABYSITER, amsterdam, true);
        Attraction attraction5 = new Attraction(5, "van Gogh museum", amsterdam, true);
        Attraction attraction6 = new Attraction(6, GO_TO_SEASIDE, barcelona, true);
        Attraction attraction7 = new Attraction(7, "La Rambla", barcelona, true);

        List<Attraction> expectedAttractions = List.of(
                attraction1, attraction2, attraction3, attraction4, attraction5, attraction6, attraction7);

        Excursion actualExcursion = excursionService.getExcursion();

        assertArrayEquals(
                expectedAttractions.stream()
                    .map(Attraction::toString)
                    .toArray()
                , actualExcursion.getAttractions().stream()
                    .map(Attraction::toString)
                    .toArray());
    }
}
