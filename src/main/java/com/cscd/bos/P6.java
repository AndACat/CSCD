package com.cscd.bos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class P6 {
    private RegionBo regionBo;
    private List<DeviceBo> deviceBoList;
}
