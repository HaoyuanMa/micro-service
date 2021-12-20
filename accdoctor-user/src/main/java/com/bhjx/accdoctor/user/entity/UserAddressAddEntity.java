package com.bhjx.accdoctor.user.entity;

import lombok.Data;

@Data
public class UserAddressAddEntity {

    private String name;

    private String phone;

    private String province;

    private String city;

    private String region;

    private String detailAddress;

    private int defaultStatus;
}
