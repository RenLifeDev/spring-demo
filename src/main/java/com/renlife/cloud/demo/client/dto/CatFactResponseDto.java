package com.renlife.cloud.demo.client.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CatFactResponseDto {
    private String fact; // TODO переименовать в facts чтобы сломался маппинг
}
