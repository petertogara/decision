package com.petmuc.decision.messaging.event;

import com.petmuc.decision.dto.CustomerDto;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

public interface CustomerEvent extends Serializable {

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public class CustomerCreatedEvent implements CustomerEvent {
        private Long customerId;
        private Instant createdAt;
        private CustomerDto customer;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public class EmailChanged implements CustomerEvent {
        private Long customerId;
        private Instant createdAt;
        private String emailAddress;
    }

}
