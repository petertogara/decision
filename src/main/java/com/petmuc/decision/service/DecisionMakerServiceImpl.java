package com.petmuc.decision.service;

import com.petmuc.decision.domain.Decision;
import com.petmuc.decision.domain.Ssn;
import com.petmuc.decision.repository.DecisionRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class DecisionMakerServiceImpl implements DecisionMakerService {
    private final DecisionRepository repository;

    @Override
    public void decide(int ssn, LocalDate birthDate) {
        Decision decide = Decision.decide(Ssn.create(ssn), birthDate);
        Decision decisionCreated = repository.save(decide);
        log.info("Decision made....: {}", decisionCreated);
    }
}
