package com.petmuc.decision.service;

import com.petmuc.decision.domain.Decision;

import java.time.LocalDate;

public interface DecisionMakerService {

    Decision decide(int ssn, LocalDate birthDate);
}
