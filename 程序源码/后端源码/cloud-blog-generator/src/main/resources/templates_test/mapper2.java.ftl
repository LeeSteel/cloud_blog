package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};


 /**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: ${table.comment!}
 * @author: ${author}
 * @date: ${date}
 * @Copyright: Copyright (c) 2019
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
