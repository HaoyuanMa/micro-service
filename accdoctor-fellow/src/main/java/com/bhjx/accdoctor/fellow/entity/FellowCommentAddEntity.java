package com.bhjx.accdoctor.fellow.entity;

import lombok.Data;

@Data
public class FellowCommentAddEntity {
    private Long orderId;

    private Long fellowId;

    private String fellowName;

    private String userNickName;

    private String content;

    private Integer commentType;
}
