package com.cscd.bos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Po3 {
    private RegionBo regionBo;
    private List<Poo1> boomCountList = new ArrayList<>();

    private Integer allBoomCount = 0;

    public Po3(RegionBo regionBo) {
        this.regionBo = regionBo;
    }
    public void add(LocalDate date, Integer boomCount){
        boomCountList.add(new Poo1(date, boomCount));
        allBoomCount += boomCount;
    }
}
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Poo1{
    private LocalDate date;
    private Integer boomCount;
}
