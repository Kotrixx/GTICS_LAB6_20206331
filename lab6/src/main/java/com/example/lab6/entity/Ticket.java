package com.example.lab6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ticket", schema = "gticslab6")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site siteID;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "OpenedDate")
    private Instant openedDate;

    @Column(name = "ClosedDate")
    private Instant closedDate;

}