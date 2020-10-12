package com.wallet.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {

    private T data;
    private List<String> errors;
}
