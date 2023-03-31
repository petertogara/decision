package com.petmuc.decision.messaging;

import com.petmuc.decision.dto.CustomerDto;
import com.petmuc.decision.messaging.event.CustomerEvent;
import com.petmuc.decision.service.DecisionMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerMessageHandler {
    private final DecisionMakerService decisionMakerService;

    @Bean
    public Consumer<CustomerEvent.CustomerCreatedEvent> handleCustomerCreated() {
        return this::handle;
    }

    private void handle(CustomerEvent.CustomerCreatedEvent customerCreated) {
        log.info("Consuming the event: {}", customerCreated);
        CustomerDto customer = customerCreated.getCustomer();
        decisionMakerService.decide(customer.getSsn(), customer.getBirthDate());
    }
}
