package com.mic.pro.service.admin.domain.model;

import com.mic.pro.common.mybatis.Basic;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News extends Basic {

    private Long id;

    private String newsName;

    private String newsContent;
}
