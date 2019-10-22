package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if swagger2>
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
<#if entityLombokModel>
import lombok.extern.slf4j.Slf4j;
</#if>
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lgcy.blog.cloudblog.common.BaseResponse;

import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: ${table.comment!} 前端控制器
 * @author: ${author}
 * @date: ${date}
 * @Copyright: Copyright (c) 2019
 */
<#if entityLombokModel>

@Slf4j
</#if>
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()
</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    <#if entityLombokModel>
    <#else>
     private Logger logger = LoggerFactory.getLogger(getClass());
    </#if>
    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};
 
   /**
     * 获取数据列表
     */
    <#if swagger2>
        @ApiOperation(value="获取 ${table.comment!} 列表", notes="")
        @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "分页页数", required = true, dataType = "int"),
        @ApiImplicitParam(name = "rows", value = "分页大小", required = true, dataType = "int")
        })
    </#if>
    @RequestMapping("/list", method = RequestMethod.GET)
    public BaseResponse findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex,@RequestParam(name = "rows", defaultValue = "20") int step){
        Page page = new Page(pageIndex,step);
       ${(table.serviceName?substring(1))?uncap_first}.page(page);
        return BaseResponse.success(page);
    }


    /**
     * 获取全部数据
     */
    @RequestMapping("/all", method = RequestMethod.GET)
    public BaseResponse findAll(){
        List<${entity}> models = ${(table.serviceName?substring(1))?uncap_first}.list();
        return BaseResponse.success(models);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find", method = RequestMethod.GET)
    public BaseResponse find(@RequestParam("id") Long id){
        ${entity} ${entity} = ${(table.serviceName?substring(1))?uncap_first}.getById(id);
        if(${entity}==null){
            return BaseResponse.error("尚未查询到此ID");
        }
        return BaseResponse.success(${entity});
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse addItem(@RequestBody ${entity} ${entity}){
        boolean isOk = ${(table.serviceName?substring(1))?uncap_first}.save(${entity});
        if(isOk){
            return BaseResponse.success("数据添加成功！");
        }
        return BaseResponse.error("数据添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateItem(@RequestBody ${entity} ${entity}){
        boolean isOk = ${(table.serviceName?substring(1))?uncap_first}.updateById(${entity});
        if(isOk){
            return BaseResponse.success("数据更改成功！");
        }
        return BaseResponse.error("数据更改失败");
     }


    /**
     * 删除数据
     */
    @RequestMapping("/del", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse deleteItems(@RequestParam("ids") List<Long> ids){
        boolean isOk = ${(table.serviceName?substring(1))?uncap_first}.removeByIds(ids);
        if(isOk){
            return BaseResponse.success("数据删除成功！");
        }
        return BaseResponse.error("数据删除失败");
        }
    }
 


</#if>