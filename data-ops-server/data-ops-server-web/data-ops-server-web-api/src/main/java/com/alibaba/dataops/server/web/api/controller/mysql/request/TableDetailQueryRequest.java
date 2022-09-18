package com.alibaba.dataops.server.web.api.controller.mysql.request;

import javax.validation.constraints.NotNull;

import com.alibaba.dataops.server.web.api.controller.data.source.request.DataSourceBaseRequest;

import lombok.Data;

/**
 * @author moji
 * @version ConnectionQueryRequest.java, v 0.1 2022年09月16日 14:23 moji Exp $
 * @date 2022/09/16
 */
@Data
public class TableDetailQueryRequest extends DataSourceBaseRequest {

    /**
     * 表名称
     */
    @NotNull
    private String tableName;

}
