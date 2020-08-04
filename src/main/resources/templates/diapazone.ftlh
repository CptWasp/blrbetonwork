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
                    <a class="dropdown-item" href="/diapazone">Отчет по диапазонам</a>
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


<div class="container p-4">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-10 col-12">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label>Начиная с: <input type="date" name="productdateone" class="form-control" /></label>
                </div>
                <div class="form-group">
                    <label>До: <input type="date" name="productdatesecond" class="form-control" />
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="form-control btn btn-success">Показать в этом диапазоне</button>
                </div>
            </form>
        </div>
    </div>
</div>





<div class="container-fluid">
    <div class="row mt-5">
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <h6>Номенклатура</h6>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <h6>Установленная цена</h6>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <h6>Изготовлено за диапазон</h6>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <h6>Продано за диапазон</h6>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <h6>Продано на сумму</h6>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <h6>Использовано людей</h6>
        </div>

    </div>



    <div class="row mt-4">
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <#list adminprdcts as adminprdct>
            <#if adminprdct??>
            <p>${adminprdct.adminproductname}</p>
            </#if>
        </#list>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <#list adminprdcts as adminprdct>
                <#if adminprdct??>
                    <p>${adminprdct.adminproducttotal} руб</p>
                </#if>
            </#list>
        </div>



        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <#list productionprdcts as productionprdct>
            <#if productionprdct??>
            <p>${productionprdct} шт.</p>
        </#if>
        </#list>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <#list salesprdcts as salesprdct>
            <#if salesprdct??>
            <p>${salesprdct} шт.</p>
        </#if>
        </#list>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <#list salesprdctstotals as salesprdctstotal>
            <#if salesprdctstotal??>
            <p>${salesprdctstotal} руб.</p>
        </#if>
        </#list>
        </div>
        <div class="dur col-lg-2 col-md-2 col-sm-2 col-2">
            <#list manprdcts as manprdct>
            <#if manprdct??>
            <p>${manprdct} чел.</p>
        </#if>
        </#list>
        </div>






    </div>
</div>

<style>
     .dur h5, p{
        border: 1px solid #888;
        padding: 10px;
        transition-duration: 0.8s;
    }
    .dur h5,p:hover{
        cursor: pointer;
        background: #333;
        color: 	#ffff00;
        border: 1px solid #000;
        transition-duration: 0.8s;
    }
    .dur h6{
        border: 1px solid #888;
        padding: 10px;
        transition-duration: 0.8s;
    }
    .dur h6:hover{
        cursor: pointer;
        background: #ffff00;
        color: 	#000000;
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