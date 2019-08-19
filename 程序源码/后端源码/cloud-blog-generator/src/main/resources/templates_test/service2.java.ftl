package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

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
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
