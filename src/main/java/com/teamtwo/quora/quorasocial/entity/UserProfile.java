package com.teamtwo.quora.quorasocial.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class UserProfile {

    private String userEmail;
    @Id
    private String userId;
    private String userName;
    private String profilePicUrl;
    private List<String> userCategory;
    private String userDescription;
    private List<String> userFollowers;
    private List<String> userFollowing;
    private int userScore;
    private int mode;//0-public 1-private


}
