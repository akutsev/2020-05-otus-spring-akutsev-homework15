package ru.otus.akutsev.excursions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.akutsev.excursions.dao.AttractionsSqlRepository;
import ru.otus.akutsev.excursions.integration.MessageGateway.ExcursionGateway;
import ru.otus.akutsev.excursions.model.Attraction;
import ru.otus.akutsev.excursions.model.Excursion;

import java.util.List;

@Service
@PropertySource("classpath:application.yaml")
public class ExcursionServiceImpl implements ExcursionService{

    @Autowired
    private  AttractionsSqlRepository dao;
    @Autowired
    private ExcursionGateway excursionGateway;
    @Value("${messages.go_seaside}")
    private  String GO_TO_SEASIDE;
    @Value("${messages.stay_babysiter}")
    private String STAY_WITH_BABYSITER;

    @Override
    public Excursion getExcursion() {
        List<Attraction> attractions = dao.findAll();

        return excursionGateway.getChildExcursion(attractions);
    }

    public Attraction makeExcursionApplicableForChild(Attraction attraction) {
        if (!attraction.getAvailableForChildren()) {
            if (attraction.getCity().getOnSeaside()) {
                attraction.setName(GO_TO_SEASIDE);
            } else {
                attraction.setName(STAY_WITH_BABYSITER);
            }

            attraction.setAvailableForChildren(Boolean.TRUE);
        }

        return attraction;
    }
}
