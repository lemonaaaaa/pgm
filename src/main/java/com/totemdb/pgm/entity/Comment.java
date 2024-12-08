package com.totemdb.pgm.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private int userID;
    private int targetID;
    private String targetType;
    private String comment;
}
