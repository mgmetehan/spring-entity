package com.mgmetehan.postgresqlspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "portal_request_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortalRequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String request;

    @Lob
    private String response;

    private String duration;

    private String path;

    @Column(name = "http_method")
    private String httpMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "result_code")
    private String resultCode;

    @Column(name = "transaction_id")
    private Long transactionId;


}
