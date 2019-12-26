package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
<#if entityLombokModel>
import lombok.extern.slf4j.Slf4j;
</#if>
 /**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: ${table.comment!}
 * @author: ${author}
 * @date: ${date}
 * @Copyright: Copyright (c) 2019
 */
@Service
<#if entityLombokModel>
 @Slf4j
</#if>
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

}
</#if>
