package com.petmuc.decision.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Ssn {
    @Column(name = "ssn")
    private Integer ssn;

    private Ssn(Integer ssn) {
        this.ssn = ssn;
    }

    public static Ssn create(final Integer ssn) {
        Objects.requireNonNull(ssn, "Social Security Number should not be null");
        Assert.isTrue(String.valueOf(ssn).toCharArray().length == 9, "The social security number should have 9 characters");
        return new Ssn(ssn);
    }
}