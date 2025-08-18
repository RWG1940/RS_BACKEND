package com.rs.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaunchCodeRequest {
    private String operator_userid;
    private SingleChat single_chat;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SingleChat {
        private String userid;
    }
}
