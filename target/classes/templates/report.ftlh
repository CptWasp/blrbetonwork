<#import "parts/common.ftlh" as c>

<@c.page>

<div class="container">
    <div class="row">
        <div class="col-lg-2 col-md-2 col-sm-2 col-2">
            <#list ad as a>
                <#if a??>
                    <p>${a}</p>
                </#if>
            </#list>
        </div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1">
            <#list prc as pr>
                <#if pr??>
                    <p>${pr} шт.</p>
                </#if>
            </#list>
        </div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1">
            <#list slcnts as slcnt>
                <#if slcnt??>
                    <p>${slcnt}</p>
                </#if>
            </#list>
        </div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1"></div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1"></div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1"></div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1"></div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1"></div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1"></div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1"></div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1"></div>
    </div>
</div>



    </tbody>
</table>

</@c.page>