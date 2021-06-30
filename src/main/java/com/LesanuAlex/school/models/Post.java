package com.LesanuAlex.school.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Data
public class Post {

    @Column(name = "userid")
    private Long userId;

    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;

    private String title;

    private String body;



}
