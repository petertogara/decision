package com.petmuc.decision.service;

import java.time.LocalDate;

public interface DecisionMakerService {

    void decide(int ssn, LocalDate birthDate);
}
