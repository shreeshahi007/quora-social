package com.teamtwo.quora.quorasocial.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@Data
public class ProfileFollower {

    @Id
    private String id;
    //user id can be business profile id, public or private profile id
    private String userId;
    private String followerId;
    private boolean isModerator;
    private boolean isApproved;
}

