package ru.otus.akutsev.excursions.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.aggregator.MessageGroupProcessor;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.*;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.otus.akutsev.excursions.model.Attraction;
import ru.otus.akutsev.excursions.model.Excursion;

import java.util.stream.Collectors;

@IntegrationComponentScan
@SuppressWarnings({"resource", "Duplicates", "InfiniteLoopStatement"})
//@ComponentScan
@Configuration
@EnableIntegration
public class Config {

    @Bean
    public QueueChannel attractionsChannel() {
        return MessageChannels.queue(10).get();
    }

    @Bean
    public PublishSubscribeChannel excursionChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean (name = PollerMetadata.DEFAULT_POLLER )
    public PollerMetadata poller () {
        return Pollers.fixedRate(100).maxMessagesPerPoll(2).get() ;
    }

    @Bean
    public IntegrationFlow cafeFlow() {
        return IntegrationFlows.from("attractionsChannel")
                .split()
                .handle("excursionServiceImpl", "makeExcursionApplicableForChild")
                .aggregate(a -> a.outputProcessor(
                            attractions -> new Excursion(
                                    attractions.getMessages().stream()
                                            .map(message -> (Attraction)message.getPayload())
                                            .collect(Collectors.toList())
                            )
                        )
                )
                .channel("excursionChannel")
                .get();
    }

}
