package com.stopError.MyBoard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String id;
    private String pw;
    private String name;
    private Long age;
    private String work;
    private String comment;
}
