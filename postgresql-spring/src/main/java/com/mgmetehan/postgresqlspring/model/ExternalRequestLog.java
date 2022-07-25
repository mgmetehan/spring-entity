package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "external_request_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalRequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String request;

    @Lob
    private String response;

    private String duration;

    @Column(name = "result_code")
    private String resultCode;

    private String path;

    @Column(name = "http_method")
    private String httpMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_user_id")
    private ApplicationUser applicationUser;

    @Column(name = "transaction_id")
    private Long transactionId;


}
