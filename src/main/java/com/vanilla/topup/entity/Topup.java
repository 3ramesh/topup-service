package com.vanilla.topup.entity;

import com.vanilla.topup.constant.enums.TopupStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "topups")
@Getter
@Setter
public class Topup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromAccount;

    private String toAccount;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TopupStatus status;

    private String failureReason;

//    public static Topup initiated(String from, String to, BigDecimal amount) {
//        return Topup.builder()
//                .fromAccount(from)
//                .toAccount(to)
//                .amount(amount)
//                .status(TopupStatus.INITIATED)
//                .build();
//    }

    public void markSuccess() {
        this.status = TopupStatus.SUCCESS;
        this.failureReason = null;
    }

    public void markFailed(String reason) {
        this.status = TopupStatus.FAILED;
        this.failureReason = reason;
    }
}
