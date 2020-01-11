package com.zju.medical.nir.biz;

import com.zju.medical.common.pojo.Mark;

import java.io.File;
import java.util.List;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
public interface MarkService {
    String doMark(List<Mark> marks, File file);
}
