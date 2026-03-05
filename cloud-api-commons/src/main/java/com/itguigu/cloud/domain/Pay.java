package com.itguigu.cloud.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 支付交易表
 * @TableName t_pay
 */
@TableName(value ="t_pay")
@Data
@Schema(title = "支付交易表实体类")
public class Pay {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    @Schema(title = "主键")
    private Integer id;

    /**
     * 支付流水号
     */
    @Schema(title = "支付流水号")
    private String payNo;

    /**
     * 订单流水号
     */
    @Schema(title = "订单流水号")
    private String orderNo;

    /**
     * 用户账号ID
     */
    @Schema(title = "用户账号ID")
    private Integer userId;

    /**
     * 交易金额
     */
    @Schema(title = "交易金额")
    private BigDecimal amount;

    /**
     * 删除标志，默认0不删除，1删除
     */
    @Schema(title = "删除标志")
    private Integer deleted;

    /**
     * 创建时间
     */
    @Schema(title = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Schema(title = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;
}