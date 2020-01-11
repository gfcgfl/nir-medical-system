package com.zju.medical.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mark {
    private int markId;
    private String markTime;
    private String markName;
}
