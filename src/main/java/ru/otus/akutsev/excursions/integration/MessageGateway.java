package ru.otus.akutsev.excursions.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.akutsev.excursions.model.Attraction;
import ru.otus.akutsev.excursions.model.Excursion;

import java.util.Collection;

public class MessageGateway {

    @MessagingGateway
    public interface ExcursionGateway {

        @Gateway(requestChannel = "attractionsChannel", replyChannel = "excursionChannel")
        Excursion getChildExcursion(Collection<Attraction> attractions);

    }

}
