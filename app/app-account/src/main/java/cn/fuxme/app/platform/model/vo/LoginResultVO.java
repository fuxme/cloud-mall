package cn.fuxme.app.platform.model.vo;

import lombok.Data;

/**
 * @desc:
 * @author: wuhao
 * @date: 2022/5/24
 **/
@Data
public class LoginResultVO {

    private Boolean success;

    private String tokenName;

    private String tokenValue;
}
