package com.cscd.dos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * 公司日常状况Do类
 */
public class CompanyDailyDo {
    /**
     * 主键
     */
    private String uid;
    /**
     *  所属公司uid
     */
    private String companyUid;
    /**
     * 是否爆炸
     * True: 爆炸
     * False: 没爆炸
     */
    private Boolean boom;
    /**
     * 是否发生火灾
     * True: 发生火灾
     * False: 没发发生火灾
     */
    private Boolean fire;
    /**
     * 更新时间
     */
    private LocalDateTime updateDate;
}
