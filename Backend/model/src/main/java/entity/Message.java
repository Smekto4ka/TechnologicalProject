package entity;

import data.MessageType;

import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Message {
    @Id
    private Long id;
    @OneToOne
    private User sender;

    private String message;
}
