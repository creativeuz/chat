package com.payway.demochat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "staff")
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "closed")
    private boolean isClosed;

    @OneToMany(mappedBy = "room")
    private List<Message> messages;

    public Room(Staff staff, Customer customer, boolean isClosed) {
        this.staff = staff;
        this.customer = customer;
        this.isClosed = isClosed;
    }
}
