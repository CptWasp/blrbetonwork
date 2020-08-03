<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<#import "parts/login.ftlh" as l>

<@c.page>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">blrBlog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/warehouse">Склад</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/production">Изготовление</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/sales">Продажа</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Отчеты
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Отчет по диапазонам</a>
                    <a class="dropdown-item" href="/report">Отчет за все время</a>
                </div>
            </li>
            <#if isAdmin>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown0" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Права админа
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown0">
                    <a class="dropdown-item" href="/user">Список пользователей</a>
                    <a class="dropdown-item" href="/adminproductions">Добавить новые рецептуры</a>
                    <a class="dropdown-item" href="/pricesettings">Добавить новые ценовые записи</a>
                </div>
            </li>
        </#if>
        </ul>


        <div class="navbar-text mr-3">${name}</div>
        <div class="navbar-text mr-3"><@l.logout /></div>

    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="py-2 px-3 col-lg-2 col-md-2 col-sm-2 col-2 dur">
            <h6>Номенклатура</h6></div>
        <div class="py-2 px-3 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <h6>Произведено за все время</h6></div>
        <div class="py-2 px-3 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <h6>Продано за все время</h6></div>
        <div class="py-2 px-3 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <h6>Использовано бетона</h6></div>
        <div class="py-2 px-3 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <h6>Использовано арматуры</h6></div>
        <div class="py-2 px-3 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <h6>Использовано проволоки</h6></div>
        <div class="py-2 px-3 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <h6>Использовано сетки</h6></div>
        <div class="py-2 px-3 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <h6>Затраты на материалы</h6></div>
        <div class="py-2 px-3 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <h6>Прибыль за все время</h6></div>
    </div>
    <div class="row">
        <div class="col-lg-2 col-md-2 col-sm-2 col-2">
            <#list ad as a>
                <#if a??>
                    <p>${a}</p>
                </#if>
            </#list>
        </div>
        <div class="pr-2 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <#list prc as pr>
                <#if pr??>
                    <p>${pr} шт.</p>
                </#if>
            </#list>
        </div>
        <div class="pr-2 col-lg-1 col-md-1 col-sm-1 col-1 dur">

            <#list slcnts as slcnt>
                <#if slcnt??>
                    <p>${slcnt} шт.</p>
                </#if>
            </#list>
        </div>
        <div class="pr-2 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <#list btnwghts as btnwght>
                <#if btnwght??>
                    <p>${btnwght} кг</p>
                </#if>
            </#list>
        </div>
        <div class="pr-2 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <#list armwghts as armwght>
                <#if armwght??>
                    <p>${armwght} кг</p>
                </#if>
            </#list>
        </div>
        <div class="pr-2 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <#list wirewghts as wirewght>
                <#if wirewght??>
                    <p>${wirewght} кг</p>
                </#if>
            </#list>
        </div>
        <div class="pr-2 col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <#list gridwghts as gridwght>
                <#if gridwght??>
                    <p>${gridwght} кг</p>
                </#if>
            </#list>
        </div>
        <div class="pr-2 col-lg-1 col-md-1 col-sm-1 col-1 dur">

        </div>
        <div class="col-lg-1 col-md-1 col-sm-1 col-1 dur">
            <#list sattls as sattl>
                <#if sattl??>
                    <p>${sattl} руб.</p>
                </#if>
            </#list>
        </div>
    </div>
    <div class="row">
        <div class="dur offset-lg-9 offset-md-9 offset-sm-9 offset-9 col-2 col-sm-2 col-md-2 col-lg-2">
            <b>Сумма: ${reportsumm}</b>
        </div>
    </div>
</div>

<style>
     .dur h2, p{
        border: 1px solid #888;
        padding: 10px;
        transition-duration: 0.8s;
    }
    .dur h2, p:hover{
        cursor: pointer;
        background: #333;
        color: 	#ffff00;
        border: 1px solid #000;
        transition-duration: 0.8s;
    }
    .dur b{
        border: 1px solid #aa0000;
        padding: 10px;
        transition-duration: 0.8s;
    }
    .dur b:hover{
        border: 1px solid #ff0000;
        padding: 10px;
        cursor: pointer;
        background: #880000;
        color: #ffffff;
        transition-duration: 0.8s;
    }
</style>

</@c.page>