package com.godseven.muntour.openapi.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExhibitionResponse {
    private String title;
    private String imageObject;
    private String url;
    private String period;
}