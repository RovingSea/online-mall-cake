package com.wu.auth.controller.common;

import com.wu.common.domain.Type;
import com.wu.common.service.goods.TypeService;
import com.wu.common.utility.http.RestResponse;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Haixin Wu
 * @date 2021/12/20 21:02
 * @since 1.0
 */
@RestController
@RequestMapping("omc/api/common/type")
@CrossOrigin
public class CommonTypeController {
    @DubboReference
    private TypeService typeService;

    @GetMapping("/all")
    @Transactional(rollbackFor = Exception.class)
    public RestResponse<List<Type>> getAll(){
        return RestResponse.ok(typeService.selectAll());
    }
}

