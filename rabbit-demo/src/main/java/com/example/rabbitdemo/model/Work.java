package com.example.rabbitdemo.model;

import lombok.Data;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yuanjie
 * @date 2018/11/24 10:56
 */
@Data
public class Work {
    @Id
    private Integer id;
    private String workName;
    private String place;
    private Date startTime;
    private Date endTime;
    private String detail;
}
