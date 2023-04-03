package com.petmuc.decision.messaging;

import com.petmuc.decision.domain.Decision;
import com.petmuc.decision.dto.CustomerDto;
import com.petmuc.decision.messaging.event.CustomerEvent;
import com.petmuc.decision.service.DecisionMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerMessageHandler {
    private final DecisionMakerService decisionMakerService;
//
//    @Bean
//    public Consumer<CustomerEvent.CustomerCreatedEvent> handleCustomerCreated() {
//        return this::handle;
//    }

    private void handle(CustomerEvent.CustomerCreatedEvent customerCreated) {
        log.info("Consuming the User Created event: {}", customerCreated);
        CustomerDto customer = customerCreated.getCustomer();
        decisionMakerService.decide(customer.getSsn(), customer.getBirthDate());
    }

    @Bean
    public Function<CustomerEvent.CustomerCreatedEvent, Decision> processCustomerCreated() {
        return customerCreated -> {
            log.info("Processing (transforming) the event: {}", customerCreated);
            CustomerDto customer = customerCreated.getCustomer();

            if(customer.getFirstName().startsWith("Pet")){
                throw new IllegalStateException("The name supplied is not acceptable");
            }
            Decision decide = decisionMakerService.decide(customer.getSsn(), customer.getBirthDate());
            log.info("Producing  the decision: {}", decide);
            return decide;

        };
    }
}
