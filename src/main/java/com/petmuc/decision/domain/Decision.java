package com.petmuc.decision.domain;

import com.petmuc.decision.domain.emuns.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Decision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private State state;

    private Ssn ssn;

    private Decision(State state, Ssn ssn) {
        this.state = state;
        this.ssn = ssn;
    }

    public static Decision decide(Ssn ssn, LocalDate birthDate) {
        Period creditLimitDuration = Period.ofYears(40);
        var maximumCustomerYears = 70;

        LocalDate maximumAllowedAge = LocalDate.now().plus(creditLimitDuration);

        long customerYearsInTheEndOfCredit = ChronoUnit.YEARS.between(birthDate, maximumAllowedAge);

        if (customerYearsInTheEndOfCredit > maximumCustomerYears) {
            return new Decision(State.REJECTED, ssn);
        } else if (ssn.getSsn() % 2 == 0) {
            return new Decision(State.APPROVED, ssn);
        }
        return new Decision(State.PRE_APPROVED, ssn);
    }
}
