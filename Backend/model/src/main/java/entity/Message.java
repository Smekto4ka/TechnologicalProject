package entity;

import data.MessageType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Setter
@Getter
@Entity
public class Message {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private User sender;

    private String message;
}
